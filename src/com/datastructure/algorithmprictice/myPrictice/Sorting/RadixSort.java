package com.datastructure.algorithmprictice.myPrictice.Sorting;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author: Xin Yuchen
 * @Date: 2022/5/10 - 05 - 10 - 12:45
 * @Description: Any Ques or Concerns, plz contact e0838400@u.nus.edu
 */
// 基数排序 -> 桶排序, 不基于比较的排序, 可以保证稳定性
// 只能适用于非负数组情况下 (排年龄身高什么的)
public class RadixSort {
    public static void main(String[] args) {
        int[] arr = {29,1,99,10,221,101,7,9,31};
        radixSort(arr);
        for(int i = 0 ; i < arr.length ; i++){
            System.out.println(arr[i]);
        }
    }
    public static void radixSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        radixSort(arr, 0, arr.length - 1, maxDigit(arr));
    }

    public static void radixSort(int[] arr, int l, int r, int maxDigit) {
        // 我们先准备十个桶
        ArrayList<Queue<Integer>> buckets = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Queue<Integer> q = new LinkedList<>();
            buckets.add(q);
        }
        int newIndex = 0;
        // maxDigit是几, 我们就需要进行几次入出桶操作
        for (int i = 1; i <= maxDigit; i++) { // 先判断个位 再十位 百位...
            // 开始从左至右入桶
            for (int j = 0; j < arr.length; j++) {
                // 我们要直到arr[j] 第i位是digit,放进对应的buckets[digit]的桶
                int digit = getDigit(arr[j], i);
                buckets.get(digit).add(arr[j]);
            }
            // 开始出桶, 桶中的元素先入先出
            for(int k = 0 ; k < 10 ; k++){
                while(!buckets.get(k).isEmpty()){
                    arr[newIndex] = buckets.get(k).poll();
                    newIndex++;
                }
            }
            newIndex = 0;
        }
    }

    public static int getDigit(int num, int digit) {
        // num = 221 digit=1 -> 取个位
        // 221 / (10^(digit-1)) % 10 =1
        // digit =2 -> 取十位
        // 221 / (10^(2-1)) % 10 =2
        // digit =3 -> 取百位
        // 221/ (10 ^ (3-1)) % 10 = 2
        return (num / ((int) Math.pow(10, digit - 1)) % 10);
    }

    // 这个方法需要返回这个数组中最大值是几位数
    public static int maxDigit(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
        }
        // 返回最大值是几位数
        int digit = 0;
        while (max != 0) {
            digit++;
            max /= 10;
        }
        return digit;
    }
}
