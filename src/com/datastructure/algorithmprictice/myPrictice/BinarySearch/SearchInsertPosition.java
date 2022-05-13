package com.datastructure.algorithmprictice.myPrictice.BinarySearch;

/**
 * @Author: Xin Yuchen
 * @Date: 2022/4/22 - 04 - 22 - 14:17
 * @Description: Any Ques or Concerns, plz contact e0838400@u.nus.edu
 */
// https://leetcode-cn.com/problems/search-insert-position/
public class SearchInsertPosition {
    public static void main(String[] args) {
        int[] arr = {1,3,5,6};
        System.out.println(searchInsert(arr,5));
        System.out.println(searchInsert(arr,2));
        System.out.println(searchInsert(arr,7));
    }
    public static int searchInsert(int[] nums, int target) {
        return binarySearchInsertPosition(nums, target, 0 , nums.length-1);
    }
    public static int binarySearchInsertPosition(int[] nums, int target, int left, int right){
        if(left>right){
            return left;
        }
        int middle = left + ((right -left)>>1);
        if(nums[middle] == target){
            return middle;
        }
        if(nums[middle] > target){
            return binarySearchInsertPosition(nums, target,left, middle-1);
        }else{
            return binarySearchInsertPosition(nums,target, middle+1, right);
        }
    }
}
