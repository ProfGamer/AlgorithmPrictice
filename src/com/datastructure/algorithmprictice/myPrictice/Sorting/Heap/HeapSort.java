package com.datastructure.algorithmprictice.myPrictice.Sorting.Heap;

import com.datastructure.algorithmprictice.myPrictice.Sorting.QuickSort;

import java.util.Arrays;

/**
 * @Author: Xin Yuchen
 * @Date: 2022/5/8 - 05 - 08 - 17:01
 * @Description: Any Ques or Concerns, plz contact e0838400@u.nus.edu
 */
// 堆结构与堆排序
public class HeapSort {
    public static void main(String[] args) {
        testHeapSort(10, 10, 10000);
    }

    public static void testHeapSort(int len, int max, int times) {
        System.out.println("测试开始！");
        for (int i = 0; i < times; i++) {
            int[] arr1 = QuickSort.generateRandomArray(len, max);
            int[] arr2 = Arrays.copyOf(arr1, arr1.length);
            Arrays.sort(arr1);
            heapSort(arr2);
            if (!Arrays.equals(arr1, arr2)) {
                System.out.println("出错了！！！");
            }
        }
        System.out.println("测试结束！！！");
    }

    public static void heapSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        //首先我们要将这个数组变成一个大根堆，可以用从头开始heapInsert的方法
//        for (int i = 0; i < arr.length; i++) {
//            heapInsert(arr, i);
//        }
        // 也可以先默认整个数组已经是堆 从最后一个位置开始进行Heapify操作， 保证每个子书都是大根堆
        for (int i = arr.length - 1; i >= 0; i--) {
            heapify(arr, i, arr.length);
        }
        // 将0位置与最后一个位置交换
        int heapSize = arr.length;
        QuickSort.swap(arr, 0, --heapSize);
        // 对0位置进行heapify并重复 直到heapSize==0
        while (heapSize > 0) {
            heapify(arr, 0, heapSize);
            QuickSort.swap(arr, 0, --heapSize);
        }
    }

    // 从index开始向上 通过heapInsert维持这个大根堆
    public static void heapInsert(int[] arr, int index) {
        // 在index位置的值 需要让他依次和他所有的父节点进行比较，移动到合适的位置

        while (arr[index] > arr[(index - 1) / 2]) {
            // 交换两者的位置
            QuickSort.swap(arr, index, (index - 1) / 2);
            index = (index - 1) / 2; // 更新index的位置，让他和对应的父节点继续比较
        }
    }

    // 替换的数在index位置，我们要让这个数不断地向下堆化， 和他的子节点不断地比较，直到比所有子节点大或者达到了叶节点位置
    public static void heapify(int[] arr, int index, int heapSize) {
        //heapSize是指这个数组中0~heapSize-1的区间是我们的讨论范围
        // 左边子节点的位置
        int left = 2 * index + 1;
        while (left < heapSize) {
            // 找到左右节点中较大的哪一个 只有在存在右节点，并且右节点比左节点大的时候， largest才为右节点， 不然就是左节点
            int largest = (left + 1 < heapSize) && (arr[left + 1] > arr[left]) ? left + 1 : left;
            // 看看largest的位置后index 的位置哪个更大
            largest = arr[largest] > arr[index] ? largest : index;
            // 如果index位置已经是最大的了。 结束循环
            if (largest == index) {
                break;
            }
            // 如果index不是最大的位置交换index和largest 然后继续向下进行heapify
            QuickSort.swap(arr, index, largest);
            index = largest;

            left = 2 * index + 1;
        }
    }
}
