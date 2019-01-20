package com.jsj.jdk.demo;

import com.jsj.jdk.impl.threadpool.NamedThreadFactory;

import java.util.concurrent.*;

public class SemaphereDemo {

    static class Task implements Runnable {
        private Semaphore semaphore;

        public Task(Semaphore semaphore) {
            this.semaphore = semaphore;
        }

        @Override
        public void run() {
            try {
                semaphore.acquire();
                System.out.println(Thread.currentThread().getName() + " working...");
                Thread.sleep(4000);
                System.out.println(Thread.currentThread().getName() + " done!");
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                semaphore.release();
            }
        }
    }

    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(3);
        ExecutorService threadPool = new ThreadPoolExecutor(5, 5, 0L,
                TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>(5), new NamedThreadFactory());
        threadPool.execute(new Task(semaphore));
        threadPool.execute(new Task(semaphore));
        threadPool.execute(new Task(semaphore));
        threadPool.execute(new Task(semaphore));
        threadPool.execute(new Task(semaphore));
    }
}
