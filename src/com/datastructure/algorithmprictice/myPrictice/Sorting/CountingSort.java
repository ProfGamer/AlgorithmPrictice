package com.datastructure.algorithmprictice.myPrictice.Sorting;

import java.util.Arrays;

/**
 * @Author: Xin Yuchen
 * @Date: 2022/5/10 - 05 - 10 - 9:08
 * @Description: Any Ques or Concerns, plz contact e0838400@u.nus.edu
 */
// 数组的值 需要确定最大值 可以通过在最后填充的时候, 反向遍历数组来保证稳定性
public class CountingSort {
    public static void main(String[] args) {
        testCountingSort(10,20,1000);
    }
    public static void countingSort(int[] arr){
        if(arr == null || arr.length < 2){
            return;
        }
        int max = Integer.MIN_VALUE;
        // 我们先找到数组的最大值
        for(Integer num : arr){
            if (num > max){
                max = num;
            }
        }
        // 创建一个用来计数的辅助数组 数组的长度为max+1
        int[] helpArr = new int[max+1]; // index -> 0 ~ max
        // 因为要保证稳定性, 我们再搞一个新数组
        int[] newArr = new int [arr.length];
        // 开始用for循环计数, 将计数结果累加至helpArr
        for(int i = 0 ; i < arr.length ; i++){
            helpArr[arr[i]]++;
        }
        // 将helpArr的索引值再加上前一项
        for(int i = 1 ; i < helpArr.length ; i++){
            helpArr[i] += helpArr[i-1];
        }
        // 开始从右往左遍历arr 填到新的数组newArr 这样可以保证稳定性
        for(int i = arr.length-1 ; i>=0 ; i--){
            newArr[helpArr[arr[i]]-1] = arr[i];
            helpArr[arr[i]]--;
        }
        for(int i = 0 ; i < arr.length ; i++){
            arr[i] = newArr[i];
        }
    }
    public static void testCountingSort(int len, int max, int times){
        System.out.println("测试开始!!!");
        for(int i = 0 ; i < times ; i++){
            int[] arr1 = generatePositiveArray(len,max);
            int[] arr2 = Arrays.copyOf(arr1,arr1.length);
            Arrays.sort(arr1);
            countingSort(arr2);
            if(!Arrays.equals(arr1,arr2)){
                System.out.println("出错了!!!");
            }
        }
        System.out.println("测试结束!!");
    }
    public static int[] generatePositiveArray(int len, int max){
        len = (int)(Math.random()*(len+1));
        int[] arr = new int[len];
        for(int i = 0 ; i < len ; i++){
            arr[i] = (int)(Math.random()*(max+1));
        }
        return arr;
    }

}
