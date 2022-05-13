package com.datastructure.algorithmprictice.myPrictice.Sorting;

import java.util.Arrays;

/**
 * @Author: Xin Yuchen
 * @Date: 2022/5/8 - 05 - 08 - 15:10
 * @Description: Any Ques or Concerns, plz contact e0838400@u.nus.edu
 */
// 冒泡排序 -> 具有稳定性 O(N2)
public class BubbleSort {
    public static void main(String[] args) {
        testBubbleSort(10, 10, 1000);
    }

    public static void bubbleSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = arr.length - 1; i >= 0; i--) {
            // 这里不可以将arr[j]>arr[j+1] 放在判断条件里面, 因为如果不满足这个条件, 循环仍要继续
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    QuickSort.swap(arr, j, j + 1);
                }
            }
        }
    }

    public static void testBubbleSort(int len, int max, int times) {
        for (int i = 0; i < times; i++) {
            int[] arr1 = QuickSort.generateRandomArray(len, max);
            int[] arr2 = Arrays.copyOf(arr1, arr1.length);
            Arrays.sort(arr1);
            bubbleSort(arr2);
            if (!Arrays.equals(arr1, arr2)) {
                System.out.println("出错了!!");
            }
        }
        System.out.println("测试结束!!!");
    }

}
