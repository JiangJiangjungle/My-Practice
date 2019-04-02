package com.jsj.jdk.demo.juc;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.RecursiveTask;

/**
 * ForkJoinPool的简单使用示例
 */
public class ForkJoinPoolDemo {

    private static final int THRESHOLD = 5;

    /**
     * 无返回值的打印任务
     */
    public static class SendMsgTask extends RecursiveAction {

        private int start;
        private int end;
        private List<String> list;

        public SendMsgTask(int start, int end, List<String> list) {
            this.start = start;
            this.end = end;
            this.list = list;
        }

        @Override
        protected void compute() {
            if (end - start <= THRESHOLD) {
                for (int i = start; i < end; i++) {
                    System.out.println(Thread.currentThread().getName() + " send msg : " + list.get(i));
                }
            } else {
                int mid = (start + end) / 2;
                invokeAll(new SendMsgTask(start, mid, list), new SendMsgTask(mid, end, list));
            }
        }
    }

    /**
     * 有返回值的求和任务
     */
    public static class SumTask extends RecursiveTask<Integer> {

        private int start;
        private int end;
        private int[] arr;

        public SumTask(int start, int end, int[] arr) {
            this.start = start;
            this.end = end;
            this.arr = arr;
        }

        @Override
        protected Integer compute() {
            if (end - start <= THRESHOLD) {
                int sum = 0;
                System.out.println(Thread.currentThread().getName() + " 执行数组下标为 " + start+"-"+end+" 的求和任务");
                for (int i = start; i < end; i++) {
                    sum += arr[i];
                }
                return sum;
            } else {
                int mid = (start + end) / 2;
                SumTask task1 = new SumTask(start, mid, arr);
                SumTask task2 = new SumTask(mid, end, arr);
                task1.fork();
                task2.fork();
                return task1.join() + task2.join();
            }
        }
    }

    public static void main(String[] args) throws Exception {
        int len = 100;
        List<String> list = new ArrayList<>(len);
        for (int i = 0; i < len; i++) {
            list.add(i + "");
        }
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        forkJoinPool.submit(new SendMsgTask(0, list.size(), list));
        Thread.sleep(2000);

        System.out.println("------------------------------------------");
        int[] arr = new int[len];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 1;
        }
        ForkJoinTask<Integer> task = forkJoinPool.submit(new SumTask(0, arr.length, arr));
        Thread.sleep(2000);
        System.out.println(task.join());
    }
}
