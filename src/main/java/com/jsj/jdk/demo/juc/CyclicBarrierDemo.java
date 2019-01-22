package com.jsj.jdk.demo.juc;

import com.jsj.jdk.impl.threadpool.NamedThreadFactory;

import java.time.LocalTime;
import java.util.concurrent.*;

public class CyclicBarrierDemo {

    static class Task implements Runnable {
        private CyclicBarrier barrier;

        public Task(CyclicBarrier barrier) {
            this.barrier = barrier;
        }

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + " working...");
            try {
                Thread.sleep(2000);
                barrier.await();
                System.out.println(Thread.currentThread().getName() + " done!");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws Exception {
        CyclicBarrier barrier = new CyclicBarrier(3);
        ExecutorService threadPool = new ThreadPoolExecutor(2, 2, 0L,
                TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>(5), new NamedThreadFactory());
        threadPool.execute(new Task(barrier));
        threadPool.execute(new Task(barrier));
        System.out.println("A few moments later... : " + LocalTime.now());
        Thread.sleep(6000);
        barrier.await();
        System.out.println("Every Thing OK! : " + LocalTime.now());
        threadPool.execute(new Task(barrier));
        threadPool.execute(new Task(barrier));
        System.out.println("try again... : " + LocalTime.now());
        Thread.sleep(6000);
        barrier.await();
        System.out.println("OK! : " + LocalTime.now());
    }
}
