package com.jsj.jdk.demo.juc;

/**
 * 测试Thread的join方法
 */
public class ThreadJoinDemo extends Thread {
    private int val;
    private Thread thread;

    public ThreadJoinDemo(int val, Thread thread) {
        this.val = val;
        this.thread = thread;
    }

    @Override
    public void run() {
        try {
            while (thread != null && thread.getState() == State.NEW) {
                thread.join();
            }
        } catch (Exception ignored) {
        }
        System.out.println(Thread.currentThread().getName() + " print val:" + val);
    }

    public static void main(String[] args) throws Exception {
        Thread thread1 = new ThreadJoinDemo(1, null);
        Thread thread2 = new ThreadJoinDemo(2, thread1);
        Thread thread3 = new ThreadJoinDemo(3, thread2);
        thread3.start();
        Thread.sleep(100);
        thread2.start();
        Thread.sleep(100);
        thread1.start();
    }
}
