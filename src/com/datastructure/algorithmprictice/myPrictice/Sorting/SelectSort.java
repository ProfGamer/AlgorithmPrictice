package com.datastructure.algorithmprictice.myPrictice.Sorting;

import java.util.Arrays;

/**
 * @Author: Xin Yuchen
 * @Date: 2022/5/8 - 05 - 08 - 15:27
 * @Description: Any Ques or Concerns, plz contact e0838400@u.nus.edu
 */
// 选择排序 -> 不具备稳定性 -> 时间复杂度O(n2)
public class SelectSort {
    public static void main(String[] args) {
        testSelectSort(10, 10, 1000);
    }

    public static void selectSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        // 选择排序， 每次确定一个最小值的位置
        for (int i = 0; i < arr.length; i++) {
            // 我们这里认为最小值就是i位置的值 如果j位置的值小于i位置， 那么我们就交换i跟j
            // j++对下一个j位置进行判断
            for (int j = i; j < arr.length; j++) {
                if (arr[j] < arr[i]) {
                    QuickSort.swap(arr, i, j);
                }
            }

        }
    }

    public static void testSelectSort(int len, int max, int times) {
        System.out.println("测试开始！！！");
        for (int i = 0; i < times; i++) {
            int[] arr1 = QuickSort.generateRandomArray(len, max);
            int[] arr2 = Arrays.copyOf(arr1, arr1.length);
            int[] original = Arrays.copyOf(arr1, arr1.length);
            Arrays.sort(arr1);
            selectSort(arr2);
            if (!Arrays.equals(arr1, arr2)) {
                System.out.println("出错了！！！");
                System.out.println("原始数组为: " + Arrays.toString(original));
                System.out.println();
            }
        }
        System.out.println("测试结束！！！");
    }
}
