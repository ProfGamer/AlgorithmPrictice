package com.datastructure.algorithmprictice.myPrictice.BinarySearch;

/**
 * @Author: Xin Yuchen
 * @Date: 2022/4/20 - 04 - 20 - 15:37
 * @Description: Any Ques or Concerns, plz contact e0838400@u.nus.edu
 */
// 找到两个有序数组的中位数
// https://leetcode-cn.com/problems/median-of-two-sorted-arrays/
public class MedianOfTwoSortedArray {
    public static void main(String[] args) {
        int[] arr1 = {3};
        int[] arr2 = {1,2,4};
        System.out.println(findKMinNum(arr1,arr2,2,0,0,2));
        System.out.println(findKMinNum(arr1,arr2,3,0,0,3));
        //System.out.println((findKMinNum(arr1,arr2,2,0,0,2)+findKMinNum(arr1,arr2,3,0,0,3))/2.0);
        //System.out.println(findMedianSortedArrays(arr1,arr2));
        //System.out.println(0.0/2.0);
    }
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // 已知两个有序数组的长度，返回合并数组的中位数
        int length1 = nums1.length;
        int length2 = nums2.length;
        int total = length1+length2;
        double ans = 0;
        if(length1 == 0){
            return length2%2 == 1? (double)nums2[length2/2+1]: (nums2[length2/2 +1] + nums2[length2/2])/2.0;
        }
        if(length2 == 0){
            return length1%2 == 1? (double)nums1[length2/2+1]: (nums1[length1/2 +1] + nums1[length1/2])/2.0;
        }
        if((total%2) ==1){
            ans = findKMinNum(nums1,nums2,total/2 + 1,0,0,total/2 + 1);
        }else{
            ans = (findKMinNum(nums1,nums2,total/2,0,0,total/2)
                    +findKMinNum(nums1,nums2,total/2 + 1,0,0,total/2 + 1))/2.0;
        }
        return ans;
    }
    public static int findKMinNum(int[] nums1, int[] nums2, int k, int nums1Border, int nums2Border, int originK){
        if(nums1Border > nums1.length -1 || nums2Border > nums2.length -1){
           return nums1Border > nums1.length -1? nums2[nums2Border+k-1] : nums1[nums1Border+k-1];
        }
        if(k==1){
            return nums1[nums1Border] < nums2[nums2Border]? nums1[nums1Border] : nums2[nums2Border];
        }
        if(k/2 > nums1.length){
            if(nums1[nums1.length-1]<= nums2[nums2Border+(k/2)-1]){
                return nums2[originK-(nums1.length)-1];
            }else{
                return findKMinNum(nums1,nums2,k-(k/2),0,k/2,originK);
            }
        }
        if(k/2 > nums2.length){
            if(nums2[nums2.length-1]<= nums1[nums1Border+(k/2)-1]){
                return nums1[originK-(nums2.length)-1];
            }else{
                return findKMinNum(nums1,nums2,k-(k/2),k/2,0,originK);
            }
        }
        if(nums1[nums1Border + (k/2) -1] <= nums2[nums2Border + (k/2) -1]){
            return findKMinNum(nums1,nums2,k-(k/2),nums1Border+(k/2),nums2Border,originK);
        }else{
            return findKMinNum(nums1,nums2,k-(k/2),nums1Border,nums2Border+(k/2),originK);
        }
    }
}
