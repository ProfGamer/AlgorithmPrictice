package com.datastructure.algorithmprictice.newbee.ReviewSorting;

import com.datastructure.algorithmprictice.myPrictice.Sorting.QuickSort;
import com.datastructure.algorithmprictice.newbee.utils.Utils;

import java.util.Arrays;

/**
 * i从0位置开始遍历数组, 每次都确定最小值的位置, 最后一个位置不需要确定
 * j从i位置开始遍历数组, 比较arr[i] arr[j]的大小, 将较小的值放在i索引位置
 */
public class SelectSort {
    public static void main(String[] args) {

        System.out.println("Test For SelectSort:");
        testSelectSort(10, 10, 100);
        System.out.println("Test For BetterSelectSort:");
        testBetterSelectSort(10, 10, 100);
    }
    public static void selectSort(int[] arr) {
        // 每轮的i就是我们需要确认的索引位置, 每次都把i - n-1位置上的最小值放到 i 上
        for (int i = 0 ; i < arr.length - 1; i++) {
            for (int j = i ; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    // 这里swap方法调用的次数过多, 我们可以通过先确定minIndex位置 最后执行swap的方式来进行优化
                    Utils.swapTwoNumInArr(arr, i , j);
                }
            }
        }
    }

    public static void betterSelectSort(int[] arr) {
        // 每轮的i就是我们需要确认的索引位置, 每次都把i - n-1位置上的最小值放到 i 上
        for (int minIndex, i = 0 ; i < arr.length - 1; i++) {
            minIndex = i;
            for (int j = i + 1 ; j < arr.length; j++) {
                if (arr[minIndex] > arr[j]) {
                    minIndex = j;
                }
            }
            Utils.swapTwoNumInArr(arr, i , minIndex);
        }
    }

    public static void testSelectSort(int len, int max, int times) {
        System.out.println("测试开始！！！");
        for (int i = 0; i < times; i++) {
            int[] arr1 = QuickSort.generateRandomArray(len, max);
            int[] arr2 = Arrays.copyOf(arr1, arr1.length);
            Arrays.sort(arr1);
            selectSort(arr2);
            if (!Arrays.equals(arr1, arr2)) {
                System.out.println("出错了！！！");
            }
        }
        System.out.println("测试结束！！！");
    }

    public static void testBetterSelectSort(int len, int max, int times) {
        System.out.println("测试开始！！！");
        for (int i = 0; i < times; i++) {
            int[] arr1 = QuickSort.generateRandomArray(len, max);
            int[] arr2 = Arrays.copyOf(arr1, arr1.length);
            Arrays.sort(arr1);
            betterSelectSort(arr2);
            if (!Arrays.equals(arr1, arr2)) {
                System.out.println("出错了！！！");
            }
        }
        System.out.println("测试结束！！！");
    }
}
