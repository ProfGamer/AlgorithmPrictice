package com.datastructure.algorithmprictice.myPrictice.EOR;



/**
 * @Author: Xin Yuchen
 * @Date: 2022/4/29 - 04 - 29 - 14:21
 * @Description: Any Ques or Concerns, plz contact e0838400@u.nus.edu
 */
// 如何找到一个整型 二进制下最右侧的1的位置？
public class FindIntRightestOne {
    public static void main(String[] args) {
        int a = 64;
        int rightestOne = a & (~a+1); // a & -a
        System.out.println(rightestOne);
    }

}
