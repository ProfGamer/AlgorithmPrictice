package com.datastructure.algorithmprictice.advanced.binaryTree;

import com.datastructure.algorithmprictice.advanced.binaryTree.TreeNode.TreeNode;

import java.util.*;

/**
 * 二叉树的层序遍历, 将每层的节点收集为一个list, 最后返回全部的list
 * https://leetcode.cn/problems/binary-tree-level-order-traversal/description/
 */
public class LevelOrderTraversal {
    public static TreeNode[] queue = new TreeNode[3001];
    public static int l, r;
    /**
     * 使用数组实现队列 通过l r规定队列范围, l为队列最先poll的元素, r为队列下一个插入的位置 r - l 为队列的长度 size
     * 使用一个List<List<>> result来收集结果
     * 先将Root加入队列, l = 0, r = 1
     * 队列不为空则循环
     *      创建本层的levelValue list
     *      循环此时的queue size次
     *          poll出元素, l++, 并将该元素加入levelValue
     *          该元素有左加左, 有右加右
     *      将levelValue加入result
     * 返回result
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        // 初始化队列
        l = r = 0;
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        // 将root加入queue
        queue[r++] = root;
        // 循环至队列为空
        while (l < r) {
            List<Integer> levelValue = new ArrayList<>();
            int size = r - l;
            for(int i = 0; i < size ; i ++) {
                TreeNode node = queue[l++];
                levelValue.add(node.val);
                if (node.left != null) {
                    queue[r++] = node.left;
                }
                if (node.right != null) {
                    queue[r++] = node.right;
                }
            }
            result.add(levelValue);
        }
        return result;

    }
    /**
     * 使用普通的bfs进行层序遍历
     * 使用一个Map来记录节点和层的对应关系, 每次放入节点的时候记录 先放入头节点, value是0,
     * 使用一个Queue来记录节点, 先放入头节点, 之后只要Queue没有空则循环
     * 使用一个List<List<>> 来收集结果
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder1(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        if (root == null) return result;

        HashMap<TreeNode, Integer> levelMap = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        // 加入头节点, 初始化 Map 和 Queue
        queue.offer(root);
        levelMap.put(root, 0);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            Integer level = levelMap.get(node);
            if (level == result.size()) {
                result.add(new ArrayList<>());

            }
            List<Integer> levelValue = result.get(level);
            levelValue.add(node.val);

            // 将左右节点加入queue 和 map
            if (node.left != null) {
                queue.offer(node.left);
                levelMap.put(node.left, level + 1);
            }

            if (node.right != null) {
                queue.offer(node.right);
                levelMap.put(node.right, level + 1);
            }

        }
        return result;
    }
}
