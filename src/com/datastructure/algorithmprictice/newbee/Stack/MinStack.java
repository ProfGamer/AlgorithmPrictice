package com.datastructure.algorithmprictice.newbee.Stack;

/**
 * 设计一个最小栈 除了基本的栈方法push pop top之外, 还可以通过getMin方法返回此时栈中的最小值<br>
 * 测试链接: <a href="https://leetcode.cn/problems/min-stack">力扣链接</a>
 *
 */
public class MinStack {
    public static final int MAX = 8001;
    public int[] data;
    public int[] min;
    public int size;

    public MinStack() {
        data = new int[MAX];
        min = new int[MAX];
        size = 0;
    }

    public void push(int val) {
        data[size] = val;
        if (size == 0 || val <= min[size - 1]) {
            min[size] = val;
        } else {
            min[size] = min[size - 1];
        }
        size++;
    }

    public void pop() {
        size--;
    }

    public int top() {
        return data[size - 1];
    }

    public int getMin() {
        return min[size - 1];
    }
}
