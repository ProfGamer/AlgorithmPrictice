package com.datastructure.algorithmprictice.myPrictice.BinarySearch;

/**
 * @Author: Xin Yuchen
 * @Date: 2022/4/21 - 04 - 21 - 23:37
 * @Description: Any Ques or Concerns, plz contact e0838400@u.nus.edu
 */

public class FindFirstAndLastEleInSortedArray {
    public static void main(String[] args) {
        int[] arr = {5,7,7,8,8,10};
        int[] res = searchRange(arr,8);
        System.out.println(res[0] + " " + res[1]);
    }
    public static int[] searchRange(int[] nums, int target) {

        int first = binarySearchFirst(nums, target, 0,nums.length-1, -1);
        int last = binarySearchLast(nums, target, 0, nums.length-1, -1);
        return new int[]{first,last};
    }
    public static int binarySearchFirst(int[] nums, int target, int left, int right, int index){
        if(left>right){
            return index;
        }
        if(left == right){
            return nums[left]==target? left : index;
        }
        int middle = left + (right -left)/2;
        if(nums[middle] == target){
            index = middle;
            return binarySearchFirst(nums, target, left, middle-1, index);
        }
        if(nums[middle] < target){
            return binarySearchFirst(nums, target, middle+1,right, index);
        }else{
            return binarySearchFirst(nums,target,left,middle-1, index);
        }
    }
    public static int binarySearchLast(int[] nums, int target, int left, int right, int index){
        if(left>right){
            return index;
        }
        if(left == right){
            return nums[right]==target? right : index;
        }
        int middle = left + (right -left)/2;
        if(nums[middle] == target){
            index = middle;
            return binarySearchLast(nums, target, middle+1, right, index);
        }
        if(nums[middle] < target){
            return binarySearchLast(nums, target, middle+1,right, index);
        }else{
            return binarySearchLast(nums,target,left,middle-1, index);
        }
    }
}
