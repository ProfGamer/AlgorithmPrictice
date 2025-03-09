package com.datastructure.algorithmprictice.advanced.binaryTree.SubSet;

import com.datastructure.algorithmprictice.newbee.utils.Utils;

import java.util.ArrayList;
import java.util.List;

/**
 * 求解数组的全排列
 */
public class Permutations {
    public List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        if (nums.length == 1) {
            result.add(List.of(nums[0]));
            return result;
        }
        process(result, nums, new ArrayList<>(), nums.length);
        return result;
    }

    /**
     * the recursion will return the permutation of the array from 0 to size - 1
     * @param result permutations
     * @param nums whole array
     * @param path current path
     * @param size the size of the valid array
     */
    public void process(List<List<Integer>> result, int[] nums, List<Integer> path, int size) {
        if (size == 1) {
            path.add(nums[0]);
            result.add(List.copyOf(path));
            // recall the path
            path.remove(path.size() - 1);
            return;
        }
        // make each element in the valid array size as the first element
        for (int i = 0 ; i < size; i++) {
            path.add(nums[i]);
            // once it has been added to the path, it should be moved out of the valid range
            swap(nums, i, size - 1);
            process(result, nums, path, size - 1);
            // recall the array
            swap(nums, i, size - 1);
            // recall the path
            path.remove(path.size() - 1);
        }
    }

    public static void swap(int[] arr, int index1, int index2) {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }

}
