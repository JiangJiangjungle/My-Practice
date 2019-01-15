package com.jsj.data_structure.lru;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 基于LinkedHashMapLRU的LRU实现
 *
 * @author jsj
 * @date 2019-01-15
 */
public class LinkedHashMapLRU<K, V> extends LinkedHashMap<K, V> {

    private final int size;

    public LinkedHashMapLRU(int initialCapacity) {
        super(initialCapacity, 1.5f, true);
        size = initialCapacity;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return this.size() > this.size;
    }

    public static void main(String[] args) {
        LinkedHashMapLRU<String, String> lru = new LinkedHashMapLRU<>(3);
        lru.put("1", "1");
        lru.put("2", "2");
        lru.put("3", "3");
        lru.put("1", "666");
        lru.put("4", "4");
        for (Map.Entry<String, String> entry : lru.entrySet()) {
            System.out.println(entry.getKey());
        }
    }
}
