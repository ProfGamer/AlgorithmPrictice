package com.datastructure.algorithmprictice.newbee.Queue;

import com.datastructure.algorithmprictice.newbee.LinkedList.Node;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 使用Java中的内置Queue
 * 自己使用链表和数组构建Queue
 * 使用环状数组实现Queue
 */
public class MyQueue {
    public static class JavaBuildInQueue {
        // Java中的Queue如果用链表实现使用的是双向链表, 虽然操作都是O(1)但是常数时间较大
        public Queue<Integer> queue = new LinkedList<>();

        public boolean isEmpty() {
            return queue.isEmpty();
        }

        // 将元素加入Queue的尾部
        public void offer(Integer num) {
            queue.offer(num);
        }

        // 从Queue头部弹出元素
        public Integer poll() {
            return queue.poll();
        }

        // 查看此时Queue中头部元素
        public Integer peek() {
            return queue.peek();
        }

        // 返回Queue Size
        public int size() {
            return queue.size();
        }

    }

    // 使用单链表构建Queue
    public static class SingleNodeQueue {
        public Node.SingleNode head = null;
        public int size = 0;
        public Node.SingleNode tail = null;

        public boolean isEmpty() {
            return size == 0;
        }

        public void offer(int num) {
            if (size == 0) {
                head = new Node.SingleNode(num);
                tail = head;
            } else {
                tail.next = new Node.SingleNode(num);
                tail = tail.next;
            }
            size++;
        }

        public int poll() {
            if (size == 0) {
                return -1;
            }
            int returnValue = head.value;
            head = head.next;
            size--;
            return returnValue;
        }

        public int peek() {
            if (isEmpty()) {
                return -1;
            }
            return head.value;
        }

        public int size(){
            return size;
        }
    }

    /**
     * 如果已知插入队列的次数最大为n, 那么我们可以使用数组来实现Queue
     */
    public static class ArrayQueue {
        public int[] queue;
        public int l;
        public int r;

        public ArrayQueue(int maxInsertTime) {
            queue = new int[maxInsertTime];
            l = r = 0;
        }

        public boolean isEmpty() {
            return l == r;
        }

        public void offer(int num) {
            queue[r++] = num;
        }

        public int poll() {
            return queue[l++];
        }

        public int size() {
            return r - l;
        }
    }

    /**
     * 如果已知队列中同时存在的元素最大数量为n 那么我们可以使用环形数组来实现队列空间的重复利用
     * 测试链接 <a href="https://leetcode.cn/problems/design-circular-queue/">力扣链接</a>
     */
    public static class CircularQueue {
        public int[] queue;
        public int l = 0;
        public int r = 0;
        public int size = 0;
        public int maxLimit;

        public CircularQueue(int k) {
            queue = new int[k];
            this.maxLimit = k;
        }

        public boolean enQueue(int value) {
            if (size == maxLimit) {
                return false;
            }
            queue[r] = value;
            r = (r == maxLimit - 1) ? 0 : r + 1;
            size++;
            return true;
        }

        public boolean deQueue() {
            if (size == 0) {
                return false;
            }
            l = (l == maxLimit - 1) ? 0 : l + 1;
            size--;
            return true;
        }

        public int Front() {
            if (size == 0) {
                return -1;
            }
            return queue[l];
        }

        public int Rear() {
            if (size == 0) {
                return -1;
            }
            return r == 0 ? queue[maxLimit - 1] : queue[r - 1];
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public boolean isFull() {
            return size == maxLimit;
        }
    }

    /**
     * 设计循环双端队列 测试链接 <a href="https://leetcode.cn/problems/design-circular-deque/">力扣链接</a>
     */
    public static class MyCircularDeque {
        public int[] queue;
        public int l = 0;
        public int r = 0;
        public int size = 0;
        public int maxLimit;
        public MyCircularDeque(int k) {
            queue = new int[k];
            this.maxLimit = k;
        }

        public boolean insertFront(int value) {
            if (size == maxLimit) {
                return false;
            }
            l = (l == 0) ? maxLimit - 1 : l - 1;
            queue[l] = value;
            size++;
            return true;
        }

        public boolean insertLast(int value) {
            if (size == maxLimit) return false;
            queue[r] = value;
            r = (r == maxLimit - 1) ? 0 : r + 1;
            size++;
            return true;
        }

        public boolean deleteFront() {
            if(isEmpty()) return false;
            l = (l == maxLimit - 1) ? 0 : l + 1;
            size--;
            return true;
        }

        public boolean deleteLast() {
            if (isEmpty()) return false;
            r = (r == 0) ? maxLimit - 1 : r - 1;
            size--;
            return true;
        }

        public int getFront() {
            if (isEmpty()) return -1;
            return queue[l];

        }

        public int getRear() {
            if(isEmpty()) return -1;
            return (r==0) ? queue[maxLimit-1] : queue[r-1];
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public boolean isFull() {
            return size == maxLimit;
        }
    }
}
