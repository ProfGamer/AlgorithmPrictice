package com.datastructure.algorithmprictice.myPrictice.Sorting.MergeSort;

import myPrictice.Sorting.QuickSort;

import java.util.Arrays;

/**
 * @Author: Xin Yuchen
 * @Date: 2022/5/8 - 05 - 08 - 16:22
 * @Description: Any Ques or Concerns, plz contact e0838400@u.nus.edu
 */
public class MergeSort {
    public static void main(String[] args) {
        testMergeSort(10,10,1000);
    }
    public static void mergeSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        mergeSortProcess(arr, 0, arr.length - 1);
    }

    public static void mergeSortProcess(int[] arr, int l, int r) {
        if (l >= r) {
            return;
        }
        int middle = l + ((r - l) >> 1);
        // l-middle上有序
        mergeSortProcess(arr, l, middle);
        // middle+1 - r上有序
        mergeSortProcess(arr, middle + 1, r);
        // 都有序后我们对两个数组进行merge
        merge(arr, l, middle, r);
    }

    public static void merge(int[] arr, int l, int middle, int r) {
        //[1,2,4] [2,4,5] -> 进行merge
        // 创建一个相同长度的辅助数组
        int[] helper = new int[r - l + 1];
        int index = 0; // 这个索引是用来给辅助数组赋值的
        int p1 = l;
        int p2 = middle + 1;
        // 当两个数组都有元素的时候
        while (p1 <= middle && p2 <= r) {
            if (arr[p1] <= arr[p2]) {
                helper[index++] = arr[p1++];
            } else {
                helper[index++] = arr[p2++];
            }
        }
        // 这个while之后 p1 或者 p2会越界 -> 一个数组已经完全加进入了， 另一个还没有
        while (p1 <= middle) {
            helper[index++] = arr[p1++];
        }
        while (p2 <= r) {
            helper[index++] = arr[p2++];
        }
        // 都加入进去之后， 我们再将helper复制进原来的数组中去
        for(int i = 0 ; i < helper.length ; i++){
            arr[l+i] = helper[i];
        }
    }
    public static void testMergeSort(int len, int max, int times){
        System.out.println("测试开始！！！");
        for(int i = 0 ; i < times ; i++) {
            int[] arr1 = QuickSort.generateRandomArray(len, max);
            int[] arr2 = Arrays.copyOf(arr1,arr1.length);
            Arrays.sort(arr1);
            mergeSort(arr2);
            if(!Arrays.equals(arr1,arr2)){
                System.out.println("出错了！！！");
            }
        }
        System.out.println("测试结束哦！");
    }
}
