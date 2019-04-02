package com.jsj.data_structure.skiplist;

import com.jsj.data_structure.skiplist.SkipList;

import java.util.Comparator;

public class Demo {

    public static void main(String[] args) {
        SkipList<Integer, String> skipList = new SkipList<>(Comparator.comparingInt(o -> o));
        skipList.put(1, "jsj");
        skipList.put(2, "whs");
        skipList.put(2, "wsh");
        skipList.put(0, "lll");
        System.out.println(skipList.size());
        System.out.println(skipList.get(2));
        skipList.remove(2);
        System.out.println(skipList.size());
        System.out.println(skipList.get(2));
    }
}
