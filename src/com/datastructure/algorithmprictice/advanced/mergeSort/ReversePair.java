package com.datastructure.algorithmprictice.advanced.mergeSort;

/**
 * 翻转对问题 <a href="https://leetcode.cn/problems/reverse-pairs/description/">力扣测试链接</a>
 */
public class ReversePair {
    public static int[] DATA;
    public static int[] HELP = new int[50001];
    public static int SIZE;

    public int reversePairs(int[] nums) {
        if (nums == null || nums.length == 1) return 0;
        DATA = nums;
        SIZE = DATA.length;
        return reversePairRecursion(0, SIZE -1);
    }

    public static int reversePairRecursion(int l, int r) {
        if (l == r) {
            return 0;
        }
        int m = l + (r - l) / 2;
        return reversePairRecursion(l, m) + reversePairRecursion(m+1, r) + merge(l , m, r);
    }

    public static int merge(int l, int m, int r) {
        int result = 0;
        // 2 4 6 1 3 5
        // i     j
        for(int i = l, j = m + 1; i <= m ; i++) {
            while(j <= r && (long)DATA[i] > (long)2*DATA[j]) {
                j++;
            }
            result += j - m - 1; // 加上 j走过的长度
        }
        int helpIndex = l;
        int leftIndex = l;
        int rightIndex = m + 1;
        while (leftIndex <= m && rightIndex <= r) {
            HELP[helpIndex++] = DATA[leftIndex] <= DATA[rightIndex] ? DATA[leftIndex++] : DATA[rightIndex++];
        }
        while (leftIndex <= m) {
            HELP[helpIndex++] = DATA[leftIndex++];
        }
        while (rightIndex <= r) {
            HELP[helpIndex++] = DATA[rightIndex++];
        }
        for(; l <= r; l++) {
            DATA[l] = HELP[l];
        }
        return result;
    }
}
