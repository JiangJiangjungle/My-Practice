package com.jsj.jdk.demo.reference;

import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;

public class ReferenceDemo {

    public static void main(String[] args) throws Exception {
        ReferenceQueue referenceQueue = new ReferenceQueue();
        PhantomReference<Object> pr = new PhantomReference<Object>(new Object(), referenceQueue);
        System.out.println(pr.get());
        System.gc();
        System.out.println(pr.get());
        Reference<Object> r = (Reference<Object>) referenceQueue.poll();
        if (r != null) {
            System.out.println("回收");
        }

    }

}
