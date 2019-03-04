package com.jsj.jdk.demo.juc;

import java.util.concurrent.locks.ReentrantLock;

public class Demo {

    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        lock.lock();
        try {
            System.out.println(Thread.holdsLock(lock));
            System.out.println(lock.isHeldByCurrentThread());
        }finally {
            lock.unlock();
        }
    }
}
