package com.datastructure.algorithmprictice.advanced.binaryTree.SubSet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 无重复元素的组合 或者 
 * https://leetcode.cn/problems/subsets/description/
 * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的
 * 子集（幂集）。
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 */
public class SubSet1 {
    /**
     * 输入：nums = [1,2,3]
     * 输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
     * @param nums
     * @return
     */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        process(result, nums, new ArrayList<>(), 0);
        return result;
    }

    /**
     * 每个数都有 加 或者 不加 两个选择 最后的结果是一颗完全展开的二叉树, 到达叶节点的时候将结果放入result
     * 加入的过程做完之后, 需要消除影响, 然后再进行不加入的过程
     * @param result
     * @param arr
     * @param path
     * @param index
     */
    private void process(List<List<Integer>> result, int[] arr, ArrayList<Integer> path, int index) {
        if (index == arr.length) {
            List<Integer> copy = List.copyOf(path);
            result.add(copy);
        } else {
            path.add(arr[index]);
            process(result, arr, path, index + 1);
            path.remove(path.size() - 1);
            process(result, arr, path, index + 1);
        }

    }
}
