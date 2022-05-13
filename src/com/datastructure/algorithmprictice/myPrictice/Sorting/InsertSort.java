package com.datastructure.algorithmprictice.myPrictice.Sorting;

import java.util.Arrays;

/**
 * @Author: Xin Yuchen
 * @Date: 2022/5/8 - 05 - 08 - 14:41
 * @Description: Any Ques or Concerns, plz contact e0838400@u.nus.edu
 */
// 插入排序 -> 具备稳定性
// 0-0有序 -> 0-1 有序 -> 0-n-1有序
public class InsertSort {
    public static void main(String[] args) {
        testInsertSort(10, 10, 1000);
    }

    public static void insertSorting(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[i - 1]) {
                for (int j = i - 1; j >= 0; j--) {
                    if (arr[j] > arr[j + 1]) {
                        QuickSort.swap(arr, j, j + 1);
                    }
                }
            }
        }
    }

    public static void betterInsertSort(int[] arr) {
        // [5,4,3,2,1]
        //    i
        //  j i  arr[j] > arr[j+1] swap j & j+1
        //  4,5,3,2,1
        //    j i   [j] > [j+1] swap 4,3,5,2,1
        //  4,3,5,2,1
        //  j   i   [j] > [j+1] swap
        //  3,4,5,2,1
        for (int i = 1; i < arr.length; i++) {
            // 这里可以将arr[j] > arr[j+1]放在for判断条件里面 因为如果不满足条件, 可以结束循环
            for (int j = i - 1; j >= 0 && arr[j] > arr[j + 1]; j--) {
                QuickSort.swap(arr, j, j + 1);
            }
        }

    }

    public static void testInsertSort(int len, int max, int time) {
        System.out.println("测试开始!!");
        for (int i = 0; i < time; i++) {
            int[] arr1 = QuickSort.generateRandomArray(len, max);
            int[] arr2 = Arrays.copyOf(arr1, arr1.length);
            Arrays.sort(arr1);
            betterInsertSort(arr2);
            if (!Arrays.equals(arr1, arr2)) {
                System.out.println("出错了!!");
            }

        }
        System.out.println("测试结束!!");
    }

}
