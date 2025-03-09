package com.datastructure.algorithmprictice.advanced.binaryTree;

import com.datastructure.algorithmprictice.advanced.binaryTree.TreeNode.TreeNode;

/**
 * 验证一颗树是否是二叉搜索树
 * https://leetcode.cn/problems/validate-binary-search-tree/
 * 有效 二叉搜索树定义如下：
 * 节点的左子树只包含 小于 当前节点的数。
 * 节点的右子树只包含 大于 当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 */
public class IsBinarySearchTree {
    public static TreeNode pre;
    public static boolean isBST;
    /**
     * 中序遍历法
     * 因为中序遍历 为 左 中 右, 如果是二叉搜索树, 那么中序下的每个节点一定大于前节点
     * @param root
     * @return
     */
    public boolean isValidBST(TreeNode root) {
        pre = null;
        isBST = true;
        inOrderTraversal(root);
        return isBST;
    }
    public void inOrderTraversal(TreeNode root) {
        if (!isBST || root == null) {
            return;
        }
        inOrderTraversal(root.left);
        if (pre != null && pre.val >= root.val) {
            isBST = false;
            return;
        }
        pre = root;
        inOrderTraversal(root.right);
    }
    public static long min, max;
    public boolean isValidBST2(TreeNode root) {
        if (root == null) {
            min = Long.MAX_VALUE;
            max = Long.MIN_VALUE;
            return true;
        }
        boolean leftOK = isValidBST2(root.left);
        long lMin = min;
        long lMax = max;
        boolean rightOK = isValidBST2(root.right);
        long rMin = min;
        long rMax = max;
        min = Math.min(Math.min(lMin, rMin), root.val);
        max = Math.max(Math.max(lMax, rMax), root.val);
        return leftOK && rightOK && root.val < rMin && root.val > lMax;

    }
}
