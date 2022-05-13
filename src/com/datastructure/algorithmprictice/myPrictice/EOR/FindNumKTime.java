package com.datastructure.algorithmprictice.myPrictice.EOR;

import java.util.HashMap;

/**
 * @Author: Xin Yuchen
 * @Date: 2022/5/3 - 05 - 03 - 18:51
 * @Description: Any Ques or Concerns, plz contact e0838400@u.nus.edu
 */
// 一个数组中有一种数出现K次 其他数都出现了M次
// M>1 K<M 找到那个出现了K次的数 要求空间复杂度O(1) 时间复杂度O(N)
public class FindNumKTime {
    public static void main(String[] args) {
        int[] testArr = {1,1,1,1,2,2,2,2,3,3,3,3,4,4,4};
        System.out.println(findOnlyKTimesNum(testArr,3,4));
    }
    public static int findOnlyKTimesNum(int[] arr, int k , int m){
        //新建一个辅助map 用来记录整个arr数组中所有数的位信息
        HashMap<Integer,Integer> tempMap = new HashMap<>();
        // Integer 创建32个键值对就可以
        for(int i = 0 ; i < 32 ; i++){
            tempMap.put(i,0);
        }
        // 对数组中的每个数进行遍历， 将32位信息录入tempMap
        for(Integer num : arr){
            for(int i = 0 ; i < 32 ; i++){
                if(((num>>i) & 1) != 0){// 证明num的i位置为1，需要录入tempMap
                    tempMap.put(i,tempMap.get(i)+1);
                }
            }
        }
        // 这个遍历结束之后 tempMap中已经有了arr中所有数的位信息， 我们开始组合出最后的TargetAns
        int ans = 0; // 因为要做|运算 所以这里的初始值必须是0
        for(Integer position: tempMap.keySet()){
            // 如果位信息不能被m整除 则代表最后的targetAns在此位置上一定为1
            if(tempMap.get(position) % m !=0){
                // 所以我们将1左移position为并且|运算至ans组合出最后的targetAns
                ans |= 1<<position;
            }
        }
        return ans;

    }
}
