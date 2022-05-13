package com.datastructure.algorithmprictice.myPrictice.Sorting;

import java.util.Arrays;

/**
 * @Author: Xin Yuchen
 * @Date: 2022/5/7 - 05 - 07 - 16:46
 * @Description: Any Ques or Concerns, plz contact e0838400@u.nus.edu
 */
// 在这里联系快速排序 -> 采用L-R上随机取值的方式减少最坏情况的出现
public class QuickSort {
    public static void main(String[] args) {
        testMethod(10, 10, 10000);
    }

    public static void quickSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        quickSorting(arr, 0, arr.length - 1);
    }

    // 在 数组 arr 的 l-r索引上进行快速排序
    public static void quickSorting(int[] arr, int l, int r) {
        // 递归结束条件 -> 至少存在两个数需要排序
        if (l >= r) {
            return;
        }
        // 先在l-r范围上随即找一个位置,并且把这个位置的数换到r位置上
        swap(arr, l + (int) (Math.random() * (r - l + 1)), r);
        int[] equalArea = partition(arr, l, r);
        quickSorting(arr, l, equalArea[0] - 1);
        quickSorting(arr, equalArea[1] + 1, r);
    }

    // 在数组L-r范围上, 将value 小于区 大于区 和等于区 的位置拍好, 并且返回等于区边界
    // 我们最后在吧arr[r] 交换到大于区左边界即可
    public static int[] partition(int[] arr, int l, int r) {
        // 让这两个边界,刚开始都处于判断区之外
        int less = l - 1; // 小于区 右边界 从 -1开始
        int more = r; // 大于区左边界 从r开始
        int index = l; // 遍历索引 在和more相遇时停止
        while (index < more) {
            // 遍历值小于目标值 -> less++ 并且 less处的值和index处的值互换位置
            if (arr[index] < arr[r]) {
                swap(arr, ++less, index++);
            } else if (arr[index] == arr[r]) {
                index++;
            } else if (arr[index] > arr[r]) {// 大于的话, more-- 并且对应位置和index互换, index 的值不变化, 对同一个位置再次进行判断
                swap(arr, --more, index);
            }
        }
        // 循环结束之后, 将arr[r] 和 more位置进行交换, 等于区边界即为 less+1 ~ more
        swap(arr, more, r);
        return new int[]{less + 1, more};
    }

    public static void swap(int[] arr, int p1, int p2) {
        int temp = arr[p1];
        arr[p1] = arr[p2];
        arr[p2] = temp;
    }

    // 快排对数器
    public static void testMethod(int len, int max, int times) {
        System.out.println("测试开始!!!");
        for (int i = 0; i < times; i++) {
            // 生成随机长度的数组
            int[] arr1 = generateRandomArray(len, max);
            int[] arr2 = Arrays.copyOf(arr1, arr1.length);
            Arrays.sort(arr1);
            quickSort(arr2);
            if (!Arrays.equals(arr1, arr2)) {
                System.out.println("出错了");
                System.out.println("arr1");
                System.out.println("===================");
                Arrays.stream(arr1).forEach(System.out::println);
                System.out.println("arr2");
                System.out.println("===================");
                Arrays.stream(arr2).forEach(System.out::println);
                System.out.println();
            }
        }
        System.out.println("测试结束!!!");

    }

    // 生成随机长度 随机值 数组
    public static int[] generateRandomArray(int len, int max) {
        int length = (int) (Math.random() * (len + 1));
        int[] arr = new int[length];
        // 赋值操作
        for (int i = 0; i < length; i++) {
            arr[i] = (int) (Math.random() * (max + 1)) - (int) (Math.random() * (max + 1));
        }
        return arr;
    }
}
