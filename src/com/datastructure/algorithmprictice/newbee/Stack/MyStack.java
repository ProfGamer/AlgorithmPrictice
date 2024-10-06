package com.datastructure.algorithmprictice.newbee.Stack;


/**
 * 使用Array实现栈结构
 */
public class MyStack {
    public static class ArrayStack{
        public int[] stack;
        public int size = 0;
        public ArrayStack(int limit) {
            stack = new int[limit];
        }

        public boolean push(int num) {
            if (size == num -1) return false;
            stack[size++] = num;
            return true;
        }

        public int pop() {
            if (size == 0) {
                return -1;
            }
            return stack[--size];
        }

        public int peek() {
            if (size == 0) return -1;
            return stack[size - 1];
        }
    }
}
