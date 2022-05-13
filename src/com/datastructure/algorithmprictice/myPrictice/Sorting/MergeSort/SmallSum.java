package com.datastructure.algorithmprictice.myPrictice.Sorting.MergeSort;

import com.datastructure.algorithmprictice.myPrictice.Sorting.CountingSort;


/**
 * @Author: Xin Yuchen
 * @Date: 2022/5/11 - 05 - 11 - 15:24
 * @Description: Any Ques or Concerns, plz contact e0838400@u.nus.edu
 */
// 小和问题
// 一个数组每一位索引的小和是前面所有小于这个索引处值的数之和 返回这个数组所有的小和之和
public class SmallSum {
    public static void main(String[] args) {
        testSmallSum(10,10,1000);
    }
    // 小和问题可以在MergeSort的同时完成
    public static int smallSum(int[] arr) {
        if (arr == null || arr.length < 2) {
            return 0;
        }
        return process(arr, 0, arr.length - 1);
    }

    // 这个方法找出arr中点, 然后对左右两段递归, 结果再merge在一起
    private static int process(int[] arr, int l, int r) {
        // 递归结束条件 数组范围只有一个元素 此时不产生小和
        if (l >= r) {
            return 0;
        }
        int middle = l + ((r - l) >> 1);
        return process(arr, l, middle) + process(arr, middle + 1, r) + merge(arr, l, middle, r);
    }

    // 这个方法将会将l-r上排序, 并且返回 l-middle 与 middle-r 相比 产生的小和
    private static int merge(int[] arr, int l, int middle, int r) {
        int p1 = l;
        int p2 = middle + 1;
        int index = 0;
        int[] helpArr = new int[r - l + 1]; // 创建一个辅助数组, 排序完之后要再拷贝回原数组的
        int smallSum = 0;
        // 当两段数组都还有数时
        while (p1 <= middle && p2 <= r) {
            if (arr[p1] < arr[p2]) { // 左侧小于右侧,此时要计算小和
                smallSum += arr[p1] * (r - p2 + 1);
                helpArr[index++] = arr[p1++];

            } else { // 相等 或者 右边大的时候 只排序 不计算小和
                // 但是相等的时候我们将右组的放进去 [1,2,3] [2,2,4]
                // 不然小和之后就算不对了 因为左组的数可能之后还会产生小和,不能将p1前进
                helpArr[index++] = arr[p2++];
            }
        }
        // 这个while出来之后, 一定有一个p1 p2 越界了 我们不计算小和, 而是直接把数插入进helpArr即可
        while(p1 <= middle){
            helpArr[index++] = arr[p1++];
        }
        while(p2 <= r){
            helpArr[index++] = arr[p2++];
        }
        // 把helpArr拷贝至 arr 的 l~r区域
        for(int i = 0 ; i < helpArr.length ; i++){
            arr[l++] = helpArr[i];
        }
        return smallSum;
    }

    public static int forceSmallSum(int[] arr){

        // 暴力双循环解法
        int smallSum = 0;
        for(int i = 0; i < arr.length;i++){
            for(int j = 0 ; j < i ;j++){
                if(arr[j] < arr[i]){
                    smallSum += arr[j];
                }
            }
        }
        return smallSum;
    }
    public static void testSmallSum(int len, int max, int times){
        System.out.println("测试开始!!!");
        for(int i = 0; i < times; i++){
            int[] arr1 = CountingSort.generatePositiveArray(len,max);
            if(forceSmallSum(arr1) != smallSum(arr1)){
                System.out.println("出错了!!!");
            }
        }
        System.out.println("测试结束!!");
    }
}
