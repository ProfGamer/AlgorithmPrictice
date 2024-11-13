package com.datastructure.algorithmprictice.advanced.binaryTree;

import com.datastructure.algorithmprictice.advanced.binaryTree.TreeNode.TreeNode;

/**
 * 计算完全二叉树节点个数
 * https://leetcode.cn/problems/count-complete-tree-nodes/
 */
public class CountCompleteTree {
    public int countNodes(TreeNode root) {
        int depth = maxDepth(root);
        if (depth == 0) {
            return 0;
        }
        if (depth == 1) {
            return 1;
        }
        // 证明左边是完全二叉树 高度 depth - 1 总数 2^(depth-1)
        if (maxDepth(root.right) + 1 == depth) {
            return (1 << (depth - 1)) + countNodes(root.right);
        } else {
            // 证明右边是完全二叉树 高度 depth - 2 总数 2^(depth-2)
            return countNodes(root.left) + (1 << (depth - 2));
        }

    }

    private int maxDepth(TreeNode root) {
        int count = 0;
        while (root != null) {
            count++;
            root = root.left;
        }
        return count;
    }
}
