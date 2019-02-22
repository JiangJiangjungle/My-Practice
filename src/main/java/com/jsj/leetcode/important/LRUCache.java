package com.jsj.leetcode.important;

import java.util.HashMap;
import java.util.Map;

/**
 * 运用你所掌握的数据结构，设计和实现一个  LRU (最近最少使用) 缓存机制。它应该支持以下操作： 获取数据 get 和 写入数据 put 。
 * <p>
 * 获取数据 get(key) - 如果密钥 (key) 存在于缓存中，则获取密钥的值（总是正数），否则返回 -1。
 * 写入数据 put(key, value) - 如果密钥不存在，则写入其数据值。当缓存容量达到上限时，它应该在写入新数据之前删除最近最少使用的数据值，从而为新的数据值留出空间。
 * <p>
 * 进阶:
 * <p>
 * 你是否可以在 O(1) 时间复杂度内完成这两种操作？
 * <p>
 * 示例:
 */
public class LRUCache {
    private Node<Integer, Integer> head = null;
    private Node<Integer, Integer> tail = null;
    private int capacity;
    private Map<Integer, Node<Integer, Integer>> map;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>(capacity, 1.5f);
    }

    public int get(int key) {
        Node<Integer, Integer> node = map.get(key);
        if (node != null) {
            free(node);
            insert(node);
            return node.val;
        }
        return -1;
    }

    public void put(int key, int value) {
        Node<Integer, Integer> node;
        if (map.containsKey(key)) {
            node = map.get(key);
            node.val = value;
            free(node);
        } else {
            node = new Node<>(key, value);
            if (map.size() == this.capacity && tail != null) {
                map.remove(tail.key);
                free(tail);
            }
            map.put(key, node);
        }
        insert(node);
    }

    private void insert(Node<Integer, Integer> node) {
        node.next = head;
        if (head != null) {
            head.prev = node;
        }
        head = node;
        if (tail == null) {
            tail = head;
        }
    }

    private void free(Node<Integer, Integer> node) {
        if (head == tail) {
            head = null;
            tail = head;
        } else if (node == head) {
            head = head.next;
            head.prev = null;
        } else if (node == tail) {
            tail = tail.prev;
            tail.next = null;
        } else {
            Node<Integer, Integer> prev = node.prev;
            Node<Integer, Integer> next = node.next;
            prev.next = next;
            next.prev = prev;
            node.prev = null;
            node.next = null;
        }
    }

    private class Node<K, V> {
        K key;
        V val;
        Node<K, V> next;
        Node<K, V> prev;

        public Node(K key, V val) {
            this.key = key;
            this.val = val;
        }
    }

    public static void main(String[] args) {
        /* 缓存容量 */
        LRUCache cache = new LRUCache(2);
        // 返回  1
        cache.put(2, 6);
        System.out.println(cache.get(1));
        cache.put(1, 5);
        cache.put(1, 2);
        System.out.println(cache.get(1));
        System.out.println(cache.get(2));
    }
}
