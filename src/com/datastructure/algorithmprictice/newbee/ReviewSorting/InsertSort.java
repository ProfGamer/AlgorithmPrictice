package com.datastructure.algorithmprictice.newbee.ReviewSorting;

import com.datastructure.algorithmprictice.myPrictice.Sorting.QuickSort;
import com.datastructure.algorithmprictice.newbee.utils.Utils;

import java.util.Arrays;

/**
 * 插入排序, 从i=1位置开始遍历, 目的是保证0-i位置是有序的
 * j=i-1 也就是 0 - i-1 位置的最大值, 比较 j 和 j+1位置的大小, 如果 j+1 < j 那么交换 j 和 j + 1, 当 j + 1 > j时 可以停止本次 j循环 因为 0 - j 位置已经是有序的了, 再继续
 * 比较没有意义
 */
public class InsertSort {
    public static void main(String[] args) {
        testInsertSort(10, 10, 100);
    }
    public static void insertSort(int[] arr) {
        for(int i = 1; i < arr.length; i++) {

            for (int j = i-1; j >=0 && arr[j] > arr[j+1]; j--) {
                // 当前需要操作的数的位置一直为 j+1
                Utils.swapTwoNumInArr(arr, j , j+1);
            }
        }
    }

    public static void testInsertSort(int len, int max, int time) {
        System.out.println("测试开始!!");
        for (int i = 0; i < time; i++) {
            int[] arr1 = QuickSort.generateRandomArray(len, max);
            int[] arr2 = Arrays.copyOf(arr1, arr1.length);
            Arrays.sort(arr1);
            insertSort(arr2);
            if (!Arrays.equals(arr1, arr2)) {
                System.out.println("出错了!!");
            }

        }
        System.out.println("测试结束!!");
    }
}
