package com.datastructure.algorithmprictice.newbee.BinaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeIteration {
    public static void preOrderTraversal(BinaryNode node, List<Integer> result) {
        if (node == null) {
            return;
        }
        result.add(node.value);
        preOrderTraversal(node.left, result);
        preOrderTraversal(node.right, result);
    }

    public static void middleOrderTraversal(BinaryNode node, List<Integer> result) {
        if (node == null) {
            return;
        }
        middleOrderTraversal(node.left, result);
        result.add(node.value);
        middleOrderTraversal(node.right, result);
    }

    public static void postOrderTraversal(BinaryNode node, List<Integer> result) {
        if (node == null) {
            return;
        }
        postOrderTraversal(node.left, result);
        postOrderTraversal(node.right, result);
        result.add(node.value);
    }

    public static void recursionOrder(BinaryNode node) {
        if (node == null) {
            return;
        }
        // hit number first time
        recursionOrder(node.left);
        // hit number second time
        recursionOrder(node.right);
        // hit number last time
    }

    public static List<Integer> preOrderTraversalIteration(BinaryNode head) {
        List<Integer> result = new ArrayList<>();
        Stack<BinaryNode> stack = new Stack<>();
        if (head == null)
            return result;
        stack.push(head);
        while(!stack.empty()) {
            BinaryNode node = stack.pop();
            result.add(node.value);
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
        return result;
    }

    /**
     * 使用遍历实现二叉树中序遍历
     * @param head
     * @return
     */
    public static List<Integer> middleOrderTraversalIteration(BinaryNode head) {
        List<Integer> result = new ArrayList<>();
        Stack<BinaryNode> stack = new Stack<>();
        // 当栈空了 并且 节点指向null的时候停止遍历 此时head应该在最右叶节点的right == null位置
        while (!stack.empty() || head != null) {
            // 如果当前节点有左子树 则先处理左子树 将左子树push进栈
            if (head != null) {
                stack.push(head);
                head = head.left;
                // 左边界一直进栈 最终到该子树的最左叶节点的left == null位置
            } else {
                // 左侧都已经已经进站了 弹出栈顶元素 然后看看它有没有右树, 如果有右树 则右树重复循环
                head = stack.pop();
                result.add(head.value);
                head = head.right;
            }
        }
        return result;
    }

    /**
     * 使用两个栈结合先序遍历 实现后序遍历
     * @param head
     * @return
     */
    public static List<Integer> postOrderTraversalIterationTwoStack(BinaryNode head) {
        List<Integer> result = new ArrayList<>();
        if (head == null) return result;
        Stack<BinaryNode> stack = new Stack<>();
        Stack<BinaryNode> collection = new Stack<>();
        stack.push(head);
        while (!stack.empty()) {
            BinaryNode cur = stack.pop();
            collection.push(cur);
            if (cur.left != null) {
                stack.push(cur.left);
            }
            if (cur.right != null) {
                stack.push(cur.right);
            }
        }

        while(!collection.empty()) {
            result.add(collection.pop().value);
        }
        return result;
    }

    public static List<Integer> postOrderTraversalOneStack(BinaryNode head) {
        List<Integer> result = new ArrayList<>();
        if (head == null) return result;
        Stack<BinaryNode> stack = new Stack<>();
        BinaryNode scout = head;
        stack.push(head);
        while (!stack.empty()) {
            head = stack.peek();
            if (head.left != null && scout != head.left && scout != head.right) {
                stack.push(head.left);
            } else if (head.right != null && scout != head.right) {
                stack.push(head.right);
            } else {
                scout = stack.peek();
                result.add(scout.value);
            }
        }
        return result;
    }
}
