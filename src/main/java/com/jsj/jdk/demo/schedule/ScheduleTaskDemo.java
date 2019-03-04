package com.jsj.jdk.demo.schedule;

import com.jsj.jdk.impl.threadpool.NamedThreadFactory;

import java.time.LocalTime;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ScheduleTaskDemo implements Runnable {
    private String string;

    public ScheduleTaskDemo(String string) {
        this.string = string;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " start :" + string + "，now : " + LocalTime.now());
        try {
            //模拟任务耗时
            Thread.sleep(3000);
        } catch (InterruptedException i) {
        }
        System.out.println(Thread.currentThread().getName() + " end :" + string + "，now : " + LocalTime.now());
    }

    public static void main(String[] args) {
        //测试ScheduledThreadPoolExecutor
        ScheduledThreadPoolExecutor executorService = new ScheduledThreadPoolExecutor(1, new NamedThreadFactory());
        Runnable task = new ScheduleTaskDemo("一次性任务");
        //只执行一次
        System.out.println(LocalTime.now());
        executorService.schedule(task, 1000L, TimeUnit.MILLISECONDS);
        executorService.schedule(task, 1000L, TimeUnit.MILLISECONDS);
        //周期执行
        task = new ScheduleTaskDemo("周期性任务");
        executorService.scheduleAtFixedRate(task, 1000L, 1000L, TimeUnit.MILLISECONDS);
    }
}
