package com.datastructure.algorithmprictice.newbee.ReviewSorting;

import com.datastructure.algorithmprictice.myPrictice.Sorting.QuickSort;
import com.datastructure.algorithmprictice.newbee.utils.Utils;

import java.util.Arrays;

/**
 * 回顾冒泡排序
 * 总结: 长度n的数组, 从n-1位置 i 开始 每轮都确定最大的数 放到 i 位置
 * 从 j = 0 至 i - 1 位置遍历, 如果 j 位置 > j + 1位置, 则交换两个位置的值, 否则则不交换, 然后 j++
 */
public class BubbleSort {
    public static void main(String[] args) {
        testBubbleSort(10, 20, 100);
    }
    public static void bubbleSort(int[] arr) {
        for (int i = arr.length - 1 ; i >0 ; i--) {
            for (int j = 0 ; j < i; j++) {
                if (arr[j] > arr[j+1]) {
                    Utils.swapTwoNumInArr(arr, j , j+1);
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
