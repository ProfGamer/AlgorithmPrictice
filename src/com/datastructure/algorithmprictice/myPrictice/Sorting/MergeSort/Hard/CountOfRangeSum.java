package com.datastructure.algorithmprictice.myPrictice.Sorting.MergeSort.Hard;

import myPrictice.Sorting.QuickSort;

/**
 * @Author: Xin Yuchen
 * @Date: 2022/5/11 - 05 - 11 - 17:41
 * @Description: Any Ques or Concerns, plz contact e0838400@u.nus.edu
 */
// https://leetcode.cn/problems/count-of-range-sum/
public class CountOfRangeSum {
    public static void main(String[] args) {
        testCountOfRangeSum(10,10,1000,5);
    }
    public static void testCountOfRangeSum(int len, int max, int times, int range){
        System.out.println("测试开始!!");
        for(int i = 0 ; i < times ; i++){
            int[] arr = QuickSort.generateRandomArray(len,max);
            int lower = (int) (Math.random()*(range+1)) - (int) (Math.random()*(range+1));
            int upper = (int) (Math.random()*(range+1)) - (int) (Math.random()*(range+1));
            if(upper < lower){
                upper = upper - lower;
                lower = lower + upper ;
                upper = lower - upper;
            }
            if(forceCountOfRangeSum(arr,lower,upper) != countOfRangeSum(arr,lower,upper)){
                System.out.println("出错了!");
            }
        }
        System.out.println("测试结束!");
    }

    /**
     * 使用归并排序的思路 将算法时间复杂度提升为O(N*logN)
     *
     * @param arr
     * @param lower 初始下界
     * @param upper 初始上界
     * @return
     */
    public static int countOfRangeSum(int[] arr, int lower, int upper) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        // 在递归中, 我们只需要使用 前缀和 sum 数组即可, 不需要使用原数组arr
        long[] sum = getPreSumArray(arr);
        return process(sum, 0, sum.length - 1, lower, upper);
    }

    public static int process(long[] sum, int l, int r, int lower, int upper) {
        if (l == r) { // 代表着sum数组中 l和r来到了同一个位置, 此时判断的子数组为 arr[0] ~ arr[l], 我们直接判断sum[l]是否符合初始边界即可
            if (sum[l] >= lower && sum[l] <= upper) {
                return 1;
            } else {
                return 0;
            }
        }
        // 此时的子数组 一定不是 0~x的范围,一定是有个左数组 有个右数组 我们在左右两边递归process
        int middle = l + ((r - l) >> 2);
        int left = process(sum, l, middle, lower, upper);
        int right = process(sum, middle + 1, r, lower, upper);
        int res = merge(sum, l, middle, r, lower, upper); // 此时左右数组已经有序了, 我们在merge方法中计算本次左右merge所产生的结果数
        return left + right + res;
    }

    public static int merge(long[] sum, int l, int middle, int r, int lower, int upper) {
        // 我们先算结果 再进行排序
        // 创建一个左闭又开的滑动窗口 -> 双指针 -> 这个指针并不会回退 因为左右数组都是各自有序的
        //[1,4,5,7] [2,5,5,6]
        //初始是[l,l) 容量为0
        int windowLeft = l;
        int windowRight = l;
        int res = 0;
        for (int i = middle + 1; i <= r; i++) { // 对右组遍历 然后滑动左组的窗口
            // 重新生成上下界
            // 如果子数组 arr[x] ~ arr[y] 的区间和 在[lower,upper]上 那么一定有:
            // sum[y] - sum[x-1] 在 [lower,upper]上, 即:
            // 对位置 y 而言, 如果 存在一个位置 x (x<y)  sum[x]的值在[ sum[y]-upper , sum[y]-lower ]上 那就一定有一个 以y位置结尾的子数组,满足题目条件
            // [10,15] [3,3] [11,12]
            long newLower = sum[i] - upper;
            long newUpper = sum[i] - lower;
            // 滑动 windowLeft 和 windowRight
            while (windowLeft <= middle && sum[windowLeft] < newLower) {
                windowLeft++;
            }
            while (windowRight <= middle && sum[windowRight] <= newUpper) {
                windowRight++;
            }
            // 因为 [l~ middle] 和 [middle+1, r]上 都是有序的, 所以两个窗口指针是不回退的
            res += (windowRight - windowLeft); // [l,r)上一共有 r-l个数 满足条件
        }
        // 进行排序
        int p1 = l;
        int p2 = middle+1;
        int index =0;
        long[] helpArr = new long[r-l+1];
        while( p1 <= middle && p2 <=r){
            helpArr[index++] = sum[p1] <= sum[p2] ? sum[p1++] : sum[p2++];
        }
        while(p1 <= middle){
            helpArr[index++] = sum[p1++];
        }
        while(p2 <= r){
            helpArr[index++] = sum[p2++];
        }
        for(int i = 0 ; i < helpArr.length ; i++){
            sum[l+i] = helpArr[i];
        }
        return res;
    }

    /**
     * 暴力算法, O(N^2)级别, 两次遍历确定符合条件的子数组起点 & 终点
     *
     * @param arr   整型数组
     * @param lower 子数组区间和下界
     * @param upper 子数组区间和上界
     * @return 有多少子数组的区间和满足[lower, upper] 左闭右闭区间
     */
    public static int forceCountOfRangeSum(int[] arr, int lower, int upper) {
        if(arr == null || arr.length ==0){
            return 0;
        }
        long[] sum = getPreSumArray(arr); // 获取到前缀和数组
        int count = 0;
        for (int start = 0; start < arr.length; start++) { //起点
            for (int end = start; end < arr.length; end++) { // 终点
                // 获取start ~ end区间的区间和
                if (start == 0) { //区间和直接就是sum[end]
                    if (sum[end] >= lower && sum[end] <= upper) {
                        count++;
                    }
                } else { // 区间和为 sum[end] - sum[start-1]
                    if (sum[end] - sum[start - 1] >= lower && sum[end] - sum[start - 1] <= upper) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    /**
     * 传入一个数组, 传回一个该数组的前缀和数组
     * arr[1,2,3,4,5] -> res[1,3,6,10,15]
     *
     * @param arr
     * @return
     */
    public static long[] getPreSumArray(int[] arr) {

        long[] res = new long[arr.length];
        res[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            res[i] = res[i - 1] + arr[i];
        }
        return res;
    }
}
