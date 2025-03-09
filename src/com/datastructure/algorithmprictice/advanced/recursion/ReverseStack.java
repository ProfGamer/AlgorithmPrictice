package com.datastructure.algorithmprictice.advanced.recursion;

import java.util.Stack;


/**
 * 使用递归逆序一个栈
 */
public class ReverseStack {
    public static void reverseStack(Stack<Integer> stack) {
        if (stack.empty()) return;
        int bottom = bottomOut(stack);
        reverseStack(stack);
        stack.push(bottom);
    }

    /**
     * 返回栈底元素, 其余元素压下来
     *
     * @param stack
     * @return
     */
    private static int bottomOut(Stack<Integer> stack) {
        int result = stack.pop();
        if (stack.isEmpty()) {
            return result;
        } else {
            int last = bottomOut(stack);
            stack.push(result);
            return last;
        }
    }

    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        s.push(5);
        reverseStack(s);

        while (!s.isEmpty()) {
            System.out.println(s.pop());
        }
    }

}
