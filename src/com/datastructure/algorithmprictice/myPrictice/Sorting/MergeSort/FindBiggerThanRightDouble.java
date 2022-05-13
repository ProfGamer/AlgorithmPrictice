package com.datastructure.algorithmprictice.myPrictice.Sorting.MergeSort;

import myPrictice.Sorting.CountingSort;

/**
 * @Author: Xin Yuchen
 * @Date: 2022/5/11 - 05 - 11 - 17:04
 * @Description: Any Ques or Concerns, plz contact e0838400@u.nus.edu
 */
// 一个数组中 一个数A 右边的 所有数中 有B 如果 A > B*2 那么认为 B是A 的 BiggerThanRightDouble 数, 求一个数组中这种数的总数
// 依旧采用归并排序 但是我们在对 左右两个int[] 进行merge前, 计算 BiggerThanRightDouble数 的总数
// 因为左右两组数组均各自有序 所以上面的计算仍然是O(N) 复杂度
public class FindBiggerThanRightDouble {
    public static void main(String[] args) {
        testBiggerThanRightDouble(10, 10, 10000);
    }

    // 这个问题可以在MergeSort的同时完成
    public static int findBiggerThanRightDouble(int[] arr) {
        if (arr == null || arr.length < 2) {
            return 0;
        }
        return process(arr, 0, arr.length - 1);
    }

    // 这个方法找出arr中点, 然后对左右两段递归, 结果再merge在一起
    private static int process(int[] arr, int l, int r) {
        // 递归结束条件 数组范围只有一个元素 此时不产生BiggerThanRightDouble数
        if (l >= r) {
            return 0;
        }
        int middle = l + ((r - l) >> 1);
        return process(arr, l, middle) + process(arr, middle + 1, r) + merge(arr, l, middle, r);
    }

    // 这个方法将会将l-r上排序, 并且返回 l-middle 与 middle-r 相比 BiggerThanRightDouble数的个数
    private static int merge(int[] arr, int l, int middle, int r) {
        // 先计算BiggerThanRightDouble 再排序
        int totalBiggerThanRightDouble = 0;
        int border = middle + 1;
        for (int i = l; i <= middle; i++) {
            // 尝试将 border 尽可能向右移动
            while (border <= r && arr[i] > (arr[border] * 2)) {
                border++;
            }
            // 从 (middle + 1 到 border) 再减 1
            totalBiggerThanRightDouble += border - middle - 1;
        }
        int p1 = l;
        int p2 = middle + 1;
        int index = 0;
        int[] helpArr = new int[r - l + 1]; // 创建一个辅助数组, 排序完之后要再拷贝回原数组的
        // 当两段数组都还有数时
        while (p1 <= middle && p2 <= r) {
            if (arr[p1] < arr[p2]) {
                helpArr[index++] = arr[p1++];
            } else {
                helpArr[index++] = arr[p2++];
            }
        }
        while (p1 <= middle) {
            helpArr[index++] = arr[p1++];
        }
        while (p2 <= r) {
            helpArr[index++] = arr[p2++];
        }
        // 把helpArr拷贝至 arr 的 l~r区域
        for (int i = 0; i < helpArr.length; i++) {
            arr[l++] = helpArr[i];
        }
        return totalBiggerThanRightDouble;
    }

    public static int forceBiggerThanRightDouble(int[] arr) {

        // 暴力双循环解法
        int total = 0;
        // 每到一个数, 遍历他之后的所有数, 看看是不是BiggerThanRightDouble
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                if (arr[i] > arr[j]*2) {
                    total++;
                }
            }
        }
        return total;
    }

    public static void testBiggerThanRightDouble(int len, int max, int times) {
        System.out.println("测试开始!!!");
        for (int i = 0; i < times; i++) {
            int[] arr1 = CountingSort.generatePositiveArray(len, max);
            if (forceBiggerThanRightDouble(arr1) != findBiggerThanRightDouble(arr1)) {
                System.out.println("出错了!!!");
            }
        }
        System.out.println("测试结束!!");
    }
}
