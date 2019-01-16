package com.jsj.design_pattern.productor_consumer;

import java.util.Queue;

public class Consumer implements Runnable {
    private final Queue<String> queue;

    public Consumer(Queue<String> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true) {
            try {
                synchronized (queue) {
                    while (queue.size() == 0) {
                        queue.wait();
                    }
                    System.out.println(Thread.currentThread().getName() + " consume:" + queue.poll());
                    queue.notifyAll();
                }
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName() + " interrupt!");
            }
        }
    }
}
