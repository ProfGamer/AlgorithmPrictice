package com.datastructure.algorithmprictice.newbee.Queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;


public class Conversion {
    /**
     * convert stack n queue to each other <br>
     * 测试链接: <a href="https://leetcode.cn/problems/implement-queue-using-stacks">力扣链接</a>
     */
    public static class StackQueue {
        public Stack<Integer> inStack;
        public Stack<Integer> outStack;
        public StackQueue() {
            inStack = new Stack<Integer>();
            outStack = new Stack<Integer>();
        }

        public void push(int x) {
            inStack.push(x);
            popInToOut();
        }

        public int pop() {
            popInToOut();
            return outStack.pop();
        }

        public int peek() {
            popInToOut();
            return outStack.peek();
        }

        public boolean empty() {
            return inStack.empty() && outStack.empty();
        }

        /**
         * 从in栈导入到out栈必须满足两个条件<br>
         * 1. out栈此时为空 (不然新导入的元素会盖在上面) <br>
         * 2. in栈必须全部清空. 不然再次push元素进in栈的时候会导致倒入顺序混乱
         */
        private void popInToOut() {
            if (!outStack.empty()) return;
            while(!inStack.empty()) {
                outStack.push(inStack.pop());
            }
        }
    }

    /**
     * 仅使用一个队列实现栈的功能<br>
     * 测试链接: <a href="https://leetcode.cn/problems/implement-stack-using-queues/">力扣链接</a>
     */
    public static class QueueStack {
        public Queue<Integer> queue;

        public QueueStack() {
            queue = new LinkedList<>();
        }

        public void push(int x) {
            // 先记录下当前队列的size
            int size = queue.size();
            queue.offer(x);
            // 在队列尾部加入该元素x后, 让前面size个元素重新出队后入队 即可形成栈的出栈顺序
            for (int i = 0; i < size; i++) {
                queue.offer(queue.poll());
            }
        }

        public int pop() {
            return queue.poll();
        }

        public int top() {
            return queue.peek();
        }

        public boolean empty() {
            return queue.isEmpty();
        }
    }
}
