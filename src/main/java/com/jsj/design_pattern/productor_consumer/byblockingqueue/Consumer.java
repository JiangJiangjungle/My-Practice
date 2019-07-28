package com.jsj.design_pattern.productor_consumer.byblockingqueue;

import java.time.LocalDateTime;
import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable {

    private BlockingQueue<Object> queue;

    public Consumer(BlockingQueue<Object> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        for (; ; ) {
            try {
                Object e = queue.take();
                System.out.printf("%s, 线程%s 消费了 %s\n", LocalDateTime.now(), Thread.currentThread().getName(), e.toString());
            } catch (InterruptedException i) {
                i.printStackTrace();
            }
        }
    }
}
