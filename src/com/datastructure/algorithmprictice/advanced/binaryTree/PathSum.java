package com.datastructure.algorithmprictice.advanced.binaryTree;

import com.datastructure.algorithmprictice.advanced.binaryTree.TreeNode.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 普通二叉树路径和
 * https://leetcode.cn/problems/path-sum-ii/
 * 递归还原现场, 入递归的时候将节点val加入path 但是在出递归的时候, 从path中移除该节点造成的影响
 */
public class PathSum {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        sum(root, targetSum, 0, path, result);
        return result;
    }

    private void sum(TreeNode node, int target, int curSum, List<Integer> path, List<List<Integer>> result) {
        if (node == null) return;
        // 如果当前是叶节点
        if (node.left == null && node.right == null) {
            // 如果路径匹配, 那么就修改path 然后将path copy加入结果, 最后从path中移除node的影响, 并且返回
            if (curSum + node.val == target) {
                path.add(node.val);
                List<Integer> copy = List.copyOf(path);
                result.add(copy);
                path.remove(path.size() - 1);
            }
            // 不匹配就什么都不做
        } else {
            // 如果不是叶节点, 那么就path中加入该节点, 然后分别去左右树进行路径计算, 计算完成后, 在本节点返回时 需要从path中移除node的影响
            path.add(node.val);
            sum(node.left, target, curSum + node.val, path, result);
            sum(node.right, target, curSum + node.val, path, result);
            path.remove(path.size() - 1);
        }

    }
}
