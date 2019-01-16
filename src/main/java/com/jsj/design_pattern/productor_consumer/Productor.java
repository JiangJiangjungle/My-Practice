package com.jsj.design_pattern.productor_consumer;

import java.util.Queue;

public class Productor implements Runnable {
    private final Queue<String> queue;
    private int size;

    public Productor(Queue<String> queue, int size) {
        this.queue = queue;
        this.size = size;
    }

    @Override
    public void run() {

        try {
            while (true) {
                synchronized (queue) {
                    while (queue.size() == size) {
                        queue.wait();
                    }
                    int i = (int) (Math.random() * 10);
                    queue.add("" + i);
                    System.out.println(Thread.currentThread().getName() + " produce: " + i);
                    queue.notifyAll();
                }
            }
        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getName() + " interrupt!");
        }
    }
}
