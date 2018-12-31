package com.jsj.data_structure;

import java.util.Comparator;
import java.util.Random;

public class SkipList<K, V> {
    public static int HEAD = 1;
    public static int TAIL = 2;
    private Random random = new Random();
    private Comparator<K> comparator;
    private Node head;
    private Node tail;
    private int length = 0;
    private int level = 1;

    public SkipList(Comparator<K> comparator) {
        this.comparator = comparator;
        this.head = new Node(HEAD);
        this.tail = new Node(TAIL);
        this.head.next = this.tail;
    }

    public void put(K key, V value) {
        int k = randomLevel();
        //确定层数
        if (k > this.level) {
            Node node, node2;
            for (int i = level; i < k; i++) {
                node = new Node(HEAD);
                node2 = new Node(TAIL);
                node.down = this.head;
                node2.down = this.tail;
                node.next = node2;
                this.head = node;
                this.tail = node2;
            }
            this.level = k;
        }
        //插入
        Node last = null;
        Node layerHead = this.head;
        Node now;
        for (int i = k; i > 0; i--) {
            now = new Node(key, value);
            this.insertToList(layerHead, now);
            if (last != null) {
                last.down = now;
            }
            last = now;
            layerHead = layerHead.down;
        }
        length++;
    }

    public V get(K key) {
        Node now = this.head;
        for (; now != null; ) {
            if (!now.next.isTail() && comparator.compare(now.next.key, key) <= 0) {
                if (comparator.compare(now.next.key, key) == 0) {
                    return now.next.value;
                }
                now = now.next;
            } else {
                now = now.down;
            }
        }
        return null;
    }

    public void remove(K key) {
        Node now = this.head;
        boolean removed = false;
        for (; now != null; ) {
            if (!now.next.isTail() && comparator.compare(now.next.key, key) <= 0) {
                if (comparator.compare(now.next.key, key) == 0) {
                    now.next = now.next.next;
                    now = now.down;
                    removed = true;
                    continue;
                }
                now = now.next;
            } else {
                now = now.down;
            }
        }
        if (removed) {
            length--;
        }
    }

    private void insertToList(Node nowHead, Node node) {
        Node now = nowHead;
        for (; now != null; ) {
            if (!now.next.isTail() && comparator.compare(now.next.key, node.key) <= 0) {
                if (!now.next.isTail() && comparator.compare(now.next.key, node.key) == 0) {
                    now.next.value = node.value;
                    return;
                }
                now = now.next;
            } else {
                node.next = now.next;
                now.next = node;
                return;
            }
        }
    }

    private int randomLevel() {
        int k = 1;
        while (0 == random.nextInt(2)) {
            k++;
        }
        return k;
    }

    public int size() {
        return this.length;
    }


    /**
     * 内部节点
     */
    private class Node {
        K key;
        V value;
        int sign;
        Node next;
        Node down;

        public Node(int sign) {
            this.sign = sign;
        }

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public Node(Node node) {
            this.key = node.key;
            this.value = node.value;
        }

        private boolean isTail() {
            return sign == TAIL;
        }
    }
}
