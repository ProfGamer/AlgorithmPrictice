package com.datastructure.algorithmprictice.myPrictice.BinarySearch;

/**
 * @Author: Xin Yuchen
 * @Date: 2022/4/22 - 04 - 22 - 14:41
 * @Description: Any Ques or Concerns, plz contact e0838400@u.nus.edu
 */
// https://leetcode-cn.com/problems/sqrtx/
public class SqrtOfX {
    public static void main(String[] args) {
        System.out.println(mySqrt(0));
    }
    public static int mySqrt(int x) {
        if(x== 1 || x == 0){
            return x;
        }
        return binarySearchSqrt(x,0,x);
    }
    public static int binarySearchSqrt(int x, int left, int right){
        if(left > right){
            return right;
        }
        int middle = left + ((right-left)>>1);
        if (x/middle == middle){
            return middle;
        }
        if(x/middle > middle){
            return binarySearchSqrt(x,middle+1,right);
        }else{
            return binarySearchSqrt(x, left, middle-1);
        }
    }
}
