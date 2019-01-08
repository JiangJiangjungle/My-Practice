package com.jsj.jdk.lock;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;

/**
 * 仿照jdk源码实现ReentranLock
 *
 * @author jsj
 * @date 2019-01-08
 */
public class MyReentrantLock {
    private Sync sync;

    public MyReentrantLock() {
        this.sync = new NonfairSync();
    }

    public void lock() {
        sync.lock();
    }

    public void unlock() {
        this.sync.release(1);
    }

    public boolean tryLock() {
        return sync.nonfairTryAcquire(1);
    }

    abstract static class Sync extends AbstractQueuedSynchronizer {
        /**
         * 获取锁直至成功
         */
        abstract void lock();

        @Override
        protected final boolean tryRelease(int releases) {
            int c = getState() - releases;
            if (Thread.currentThread() != getExclusiveOwnerThread())
                throw new IllegalMonitorStateException();
            boolean free = false;
            if (c == 0) {
                free = true;
                setExclusiveOwnerThread(null);
            }
            setState(c);
            return free;
        }

        /**
         * 尝试获取非公平锁，只尝试一次
         *
         * @param arg
         * @return
         */
        public boolean nonfairTryAcquire(int arg) {
            Thread current = Thread.currentThread();
            int s = getState();
            //若锁还没被获取，则尝试获取锁
            if (s == 0) {
                if (compareAndSetState(0, arg)) {
                    setExclusiveOwnerThread(current);
                    return true;
                }
            }
            //若当前线程已经是独占线程，则可以重入
            else if (current == getExclusiveOwnerThread()) {
                int now = s + arg;
                if (now < 0) throw new Error("AQS的state赋值错误: " + now);
                setState(now);
                return true;
            }
            //获取锁失败
            return false;
        }
    }

    /**
     * 非公平锁的实现
     */
    static final class NonfairSync extends Sync {
        @Override
        final void lock() {
            //首先尝试一次CAS修改state值，修改成功则获得锁
            if (compareAndSetState(0, 1)) {
                //设置当前锁的独占线程
                setExclusiveOwnerThread(Thread.currentThread());
            } else {
                //失败则调用acquire继续获取锁，直到成功
                acquire(1);
            }
        }

        @Override
        protected boolean tryAcquire(int arg) {
            return super.nonfairTryAcquire(arg);
        }
    }
}
