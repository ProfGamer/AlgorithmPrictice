package com.datastructure.algorithmprictice.advanced.binaryTree;

import com.datastructure.algorithmprictice.advanced.binaryTree.TreeNode.TreeNode;

/**
 * 二叉树的最小深度 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 * https://leetcode.cn/problems/minimum-depth-of-binary-tree/
 */
public class MinimumDepth {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        int lDeep = Integer.MAX_VALUE;
        int rDeep = Integer.MAX_VALUE;
        if (root.left != null) {
            lDeep = minDepth(root.left);
        }
        if (root.right != null) {
            rDeep = minDepth(root.right);
        }
        return Math.min(lDeep, rDeep) + 1;
    }
}
