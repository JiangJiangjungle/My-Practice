package com.jsj.design_pattern.productor_consumer.byblockingqueue;

import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable {

    private BlockingQueue<Object> queue;

    public Consumer(BlockingQueue<Object> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        for (; ; ) {
            Object e = queue.poll();
            if (e != null) {
                System.out.println(Thread.currentThread().getName() + " 消费了 " + e.toString());
            }
        }
    }
}
