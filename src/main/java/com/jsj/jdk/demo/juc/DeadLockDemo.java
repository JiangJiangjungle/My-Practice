package com.jsj.jdk.demo.juc;

public class DeadLockDemo extends Thread {

    private final Object lock1;
    private final Object lock2;

    public DeadLockDemo(Object lock1, Object lock2) {
        this.lock1 = lock1;
        this.lock2 = lock2;
    }

    @Override
    public void run() {
        synchronized (lock1) {
            try {
                System.out.println(Thread.currentThread().getName() + " get " + lock1 + ", waitting to get" + lock2);
                Thread.sleep(1000);
                synchronized (lock2) {
                    System.out.println(Thread.currentThread().getName() + " get " + lock2);
                }
            } catch (InterruptedException ingore) {

            }
        }
    }

    public static void main(String[] args) {
        Object lock1 = "lock1";
        Object lock2 = "lock2";
        Thread thread1 = new DeadLockDemo(lock1, lock2);
        Thread thread2 = new DeadLockDemo(lock2, lock1);
        thread1.start();
        thread2.start();
    }
}
