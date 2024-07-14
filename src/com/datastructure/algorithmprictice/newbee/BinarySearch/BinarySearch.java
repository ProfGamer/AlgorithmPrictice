package com.datastructure.algorithmprictice.newbee.BinarySearch;

import java.util.Arrays;

public class BinarySearch {
    /**
     * 给定一个有序数组, 使用二分搜索确认num在其中是否存在
     */
    public static boolean numberExist(int[] arr, int targetNum ) {
        int left = 0;
        int right = arr.length - 1;
        int middle = 0;
        while (left <= right) {
            middle = (left + right) / 2;
            if (arr[middle] > targetNum) {
                right = middle - 1;
            } else if (arr[middle] < targetNum) {
                left = middle + 1;
            } else {
                return true;
            }
        }
        return false;
    }

    /**
     * 在一个有序数组(升序)中 找到>= targetNum的最左位置 (找到第一个>=num的位置) 如果全部都比Target小 则返回 -1
     * [2,4,6,8,10] -> targetNum = 5 -> 结果返回2
     * @param arr
     * @param targetNum
     * @return
     */
    public static int findMostLeftPositionGreaterThanOrEqualsTarget(int[] arr, int targetNum) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        int left = 0;
        int right = arr.length - 1;
        int mid = 0;
        int position = -1;
        while (left <= right) {
            mid = (left + right) /2;
            // 防溢出写法 -> m = left + (right - left) / 2
            // m = left + ((right - left) >> 1)
            if (arr[mid] >= targetNum) {
                right = mid - 1;
                position = mid;
            } else {
                left = mid + 1;
            }
        }
        return position;
    }

    /**
     * 在一个有序数组(升序)中 找到<= targetNum的最右位置(最后一个 <= target的位置) 如果全部都 > target则返回-1
     * [2,4,6,8,10] -> targetNum = 5 -> 结果返回1
     * @param arr
     * @param targetNum
     * @return
     */
    public static int searchMostRightPositionNotGreaterThanTarget(int[] arr, int targetNum) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        int left = 0;
        int right = arr.length - 1;
        int mid = 0;
        int position = -1;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (arr[mid] <= targetNum) {
                left = mid + 1;
                position = mid;
            } else {
                right = mid - 1;
            }
        }
        return position;
    }

    /**
     * 力扣测试连接: <a href="https://leetcode.cn/problems/find-peak-element/submissions/">原题链接</a>
     * 给定一个无序数组, 确保数组中任意相邻的元素都不相等, 寻找数组中的任意峰值点, 假定数组 -1 和 n两个越界索引的值为最小值 即 0 位置和 n-1位置只需要大于它相邻的元素也可以成为峰值
     * @param nums 无序数组, 任意相邻元素不相等
     * @return 任意峰值位置
     */
    public static int findPeakElement(int[] nums) {
        // 有效性检查
        if (nums == null || nums.length == 0) {
            return -1;
        }
        if (nums.length == 1) {
            return 0;
        }
        // 先检查左右边界点
        if (nums[0] > nums[1]) {
            return 0;
        }
        if (nums[nums.length - 1] > nums[nums.length -2]) {
            return nums.length - 1;
        }
        // 如果左右边界点都不是峰值 那么可以确定 数组的趋势为先上升最后下降 -> 在数组中一定存在峰值
        int left = 1;
        int right = nums.length - 2;
        int mid = 1;
        int position = -1;
        while (left <= right) {
            mid = left + (right - left) / 2;
            // 判断mid是否是峰值
            if (nums[mid - 1] < nums[mid] && nums[mid] > nums[mid+1]) {
                return mid;
            }
            if (nums[mid-1] > nums[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return position;
    }


}
