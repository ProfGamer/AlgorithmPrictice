package com.datastructure.algorithmprictice.myPrictice.Sorting;

import java.util.Arrays;

/**
 * @Author: Xin Yuchen
 * @Date: 2022/5/5 - 05 - 05 - 1:22
 * @Description: Any Ques or Concerns, plz contact e0838400@u.nus.edu
 */
public class ShortestUnsortedSubarray {
    public static void main(String[] args) {
        int[] arr = {2,6,8,4,9,15}; //{1,2,3,4,5}
        System.out.println(betterTwoPointer(arr));
    }
    public static int findUnsortedSubarray(int[] nums) {
        // 我们这里先使用先拍排序后查找的方法
        int[] sortedNums = Arrays.copyOf(nums,nums.length);
        Arrays.sort(sortedNums);
        int start = -1;
        int end = -1;
        int leftIndex = 0;
        int rightIndex = nums.length-1;
        while(start==-1 || end==-1){
            if(start==-1 && sortedNums[leftIndex]!=nums[leftIndex]){
                start = leftIndex;
            }
            if(sortedNums[leftIndex]==nums[leftIndex]){
                leftIndex++;
            }
            if(end==-1 && sortedNums[rightIndex]!=nums[rightIndex]){
                end = rightIndex;
            }
            if(sortedNums[rightIndex]==nums[rightIndex]){
                rightIndex--;
            }
            if(leftIndex>=nums.length || rightIndex<=0){
                break;
            }
        }
        if(start==-1 && end==-1){
            return 0;
        }
        return rightIndex-leftIndex+1;
    }
    // 使用双指针两次遍历的方法
    public static int findShortestSubArray(int[] arr){
        //先从左往右遍历 记录最大值， 每一个小于最大值的位置都是需要重排的， 记录最后一个位置
        int rightBorder = -2;
        int max = arr[0];
        for(int i = 0 ; i < arr.length ; i++){
            if(arr[i]>=max){
                max = arr[i];
            }else{
                rightBorder = i;
            }
        }
        //再从右往左遍历 记录最小值， 每一个大于最小值的位置都是需要重排的， 记录最后一个位置
        int leftBorder = -1;
        int min = arr[arr.length-1];
        for(int i = arr.length-1 ; i>=0 ; i--){
            if(arr[i]<=min){
                min = arr[i];
            }else{
                leftBorder = i;
            }
        }
        return rightBorder - leftBorder + 1;
    }
    public static int betterTwoPointer(int[] arr){
        int rightBorder = -2;
        int leftBorder = -1;
        int max = arr[0];
        int min = arr[arr.length-1];
        for(int i = 0 ; i < arr.length ; i++){
            if(arr[i]>=max){
                max = arr[i];
            }else{
                rightBorder = i;
            }
            if(arr[arr.length-1-i] <= min){
                min = arr[arr.length-1-i];
            }else{
                leftBorder = arr.length-1-i;
            }
        }
        return rightBorder-leftBorder+1;
    }
}
