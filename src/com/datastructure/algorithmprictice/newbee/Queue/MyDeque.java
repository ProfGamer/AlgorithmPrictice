package com.datastructure.algorithmprictice.newbee.Queue;

import com.datastructure.algorithmprictice.newbee.LinkedList.Node;

/**
 * 分别使用循环数组 和 双向链表来实现双端队列
 */
public class MyDeque {
    public static class DoubleNodeDeque implements IDeque{
        public Node.DoubleNode head;
        public Node.DoubleNode tail;
        public int size;
        public int maxLimit;

        public DoubleNodeDeque(int limit) {
            this.head = null;
            this.tail = null;
            this.size = 0;
            this.maxLimit = limit;
        }


        @Override
        public boolean insertFront(int value) {
            if (isFull()) return false;
            Node.DoubleNode newNode = new Node.DoubleNode();
            newNode.value = value;
            newNode.next = head;
            if (head == null) {
                tail = newNode;
            } else {
                head.last = newNode;
            }
            head = newNode;
            size++;
            return true;
        }

        @Override
        public boolean deleteLast() {
            if (isEmpty()) return false;
            tail = tail.last;
            if (tail == null) {
                head = null;
            } else {
                tail.next = null;
            }
            size--;
            return true;
        }

        @Override
        public int getRear() {

            return isEmpty() ? -1 : tail.value;
        }

        @Override
        public boolean insertLast(int value) {
            if (isFull()) return false;
            Node.DoubleNode newNode = new Node.DoubleNode();
            newNode.value = value;
            newNode.last = tail;
            if (tail == null) {
                head = newNode;
            } else {
                tail.next = newNode;
            }
            tail = newNode;
            size++;
            return true;
        }

        @Override
        public boolean deleteFront() {
            if (isEmpty()) return false;
            head = head.next;
            if (head == null) {
                tail = null;
            } else {
                head.last = null;
            }
            size--;
            return true;
        }

        @Override
        public int getFront() {
            return isEmpty() ? -1 : head.value;
        }

        @Override
        public boolean isEmpty() {
            return size == 0;
        }

        @Override
        public boolean isFull() {
            return size == maxLimit;
        }
    }
}
