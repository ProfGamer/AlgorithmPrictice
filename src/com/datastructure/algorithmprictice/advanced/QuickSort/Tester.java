package com.datastructure.algorithmprictice.advanced.QuickSort;

import java.util.Arrays;

public class Tester {
    public static void main(String[] args) {
        QuickSort qs = new QuickSort();
        FindKthLargest k = new FindKthLargest();
        int[] arr = new int[]{3,2,1,5,6,4};
        // System.out.println(Arrays.toString(qs.sortArray(arr)));
        System.out.println(k.findKthLargest(arr, 2));
    }
}
