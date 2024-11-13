package com.datastructure.algorithmprictice.advanced.dataStructureDesign.LRU;

import java.util.HashMap;

public class LRUCache {
    /**
     * 如果使用Java自带的Deque测试案例时间通不过
     */
    class Node {
        int key;
        int value;
        Node pre;
        Node next;
        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }

    }

    class LinkedList {
        Node head; // 最早加入链表的节点
        Node tail; // 最近操作过的节点

        public LinkedList() {
            this.head = null;
            this.tail = null;
        }

        /**
         * 向双向链表中添加节点
         * 需要考虑是否是第一个节点
         */
        public void addNodeToTail(Node node){
            if (head == null) {
                this.head = node;
                this.tail = node;
            } else {
                tail.next = node;
                node.pre = tail;
                tail = tail.next;
            }
        }

        /**
         * 删除并返回头节点
         * @return
         */
        public Node removeHead(){
            if (this.head == null) return null;
            Node result = head;

            if (head == tail) {
                head = null;
                tail = null;
            } else {
                head = head.next;
                head.pre = null;
                result.next = null;
            }

            return result;
        }

        public void moveNodeToTail(Node node) {
            if (node == null || node == tail) return;
            if (head == node) {
                head = node.next;
                head.pre = null;
            } else {
                node.pre.next = node.next;
                node.next.pre = node.pre;

            }
            tail.next = node;
            node.next = null;
            node.pre = tail;
            tail = node;
        }
    }

    private HashMap<Integer, Node> map;

    private LinkedList cache;

    private int capacity;


    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        cache = new LinkedList();
    }

    public int get(int key) {
        // 检查是否存在于map中, 如果不存在则直接返回-1
        if (!map.containsKey(key)) return -1;

        // 如果存在于map中那么就先记录该节点的值, 并将该节点移动到tail位置
        Node node = map.get(key);
        cache.moveNodeToTail(node);
        return node.value;
    }

    public void put(int key, int value) {
        // 检查该Node是否存在
        if (map.containsKey(key)) {
            // 更新
            Node node = map.get(key);
            node.value = value;
            cache.moveNodeToTail(node);
        } else {
            // 不存在则新建
            Node node = new Node(key, value);
            if (capacity == map.size()) {
                map.remove(cache.removeHead().key);
            }
            cache.addNodeToTail(node);
            map.put(key, node);
        }
    }


}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */