package com.datastructure.algorithmprictice.myPrictice.EOR;

/**
 * @Author: Xin Yuchen
 * @Date: 2022/4/29 - 04 - 29 - 15:02
 * @Description: Any Ques or Concerns, plz contact e0838400@u.nus.edu
 */
// 在一个数组中 有两种数出现了奇数次 其他的数都出现了偶数次， 找到这两个出现了奇数次的数
public class FindTwoOddTimeNum {
    public static void main(String[] args) {
        int[] arr = {1,1,1,1,2,2,2,2,3,4,4,5,5,5,6,6}; // a = 3 b = 5
        // 首先我们对整个数组进行一次异或运算
        int initEor = 0;
        for (int i = 0 ; i < arr.length ; i++) {
            initEor ^= arr[i];
        }
        // 这次异或运算之后，initEor == a ^ b; 因为a b是两种数 所以initEor一定是不为0的
        // 我们找到a^b结果最右侧的1 ->也就是a b 在这个1的位置一定不相等 -> 一个是1 另一个是0
        int rightestOne = initEor & (-initEor); // 这样来获得最右侧 1 的位置
        int finalEor = 0;
        // 再对数组进行遍历， 但是这次我们根据 & rightestOne的结果来进行划分
        for (int i = 0 ; i < arr.length ; i++){
            if((arr[i] & rightestOne) !=0){ // 如果& rightestOne结果不为0 则证明该数在此位置一定为1
                finalEor ^= arr[i];
            }
        }
        // 最后我们将得到a 或者 b中一个数的值
        System.out.println(finalEor + "  " + (finalEor ^ initEor));
    }

}
