package com.jsj.design_pattern.productor_consumer.byblockingqueue;

import java.time.LocalDateTime;
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
            try {
                queue.put(i);
                System.out.printf("%s, 线程%s 生产了 %d\n", LocalDateTime.now(), Thread.currentThread().getName(), i);
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
