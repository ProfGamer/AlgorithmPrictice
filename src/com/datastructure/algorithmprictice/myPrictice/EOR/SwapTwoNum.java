package com.datastructure.algorithmprictice.myPrictice.EOR;

import java.util.Arrays;

/**
 * @Author: Xin Yuchen
 * @Date: 2022/4/27 - 04 - 27 - 13:06
 * @Description: Any Ques or Concerns, plz contact e0838400@u.nus.edu
 */
//使用异或运算 不使用额外变量 交换数组中两个数字的位置
public class SwapTwoNum {
    public static void main(String[] args) {
        int[] arr = {0,1,2,3,4,5,6,7};
        swap(arr,0,6);
        Arrays.stream(arr).forEach(System.out::print);
    }
    // 使用异或运算交换数组中两个数的位置
    public static void swap(int[] arr, int p1, int p2){
        arr[p1] = arr[p1] ^ arr[p2];
        arr[p2] = arr[p1] ^ arr[p2];
        arr[p1] = arr[p1] ^ arr[p2];
    }
}

