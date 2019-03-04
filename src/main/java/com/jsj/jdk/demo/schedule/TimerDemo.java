package com.jsj.jdk.demo.schedule;

import java.time.LocalTime;
import java.util.Timer;
import java.util.TimerTask;

public class TimerDemo extends TimerTask {
    private String string;

    public TimerDemo(String string) {
        this.string = string;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " print :" + string + "，now : " + LocalTime.now());
    }

    public static void main(String[] args) {
        //测试Timer
        TimerTask task = new TimerDemo("一次性任务");
        Timer timer = new Timer();
        //只执行一次
        System.out.println(LocalTime.now());
        timer.schedule(task, 1000L);
        //周期执行
        task = new TimerDemo("周期性任务");
        timer.schedule(task, 1000L, 2000L);
    }
}
