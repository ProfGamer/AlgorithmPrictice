package com.datastructure.algorithmprictice.advanced.heap;

import java.util.Arrays;

public class HeapSort {
    public static void main(String[] args) {
        int[] arr = new int[]{-2,3,-5};
//        heapSortViaHeapInsert(arr);
        heapSortViaHeapify(arr);
        System.out.println(Arrays.toString(arr));
//        while (size < 6) {
//            heapInsert(arr, size++);
//
//        }
//        System.out.println(Arrays.toString(arr));
//        for (int i = size - 1; i >= 0; i--) {
//            heapify(arr, i, size);
//        }
//        System.out.println(Arrays.toString(arr));
    }

    /**
     * 先从头0位置, 将arr变为大根堆, 然后再交换0位置和最后一个位置, 将heap size -1, 再将新的0位置的数 heapify成大根堆
     * @param arr
     */
    public static void heapSortViaHeapInsert(int[] arr) {
        int size = 0;
        while (size < arr.length) {
            heapInsert(arr, size++);
        }
        // 此时arr已经变成了大根堆
        while (size > 0) {
            swap(arr, 0, --size);
            heapify(arr, 0, size);
        }
    }

    public static void heapSortViaHeapify(int[] arr) {
        int lastParent = (arr.length - 1 - 1) / 2;
        int size = arr.length;
        while (lastParent >= 0) {
            heapify(arr, lastParent--, size);
        }
        while (size > 0) {
            swap(arr, 0, --size);
            heapify(arr, 0, size);
        }
    }

    /**
     * 将arr中i位置的数向上调整为大根堆
     *
     * @param arr
     * @param i
     */
    public static void heapInsert(int[] arr, int i) {
        while (arr[i] > arr[(i - 1) / 2]) {
            swap(arr, i, (i - 1) / 2);
            i = (i - 1) / 2;
        }
    }

    /**
     * 将arr中i位置的数向下调整为大根堆
     *
     * @param arr
     * @param i
     */
    public static void heapify(int[] arr, int i, int size) {
        int left = 2 * i + 1;
//        if (left > size-1) return;
//        int bestIndex = (left + 1 <= size -1) && (arr[left+1] > arr[left]) ? left+1:left ;
//        if (arr[i] < arr[bestIndex]){
//            swap(arr, i, bestIndex);
//            heapify(arr, bestIndex, size);
//        }
        while (left < size) {
            int bestIndex = (left + 1 <= size - 1) && (arr[left + 1] > arr[left]) ? left + 1 : left;
            bestIndex = arr[bestIndex] > arr[i] ? bestIndex : i;
            if (bestIndex == i) break;
            swap(arr, i, bestIndex);
            i = bestIndex;
            left = i * 2 + 1;
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
