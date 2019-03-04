package com.jsj.design_pattern.productor_consumer.byblockingqueue;

import com.jsj.jdk.impl.threadpool.NamedThreadFactory;

import java.util.concurrent.*;

public class Demo {

    public static void main(String[] args) {
        BlockingQueue<Object> queue = new LinkedBlockingQueue<>(10);
        ExecutorService threadPool = new ThreadPoolExecutor(4, 4, 0L,
                TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>(1000), new NamedThreadFactory());
        threadPool.execute(new Producer(queue));
        threadPool.execute(new Producer(queue));
        threadPool.execute(new Consumer(queue));
        threadPool.execute(new Consumer(queue));
    }
}
