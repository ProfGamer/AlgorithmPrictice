package com.datastructure.algorithmprictice.advanced.binaryTree;

import com.datastructure.algorithmprictice.advanced.binaryTree.TreeNode.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树的锯齿形层序遍历 每层先从左往右 再从右往左, 以此类推
 *  https://leetcode.cn/problems/binary-tree-zigzag-level-order-traversal/
 *  大的思路和层序遍历一致 但是增加一个reverse变量控制每层的节点收集顺序 每次收集节点时 若reverse false 则左到右, 反之右到左 之后 reverse = !reverse
 */
public class ZigzagLevelOrderTraversal {
    public static TreeNode[] queue = new TreeNode[2001];
    public static int l, r;

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        if (root == null) return result;

        l = r = 0;
        boolean reverse = false;
        queue[r++] = root;
        while (l < r) {
            List<Integer> levelValue = new ArrayList<>();
            // 对这层的节点进行收集
            // [l,r) 如果reverse false cong l -> r-1 true r-1 -> l
            // reverse -> true -> for (int i = r - 1; i >= l; i = i - 1)
            // reverse -> false -> for (int i = l; i < r>; i = i + 1)
            for (int i = reverse ? r-1: l, j = reverse ? -1 : 1 ; reverse ? i >= l : i < r; i += j) {
                levelValue.add(queue[i].val);
            }
            result.add(levelValue);
            reverse = !reverse;
            // 进行层序遍历 需要先固定size, 因为l r在循环中会变化
            int size = r - l;
            for (int i = 0 ; i < size; i++) {
                TreeNode node = queue[l++];
                if (node.left != null) {
                    queue[r++] = node.left;
                }
                if (node.right != null) {
                    queue[r++] = node.right;
                }
            }
        }
        return result;
    }
}
