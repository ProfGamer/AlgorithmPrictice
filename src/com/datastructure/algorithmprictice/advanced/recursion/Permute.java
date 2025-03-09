package com.datastructure.algorithmprictice.advanced.recursion;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * https://leetcode.cn/problems/VvJkup/description/
 */
public class Permute {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new java.util.ArrayList<>();
        process(nums, 0, ans);
        return ans;
    }
    public static void process(int[] nums, int currentIndex, List<List<Integer>> ans) {
        if (currentIndex == nums.length) {
            ans.add(Arrays.stream(nums).boxed().collect(Collectors.toList()));
            return;
        }
        for (int j = currentIndex; j < nums.length; j++) {
            swap(nums, currentIndex, j);
            process(nums, currentIndex + 1, ans);
            swap(nums, currentIndex, j);
        }
    }

    public static void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
