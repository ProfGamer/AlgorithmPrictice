package com.datastructure.algorithmprictice.advanced.QuickSort;

/**
 * 测试链接 <a href="https://leetcode.cn/problems/kth-largest-element-in-an-array/description/">215.数组中的第K个最大元素</a>
 */
public class FindKthLargest {
    // 等于区域左右边界
    public static int left, right;
    public int findKthLargest(int[] nums, int k) {
        return findSortedValueInPositionK(nums, nums.length - k);
    }

    public static int findSortedValueInPositionK(int[] arr, int target) {
        int ans = 0;
        int l = 0;
        int r = arr.length - 1;
        while (l <= r) {
            int random = arr[l + (int)(Math.random() * (r - l + 1))];
            partition(l, r, random, arr);
            if (target < left) {
                r = left - 1;
            } else if (target > right) {
                l = right + 1;
            } else {
                ans = arr[target];
                break;
            }
        }
        return ans;
    }

    public static void partition(int l, int r, int target, int[] arr) {
        left = l;
        right = r;
        while (l <= right) {
            if (arr[l] < target) {
                swap(arr, l++, left++);
            } else if(arr[l] == target) {
                l++;
            } else {
                swap(arr, l, right--);
            }
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
