package com.jsj.jdk.demo;

import com.jsj.jdk.impl.threadpool.NamedThreadFactory;

import java.time.LocalTime;
import java.util.concurrent.*;

public class CountDownLatchDemo {

    static class Task implements Runnable {
        private CountDownLatch countDownLatch;

        public Task(CountDownLatch countDownLatch) {
            this.countDownLatch = countDownLatch;
        }

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + " working...");
            try {
                Thread.sleep(2000);
            } catch (Exception e) {
            }
            System.out.println(Thread.currentThread().getName() + " done!");
            countDownLatch.countDown();
        }
    }

    public static void main(String[] args) throws Exception {
        CountDownLatch countDownLatch = new CountDownLatch(3);
        ExecutorService threadPool = new ThreadPoolExecutor(5, 5, 0L,
                TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>(5), new NamedThreadFactory());
        threadPool.execute(new Task(countDownLatch));
        threadPool.execute(new Task(countDownLatch));
        threadPool.execute(new Task(countDownLatch));
        System.out.println("A few moments later... : "+ LocalTime.now());
        countDownLatch.await();
        System.out.println("Every Thing OK! : "+ LocalTime.now());
    }
}
