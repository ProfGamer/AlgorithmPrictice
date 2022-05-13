package com.datastructure.algorithmprictice.myPrictice.EOR;

/**
 * @Author: Xin Yuchen
 * @Date: 2022/4/29 - 04 - 29 - 14:09
 * @Description: Any Ques or Concerns, plz contact e0838400@u.nus.edu
 */
// 如果一个数组中, 只有一个数出现了奇数次, 剩余的所有数都出现了偶数次, 请找出出现奇数次的这个数
public class FindOddTimeNumInArr {
    public static void main(String[] args) {
        int[] arr = {1,1,1,1,2,2,3,3,3,3,5,5,5};
        System.out.println(findOddTimeNum(arr));
    }
    // 新建一个变量eor = 0 然后将数组中所有的元素与 eor 异或赋值 最后eor的值将为出现奇数次的数
    public static int findOddTimeNum(int[] arr){
        int eor = 0;
        for (int i = 0 ; i < arr.length ; i++){
            eor = eor ^ arr[i];
        }
        return eor;
    }
}
