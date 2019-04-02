package com.jsj.design_pattern.productor_consumer.byblockingqueue;

import java.time.LocalTime;
import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable {

    private BlockingQueue<Object> queue;

    public Producer(BlockingQueue<Object> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            for (; ; ) {
                if (queue.offer(i)) {
                    System.out.println(Thread.currentThread().getName() + " 生产了 " + i);
                    break;
                }
            }
        }
    }
}
