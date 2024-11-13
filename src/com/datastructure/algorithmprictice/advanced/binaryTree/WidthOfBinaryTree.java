package com.datastructure.algorithmprictice.advanced.binaryTree;

import com.datastructure.algorithmprictice.advanced.binaryTree.TreeNode.TreeNode;

/**
 * 二叉树的最大特殊宽度
 * 树的 最大宽度 是所有层中最大的 宽度
 * 每一层的 宽度 被定义为该层最左和最右的非空节点（即，两个端点）之间的长度。
 * 将这个二叉树视作与满二叉树结构相同，两端点间会出现一些延伸到这一层的 null 节点，这些 null 节点也计入长度。
 * https://leetcode.cn/problems/maximum-width-of-binary-tree/
 */
public class WidthOfBinaryTree {
    public static TreeNode[] nodeQueue = new TreeNode[3001];
    public static int[] idQueue = new int[3001];
    // 两个queue都使用l ~ r规定队列范围
    public static int l , r;
    /**
     * 继续沿用二叉树层序遍历的思想, 但是我们确定位置使用两个节点的编号差, root 节点编号1, left 为 2 * 1, right 为 2 * 1 + 1
     * 这样我们使用一个queue在层序遍历的时候收集该层的节点编号, 他和节点queue保持一致, 但是对应的是编号, 每层节点全部进入node queue之后, 其编号也全部进入 id queue
     * 计算id queue中第一个和最后一个节点的差 + 1, 即最大宽度
     * @param root
     * @return
     */
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        l = r = 0;
        nodeQueue[r] = root;
        // 设置头结点的id为1
        idQueue[r++] = 1;
        int max = 1;
        while (l < r) {
            // 此时本层的节点已经全部加好了, 计算最大值
            max = Math.max(max, idQueue[r-1] - idQueue[l] + 1);
            int size = r - l;
            for (int i = 0 ; i < size ; i++) {
                // 弹出node和其id
                TreeNode node = nodeQueue[l];
                int id = idQueue[l++];
                // 有左加左 有右加右, 同时加入节点和id
                if (node.left != null) {
                    nodeQueue[r] = node.left;
                    idQueue[r++] = id * 2;
                }
                if (node.right != null) {
                    nodeQueue[r] = node.right;
                    idQueue[r++] = id * 2 + 1;
                }
            }



        }
        return max;
    }
}
