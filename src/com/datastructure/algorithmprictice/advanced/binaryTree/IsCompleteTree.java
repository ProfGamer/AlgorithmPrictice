package com.datastructure.algorithmprictice.advanced.binaryTree;

import com.datastructure.algorithmprictice.advanced.binaryTree.TreeNode.TreeNode;

/**
 * 二叉树的完全性验证
 * https://leetcode.cn/problems/check-completeness-of-a-binary-tree/description/
 * 整体仍旧采用bfs按层遍历二叉树的思路, 但是在遍历时每个节点都需要满足两个条件才能验证完全二叉树
 * 1. 每个节点如果right不为null 但是left为null 则不是完全二叉树
 * 2. 如果某个节点 left == null || right == null 那么之后遍历的所有节点必须都是叶节点, left == null && right == null
 */
public class IsCompleteTree {
    public static TreeNode[] queue = new TreeNode[1001];
    public static int l, r;

    public boolean isCompleteTree(TreeNode root) {
        boolean allLeft = false;
        boolean isComplete = true;
        l = r = 0;
        queue[r++] = root;
        while (l < r) {
            TreeNode node = queue[l++];
            if (allLeft && (node.left != null || node.right != null)) {
                return false;
            }
            if (node.left == null || node.right == null) {
                allLeft = true;
            }
            if (node.left == null && node.right != null) {
                return false;
            }
            if (node.left != null) {
                queue[r++] = node.left;
            }
            if (node.right != null) {
                queue[r++] = node.right;
            }

        }

        return isComplete;
    }

}
