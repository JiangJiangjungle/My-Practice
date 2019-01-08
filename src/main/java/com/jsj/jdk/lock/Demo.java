package com.jsj.jdk.lock;

import com.jsj.jdk.threadpool.NamedThreadFactory;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Demo implements Runnable {
    public static int value;

    private MyReentrantLock lock;

    public Demo() {
        this.lock = new MyReentrantLock();
    }

    @Override
    public void run() {
        lock.lock();
        try {
            value++;
            System.out.println(Thread.currentThread().getName() + "is working! value now: " + value);
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) throws Exception{
        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(50, 50, 0L,
                TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>(5), new NamedThreadFactory());
        Demo demo = new Demo();
        for (int i = 0; i < 50; i++) {
            threadPool.execute(demo);
        }
        Thread.sleep(10000);
        System.out.println(Thread.currentThread().getName() + "-------------value now: " + value);
    }
}
