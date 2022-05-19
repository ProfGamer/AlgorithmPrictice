package com.datastructure.algorithmprictice.myPrictice.Sorting.Heap;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @Author: Xin Yuchen
 * @Date: 2022/5/15 - 05 - 15 - 14:04
 * @Description: Any Ques or Concerns, plz contact e0838400@u.nus.edu
 */
// 给定一个几乎有序的数组,和一个数K,
// 几乎有序是指,如果把数组排好序,每个元素与移动的距离一定不超过K,并且k相对于数组长度来说很小
// 实现一个合适的排序策略
// [3,4,1,2,5] k=2 -> [1,2,3,4,5]
public class SortArrLessThanKDistance {
    public static void main(String[] args) {
        int[] arr = {3,4,1,2,5};
        sortArrLessThanKDistance(arr,2);
        Arrays.stream(arr).forEach(System.out::println);
    }
    public static void sortArrLessThanKDistance(int[] arr, int k) {
        // 我们这里使用堆排序
        // 从题意我们可以得出, arr[0] 位置的数一定是 [0] [1] [2] ... [k] 中的最小值
        // 新建一个小根堆,把0~k的元素都放进去, 然后弹出顶部放在[0]
        PriorityQueue<Integer> smallHeap = new PriorityQueue<>();
        for(int i = 0; i <= k ; i++){
            smallHeap.add(arr[i]);
        }
        int index = 0;
        while(smallHeap.size()!=0){
            arr[index] = smallHeap.poll();
            if(index+k+1 < arr.length){
                smallHeap.add(arr[index+k+1]);
            }
            index++;
        }
    }
}
