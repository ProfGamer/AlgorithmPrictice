package com.datastructure.algorithmprictice.advanced.binaryTree;

import com.datastructure.algorithmprictice.advanced.binaryTree.TreeNode.TreeNode;

/**
 * 验证一棵树是否是平衡二叉树
 * 平衡二叉树就是每个节点的左树和右树高度差最大为1
 * https://leetcode.cn/problems/balanced-binary-tree/description/
 */
public class IsBalancedTree {
    public static boolean isBalanced;
    public boolean isBalanced(TreeNode root) {
        isBalanced = true;
        countHeight(root);
        return isBalanced;
    }

    private int countHeight(TreeNode cur) {
        if (!isBalanced || cur == null) {
            return 0;
        }

        int leftHeight = countHeight(cur.left);
        int rightHeight = countHeight(cur.right);
        if (Math.abs(leftHeight - rightHeight) > 1) {
            isBalanced = false;
        }
        return Math.max(leftHeight, rightHeight) + 1;
    }
}
