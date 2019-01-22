package com.jsj.jdk.demo.juc;

import com.jsj.jdk.impl.threadpool.NamedThreadFactory;

import java.util.concurrent.*;

public class FutureTaskDemo {

    public static class Task implements Callable<Integer> {
        int num1;
        int num2;

        public Task(int num1, int num2) {
            this.num1 = num1;
            this.num2 = num2;
        }

        @Override
        public Integer call() throws Exception {
            System.out.println(Thread.currentThread().getName() + "正在执行...");
            Thread.sleep(3000);
            int r = this.num1 + this.num2;
            System.out.println(Thread.currentThread().getName() + "执行完毕，返回结果：" + r);
            return r;
        }
    }

    public static void main(String[] args) throws Exception {
        ExecutorService threadPool = new ThreadPoolExecutor(5, 5, 0L,
                TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>(5), new NamedThreadFactory());
        FutureTask<Integer> futureTask = new FutureTask<>(new Task(1, 2));
        threadPool.submit(futureTask);
        System.out.println(Thread.currentThread().getName()+"获取线程执行结果：" + futureTask.get());
    }
}
