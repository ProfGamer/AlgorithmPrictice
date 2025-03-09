package com.datastructure.algorithmprictice.advanced.binaryTree;

import com.datastructure.algorithmprictice.advanced.binaryTree.TreeNode.TreeNode;

/**
 * 二叉树上的打家劫舍问题
 * https://leetcode.cn/problems/house-robber-iii/
 * 小偷又发现了一个新的可行窃的地区。这个地区只有一个入口，我们称之为 root 。
 * 除了 root 之外，每栋房子有且只有一个“父“房子与之相连。一番侦察之后，聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。
 * 如果 两个直接相连的房子在同一天晚上被打劫 ，房屋将自动报警。
 * 给定二叉树的 root 。返回 在不触动警报的情况下 ，小偷能够盗取的最高金额
 */
public class RobBinaryTree {
    /**
     * yes 代表X子树 偷头节点时的最大值
     * no  代表X子树 不偷头节点时的最大值
     * yes no都会在递归过程中自底至顶更新 为每一颗子树的yes no
     */
    public static int yes, no;
    public int rob(TreeNode root) {
        f(root);
        return Math.max(yes, no);
    }

    public void f(TreeNode root) {
        if (root == null) {
            yes = no = 0;
        } else {
            int myYes = root.val;
            int myNo = 0;
            f(root.left);
            // 对于此时的子树 如果选择偷头, 那么left树只能不偷 myYes = myYes + no
            myYes += no;
            // 对于此时的子树 如果选择不偷头, 那么left树可以选择偷或不偷头, 取最大值 myYes = myYes + Math.max(yes, no)
            myNo += Math.max(yes, no);
            // 右树同理
            f(root.right);
            myYes += no;
            myNo += Math.max(yes, no);
           // 需要更新yes no作为自己的yes no来返回
            yes = myYes;
            no = myNo;
        }
    }
}
