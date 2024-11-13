package com.datastructure.algorithmprictice.advanced.binaryTree;

import com.datastructure.algorithmprictice.advanced.binaryTree.TreeNode.TreeNode;

/**
 * 在二叉搜索树上寻找两个节点最低的公共祖先
 * https://leetcode.cn/problems/lowest-common-ancestor-of-a-binary-search-tree/
 * 二叉搜索树对于每一个节点而言, 左子树的值都小于它, 右子树的值都大于它, 并且节点值不会重复
 * 根据二叉搜索树的特性,
 * 如果当前节点就是p或q那么直接返回p或q
 * 如果当前节点 k.val 在 (p.val, q.val)值范围内, 那么p q一定在他的左右子树上, k一定是最低祖先
 * 如果 k.val < Math.min(p.val,q.val) 说明 p q一定都在k的右树上, k.right调用递归
 * 如果 k.val > Math.max(p.val,q.val) 说明 p q一定都在k的左树上, k.left调用递归
 */
public class LowestAncestorInSearchTree {
    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        if (root.val < Math.max(p.val, q.val) && root.val > Math.min(p.val, q.val)) {
            return root;
        }
        if (root.val < Math.min(p.val, q.val)) {
            return lowestCommonAncestor1(root.right, p, q);
        } else {
            return lowestCommonAncestor1(root.left, p, q);
        }
    }

    /**
     * 使用迭代方法
     *
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        // 如果迭代过程中root先转到了 p 或 q那么直接 返回root
        while (root != p && root != q) {
            // 如果root正好在 (p,q) 范围内, 也直接返回root
            if (root.val < Math.max(p.val, q.val) && root.val > Math.min(p.val, q.val)) {
                break;
            }
            root = root.val < Math.min(p.val, q.val) ? root.right : root.left;
        }
        return root;
    }
}
