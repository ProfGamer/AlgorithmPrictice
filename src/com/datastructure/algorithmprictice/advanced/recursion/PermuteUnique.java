package com.datastructure.algorithmprictice.advanced.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 给定一个可包含重复数字的序列，返回所有不重复的全排列。
 * https://leetcode.cn/problems/permutations-ii/description/
 */
public class PermuteUnique {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        process(nums, 0, res);
        return res;
    }

    public static void process(int[] nums, int currentIndex, List<List<Integer>> res) {
        if (currentIndex == nums.length) {
            res.add(Arrays.stream(nums).boxed().collect(Collectors.toList()));
            return;
        }
        HashSet<Integer> set = new HashSet<>();
        for (int j = currentIndex; j <nums.length; j++) {
            if (set.contains(nums[j])) {
                continue;
            }
            set.add(nums[j]);
            swap(nums, currentIndex, j);
            process(nums, currentIndex + 1, res);
            swap(nums, currentIndex, j);
        }
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
