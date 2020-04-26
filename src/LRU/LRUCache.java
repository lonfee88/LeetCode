/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package LRU;

import java.util.HashMap;
import java.util.Map;

/**
 * @author longfei.wlf
 * @version $Id: LRUCache.java, v 0.1 2020-04-26 11:38 AM longfei.wlf Exp $$
 */
public class LRUCache {
    private int                capacity;
    private Map<Integer, Node> map;
    private Node               head;
    private Node               tail;

    private class Node {
        public Integer key, val;
        public Node    pre;
        public Node    next;

        public Node(Integer key, Integer val) {
            this.key = key;
            this.val = val;
        }
    }

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<Integer, Node>(capacity * 4 / 3);

        head = new Node(null, null);
        tail = new Node(null, null);

        head.next = tail;
        head.pre = null;

        tail.pre = head;
        tail.next = null;

    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        } else {
            Node node = map.get(key);
            unlink(node);
            appendHead(node);
            return node.val;
        }

    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            unlink(map.get(key));
        }
        /**
         * 会导致更新key删除，因此必须再加入后，判断大于进行删除
         */
        /*
        if (map.size() == capacity) {
            Node toRemove = removeLast();
            map.remove(toRemove.key);
        }
        */
        Node node = new Node(key, value);
        appendHead(node);
        map.put(key, node);

        if (map.size() > capacity) {
            Node toRemove = removeLast();
            map.remove(toRemove.key);
        }
    }

    private Node removeLast() {
        Node node = tail.pre;

        node.pre.next = tail;
        tail.pre = node.pre;

        node.pre = null;
        node.next = null;

        map.remove(node.key);

        return node;
    }

    private void unlink(Node node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;

        node.pre = null;
        node.next = null;

    }

    private void appendHead(Node node) {
        node.next = head.next;
        node.pre = head;

        head.next.pre = node;
        head.next = node;
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2 /* 缓存容量 */);

        cache.put(2, 6);
        cache.get(1); // 返回  1
        cache.put(1, 5); // 该操作会使得密钥 2 作废
        cache.put(1, 2); // 该操作会使得密钥 1 作废
        cache.get(1); // 返回 -1 (未找到)
        cache.get(2); // 返回  3
    }

}