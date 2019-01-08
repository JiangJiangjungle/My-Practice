package com.jsj.jdk.threadpool;

import java.util.HashSet;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadPool {
    private final int corePoolSize;
    private final int maxPoolSize;
    private final long keepAliveTime;
    private ThreadFactory threadFactory = new NamedThreadFactory();
    private final AtomicInteger threadCount = new AtomicInteger(0);
    private BlockingQueue<Runnable> taskQueue;

    /**
     * Set containing all worker threads in pool. Accessed only when
     * holding mainLock.
     */
    private final HashSet<Worker> workers = new HashSet<>();
    private final ReentrantLock mainLock = new ReentrantLock();

    public ThreadPool(int corePoolSize, int maxPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> taskQueue) {
        this.corePoolSize = corePoolSize;
        this.maxPoolSize = maxPoolSize;
        this.keepAliveTime = unit.toNanos(keepAliveTime);
        this.taskQueue = taskQueue;
    }

    public void exec(Runnable command) {
        if (command == null) throw new NullPointerException();
        if (threadCount.get() < corePoolSize) {
            if (addWorker(command, true)) {
                return;
            }
        }
        //当前线程数大于corePoolSize，则加入taskQueue,加入失败则创建非核心线程执行
        if (!taskQueue.offer(command)) {
            System.out.println("taskQueue加入失败.." + command.toString() + ", 准备再次新建线程执行task");
            if (!addWorker(command, false)) {
                reject(command);
            }
        }
    }

    /**
     * 添加新线程
     *
     * @param firstTask 是否执行任务
     * @param core      是否核心池
     * @return
     */
    private boolean addWorker(Runnable firstTask, boolean core) {
        //检查线程数约束并使count++;
        retry:
        for (; ; ) {
            int size = core ? corePoolSize : maxPoolSize;
            for (; ; ) {
                if (threadCount.get() >= size) {
                    return false;
                }
                int c = threadCount.get();
                if (threadCount.compareAndSet(c, c + 1)) {
                    break retry;
                }
            }
        }
        boolean workerStarted = false;
        boolean workerAdded = false;
        Worker w = new Worker(firstTask);
        final Thread t = w.thread;
        final ReentrantLock lock = this.mainLock;
        lock.lock();
        try {
            workers.add(w);
            // precheck that t is startable
            if (t.isAlive()) throw new IllegalThreadStateException();
            workerAdded = true;
        } finally {
            lock.unlock();
        }
        if (workerAdded) {
            //线程启动
            t.start();
            workerStarted = true;
        }
        return workerStarted;
    }

    /**
     * 线程获取任务并执行
     *
     * @param w
     */
    final void runWorker(Worker w) {
        Runnable task = w.firstTask;
        w.firstTask = null;
        while (task != null || (task = getTask()) != null) {
            try {
                task.run();
            } finally {
                task = null;
            }
        }
        //移除该线程
        processWorkerExit(w);
    }

    /**
     * 移除线程
     *
     * @param w
     */
    private void processWorkerExit(Worker w) {
        final ReentrantLock mainLock = this.mainLock;
        mainLock.lock();
        try {
            workers.remove(w);
        } finally {
            mainLock.unlock();
        }
    }

    /**
     * 获取任务
     *
     * @return
     */
    private Runnable getTask() {
        // Did the last poll() time out?
        boolean timedOut = false;
        for (; ; ) {
            int wc = threadCount.get();

            // 线程是否需要计时
            boolean timed = wc > corePoolSize;
            // 若线程获取task超时||当前线程数大于maxPoolSize||workQueue为空，则该线程数-1，准备消除该线程
            if ((wc > maxPoolSize || (timed && timedOut)) && (wc > 1 || taskQueue.isEmpty())) {
                wc = threadCount.get();
                if (threadCount.compareAndSet(wc, wc - 1)) return null;
                continue;
            }
            try {
                // 核心之外的线程需要计时获取task
                Runnable r = timed ? taskQueue.poll(keepAliveTime, TimeUnit.NANOSECONDS) : taskQueue.take();
                //task获取并返回
                if (r != null) return r;
                //task获取超时
                timedOut = true;
            } catch (InterruptedException retry) {
                //非超时
                timedOut = false;
            }
        }
    }

    private void reject(Runnable command) throws RuntimeException {
        System.out.println("线程创建失败，拒绝该线程任务：" + command.toString());
    }

    /**
     * 待修改
     */
    private class Worker implements Runnable {
        Runnable firstTask;
        Thread thread;

        public Worker(Runnable firstTask) {
            this.firstTask = firstTask;
            this.thread = threadFactory.newThread(this);
        }

        @Override
        public void run() {
            runWorker(this);
        }
    }

    public static void main(String[] args) throws Exception {
        ThreadPool threadPool = new ThreadPool(2, 5, 3000, TimeUnit.MILLISECONDS, new ArrayBlockingQueue<>(5));
        for (int i = 0; i < 20; i++) {
            threadPool.exec(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < 1; i++) {
                        System.out.println(Thread.currentThread().getName() + " is working! task: " + this.toString());
                    }
                }
            });
        }
    }
}
