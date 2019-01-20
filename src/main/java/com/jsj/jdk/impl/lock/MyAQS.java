package com.jsj.jdk.impl.lock;

import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.util.concurrent.locks.LockSupport;

/**
 * 仿照jdk源码实现AQS,暂时存在bug
 *
 * @author jsj
 * @date 2019-01-08
 */
public abstract class MyAQS {
    private volatile int state = 0;
    private volatile Node head;
    private volatile Node tail;

    /**
     * The current owner of exclusive mode synchronization.
     */
    private transient Thread exclusiveOwnerThread;

    /**
     * 设置当前占用线程
     */
    protected final void setExclusiveOwnerThread(Thread thread) {
        exclusiveOwnerThread = thread;
    }

    /**
     * 获取当前占用线程
     */
    protected final Thread getExclusiveOwnerThread() {
        return exclusiveOwnerThread;
    }

    /**
     * 尝试获取资源
     *
     * @param arg
     */
    protected abstract boolean tryAcquire(int arg);

    /**
     * 尝试释放资源
     *
     * @param arg
     * @return
     */
    protected abstract boolean tryRelease(int arg);

    /**
     * 获取资源
     *
     * @param arg
     */
    public final void acquire(int arg) {
        //若尝试一次争抢资源失败，并进入等待状态，则
        if (!tryAcquire(arg)) {
            acquireQueued(addWaiter(Node.EXCLUSIVE), arg);
        }
    }

    /**
     * 释放资源
     *
     * @param arg
     * @return
     */
    public final boolean release(int arg) {
        //保证当前线程一定是获得锁的线程
        if (tryRelease(arg)) {
            Node h = head;
            //找到head节点并唤醒队列中下一个等待线程
            if (h != null) unparkSuccessor(h);
            return true;
        }
        return false;
    }

    /**
     * 线程进入等待状态，直至被其他线程唤醒并取得资源
     *
     * @param node
     * @param arg
     * @return
     */
    private boolean acquireQueued(final Node node, int arg) {
        boolean interrupted = false;
        for (; ; ) {
            //获取前驱节点
            final Node p = node.predecessor();
            //若为head则尝试一次争抢资源
            if (p == head && tryAcquire(arg)) {
                //若争取成功就将自己设置为head
                setHead(node);
                // 前驱节点应该被回收，help GC
                p.next = null;
                return interrupted;
            }
            //检查前驱节点的状态,若前驱节点的状态为Node.SIGNAL，则当前节点进行线程等待
            if (shouldParkAfterFailedAcquire(p, node)) {
                LockSupport.park(this);
            }
        }
    }

    /**
     * 检查前驱节点的状态
     */
    private static boolean shouldParkAfterFailedAcquire(Node pred, Node node) {
        int ws = pred.waitStatus;
        //若前驱节点等待唤醒，则返回true
        if (ws == Node.SIGNAL) return true;
        //若前驱节点未进入等待状态则使前驱进入待唤醒状态
        if (ws == 0) {
            compareAndSetWaitStatus(pred, ws, Node.SIGNAL);
        }
        //否则一直前移，直到找到等待唤醒状态的前驱节点，将中间的非正常状态的节点移除
        do {
            node.prev = pred = pred.prev;
        } while (pred.waitStatus >= 0);
        pred.next = node;
        return false;
    }

    /**
     * 唤醒下一节点
     *
     * @param node
     */
    private void unparkSuccessor(Node node) {
        //找到下一个需要唤醒的结点s
        Node s = node.next;
        if (s == null || s.waitStatus > 0) {
            s = null;
            //若当前节点的下一个节点为null或状态不正常，找到离node最近的正常节点
            for (Node t = tail; t != null && t != node; t = t.prev) {
                if (t.waitStatus <= 0) s = t;
            }
        }
        //唤醒该线程,LockSupport的unpark操作不会抛出InterruptedException
        if (s != null) LockSupport.unpark(s.thread);
    }

    /**
     * 将线程添加到等待队列尾部,返回Node
     */
    private Node addWaiter(Node mode) {
        Node node = new Node(Thread.currentThread(), mode);
        // 尝试一次将线程添加到队列尾部
        Node pred = tail;
        if (pred != null) {
            node.prev = pred;
            if (compareAndSetTail(pred, node)) {
                pred.next = node;
                return node;
            }
        }
        //尝试失败则通过enq入队
        enq(node);
        //返回Node
        return node;
    }

    /**
     * 线程添加到等待队列尾部，直至成功
     *
     * @param node
     */
    private void enq(Node node) {
        for (; ; ) {
            Node t = tail;
            if (t == null) {
                //若tail为null，则初始化一个Node作为head和tail
                if (compareAndSetHead(new Node())) {
                    tail = head;
                }
            } else {
                node.prev = t;
                if (compareAndSetTail(t, node)) {
                    t.next = node;
                    return;
                }
            }
        }
    }

    private void setHead(Node node) {
        this.head = node;
    }

    protected final int getState() {
        return state;
    }

    protected final void setState(int newState) {
        state = newState;
    }

    /**
     * CAS相关操作
     */
    static {
        try {
            unsafe = getUnsafe();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static Unsafe getUnsafe() throws Exception {
        Field field = Unsafe.class.getDeclaredField("theUnsafe");
        field.setAccessible(true);
        return (Unsafe) field.get(null);
    }

    private static Unsafe unsafe;
    private static final long stateOffset;
    private static final long headOffset;
    private static final long tailOffset;
    private static final long waitStatusOffset;
    private static final long nextOffset;

    static {
        try {
            stateOffset = unsafe.objectFieldOffset
                    (MyAQS.class.getDeclaredField("state"));
            headOffset = unsafe.objectFieldOffset
                    (MyAQS.class.getDeclaredField("head"));
            tailOffset = unsafe.objectFieldOffset
                    (MyAQS.class.getDeclaredField("tail"));
            waitStatusOffset = unsafe.objectFieldOffset
                    (MyAQS.Node.class.getDeclaredField("waitStatus"));
            nextOffset = unsafe.objectFieldOffset
                    (MyAQS.Node.class.getDeclaredField("next"));
        } catch (Exception ex) {
            throw new Error(ex);
        }
    }

    private final boolean compareAndSetHead(Node update) {
        return unsafe.compareAndSwapObject(this, headOffset, null, update);
    }

    private final boolean compareAndSetTail(Node pred, Node node) {
        return unsafe.compareAndSwapObject(this, tailOffset, pred, node);
    }

    private static final boolean compareAndSetWaitStatus(Node node, int expect, int update) {
        return unsafe.compareAndSwapInt(node, waitStatusOffset, expect, update);
    }

    protected final boolean compareAndSetState(int expect, int update) {
        return unsafe.compareAndSwapInt(this, stateOffset, expect, update);
    }

    /**
     * 静态内部类Node
     */
    static final class Node {
        /**
         * 独占模式
         */
        static final Node EXCLUSIVE = null;
        /**
         * 线程取消争抢
         */
        static final int CANCELLED = 1;
        /**
         * 线程等待唤醒
         */
        static final int SIGNAL = -1;

        volatile int waitStatus;
        volatile Thread thread;
        volatile Node prev;
        volatile Node next;
        Node nextWaiter;

        /**
         * 返回前驱节点
         */
        final Node predecessor() throws NullPointerException {
            Node p = prev;
            if (p == null) throw new NullPointerException();
            return p;
        }

        public Node() {
        }

        Node(Thread thread, Node mode) {     // Used by addWaiter
            this.nextWaiter = mode;
            this.thread = thread;
        }
    }
}
