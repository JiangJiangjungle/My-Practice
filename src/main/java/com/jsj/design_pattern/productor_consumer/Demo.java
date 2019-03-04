package com.jsj.design_pattern.productor_consumer;


import com.jsj.jdk.impl.threadpool.NamedThreadFactory;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Demo {

    public static void main(String[] args) throws Exception {
        Queue<String> queue = new ArrayDeque<>(20);
        ExecutorService threadPool = new ThreadPoolExecutor(4, 4, 0L,
                TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>(1000), new NamedThreadFactory());
        threadPool.execute(new Consumer(queue));
        threadPool.execute(new Consumer(queue));
        threadPool.execute(new Productor(queue,20));
        threadPool.execute(new Productor(queue,20));
    }
}
