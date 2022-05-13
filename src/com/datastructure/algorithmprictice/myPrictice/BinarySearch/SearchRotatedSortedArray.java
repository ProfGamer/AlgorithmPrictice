package com.datastructure.algorithmprictice.myPrictice.BinarySearch;

/**
 * @Author: Xin Yuchen
 * @Date: 2022/4/20 - 04 - 20 - 17:47
 * @Description: Any Ques or Concerns, plz contact e0838400@u.nus.edu
 */
// https://leetcode-cn.com/problems/search-in-rotated-sorted-array/
public class SearchRotatedSortedArray {
    public static void main(String[] args) {
        int[] arr = {4,5,6,7,0,1,2};
        System.out.println(search(arr,2));
    }
    public static int search(int[] nums, int target) {
        return binarySearch(nums,0, nums.length-1, target);
    }
    public static int binarySearch(int[] nums, int left, int right, int target){
        if(left>right){
            return -1;
        }
        if(left == right){
            return nums[left]==target? left : -1;
        }
        int middle = (left+right)>>1;
        if(nums[middle]==target){
            return middle;
        }
        // 如果这时二分到了有序数组
        if(nums[left]<nums[right]){
            if(target < nums[middle]){
                return binarySearch(nums,left,middle-1,target);
            }else{
                return binarySearch(nums,middle+1,right,target);
            }
        }else{ //无序数组
            int rightAns = binarySearch(nums,middle+1,right,target);
            int leftAns = binarySearch(nums,left,middle-1,target);
            if(rightAns==-1 && leftAns==-1){
                return -1;
            }else{
                return rightAns==-1? leftAns : rightAns;
            }
        }

    }
}
