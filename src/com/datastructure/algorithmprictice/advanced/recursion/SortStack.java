package com.datastructure.algorithmprictice.advanced.recursion;

import java.util.Stack;

/**
 * 只使用递归来排序一个栈
 */
public class SortStack {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(3);
        stack.push(2);
        stack.push(5);
        stack.push(4);
        sortStack(stack);
        while (!stack.empty()) {
            System.out.println(stack.pop());
        }
    }


    public static void sortStack(Stack<Integer> stack) {
        if (stack == null || stack.empty()) return;
        // 先计算栈最大深度
        int deep = maxDeep(stack);
        // 如果需要排序的深度不为0, 则进行排序
        while (deep > 0) {
            // 在当前深度下, 找到最大值
            int max = maxValue(stack, deep);
            // 在当前深度下, 找到最大值出现的次数
            int frequency = frequency(stack, deep, max);
            // 将最大值排在当前深度的底部
            down(stack, deep, max, frequency);
            deep -= frequency;
        }
    }
    public static void down(Stack<Integer> stack, int deep, int max, int frequency) {
        if (deep == 0) {
            for (int i = 0 ; i < frequency; i++) {
                stack.push(max);
            }
            return;
        }

        int cur = stack.pop();
        down(stack, deep - 1, max, frequency);
        if (cur != max) {
            stack.push(cur);
        }

    }

    public static int frequency(Stack<Integer> stack, int deep, int max) {
        if (deep == 0) {
            return 0;
        }
        int cur = stack.pop();
        int rest = frequency(stack, deep - 1, max);
        stack.push(cur);
        return cur == max ? rest + 1 : rest;
    }

    public static int maxValue(Stack<Integer> stack, int deep) {
        if (deep == 0) {
            return Integer.MIN_VALUE;
        }
        int cur = stack.pop();
        int restMax = maxValue(stack, deep - 1);
        stack.push(cur);
        return Math.max(cur, restMax);
    }

    public static int maxDeep(Stack<Integer> stack) {
        if (stack.empty()) return 0;
        int cur = stack.pop();
        int deep = maxDeep(stack) + 1;
        stack.push(cur);
        return deep;
    }
}
