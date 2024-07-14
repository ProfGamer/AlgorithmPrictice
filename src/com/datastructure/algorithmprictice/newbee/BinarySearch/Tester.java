package com.datastructure.algorithmprictice.newbee.BinarySearch;

import static com.datastructure.algorithmprictice.newbee.BinarySearch.Validator.*;

public class Tester {
    public static void main(String[] args) {
        System.out.println("开始测试在有序数组中找到 >= num的最左位置: ");
        testBinarySearchLeftPosition(10, 10, 100);
        System.out.println("开始测试在有序数组num是否存在: ");
        testBinarySearch(10, 10, 100);
        System.out.println("开始测试在有序数组中找到 <= num的最右位置: ");
        testBinarySearchRightPosition(10,10,100);
        System.out.println("开始测试任意相邻元素不相等的无序数组中找到一个峰值: ");
        testBinaryFindPeak(10,10,100);
    }
}
