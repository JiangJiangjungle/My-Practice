package com.jsj.data_structure.lru;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 基于HashMap的LRU实现
 *
 * @author jsj
 * @date 2019-01-15
 */
public class HashMapLRU<K, V> {
    private final int size;
    private final Map<K, Node<K, V>> map;
    private Node<K, V> head = null;
    private Node<K, V> tail = null;

    public HashMapLRU(int size) {
        this.size = size;
        this.map = new HashMap<>(size, 1.5f);
    }

    public void put(K key, V value) {
        Node<K, V> node = map.get(key);
        if (node == null) {
            node = new Node<>(key, value);
        } else {
            releaseNode(node);
        }
        setHead(node);
        map.put(key, node);
        if (map.size() <= this.size || this.tail == null) return;
        //若size超出范围，删除tail
        node = this.tail;
        releaseNode(node);
        map.remove(node.key);
    }

    public V get(K key) {
        Node<K, V> node = map.get(key);
        if (node == null) return null;
        releaseNode(node);
        setHead(node);
        return node.value;
    }

    public V remove(K key) {
        Node<K, V> node = map.remove(key);
        if (node == null) return null;
        releaseNode(node);
        return node.value;
    }

    public Set<Map.Entry<K, Node<K, V>>> entrySet() {
        return map.entrySet();
    }

    private void releaseNode(Node<K, V> node) {
        if (node == null) return;
        if (node == this.head) {
            this.head = node.next;
        }
        if (node == this.tail) {
            this.tail = node.prev;
        }
        if (node.prev != null) {
            node.prev.next = node.next;
        }
        if (node.next != null) {
            node.next.prev = node.prev;
        }
        node.prev = null;
        node.next = null;
    }

    private void setHead(Node<K, V> node) {
        if (this.head == null) {
            this.head = this.tail = node;
        } else {
            this.head.prev = node;
            node.next = this.head;
            this.head = node;
        }
    }

    static class Node<K, V> {
        Node<K, V> prev = null;
        Node<K, V> next = null;
        K key;
        V value;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }


    public static void main(String[] args) {
        HashMapLRU<String, String> lru = new HashMapLRU<>(3);
        lru.put("1", "1");
        lru.put("2", "2");
        lru.put("3", "3");
        lru.get("1");
        lru.put("4", "4");
        for (Map.Entry<String, Node<String, String>> entry : lru.entrySet()) {
            System.out.println(entry.getKey());
        }
    }
}
