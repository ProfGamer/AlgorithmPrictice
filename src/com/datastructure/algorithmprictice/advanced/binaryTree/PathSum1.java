package com.datastructure.algorithmprictice.advanced.binaryTree;

import com.datastructure.algorithmprictice.advanced.binaryTree.TreeNode.TreeNode;

public class PathSum1 {
    // static variable to identify if the path sum has been found and no need to continue the recursion
    public static boolean found = false;

    public boolean hasPathSum(TreeNode root, int targetSum) {
        found = false;
        if (root == null) {
            return false;
        }
        process(root, targetSum, 0);
        return found;

    }

    public void process(TreeNode node, int targetSum, int curSum) {
        // short circuit
        if (found) {
            return;
        }
        // leaf node and fulfill the target sum
        if (node.left == null && node.right == null && curSum + node.val == targetSum) {
            found = true;
            return;
        }
        // continue dfs
        if (node.left != null) {
            process(node.left, targetSum, curSum + node.val);
        }
        if (node.right != null) {
            process(node.right, targetSum, curSum + node.val);
        }

    }
}
