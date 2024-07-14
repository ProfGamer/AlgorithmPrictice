package com.datastructure.algorithmprictice.newbee.utils;

import com.datastructure.algorithmprictice.newbee.LinkedList.Node;

public class Utils {
    public static void swapTwoNumInArr(int[] arr, int index1, int index2) {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }

    /**
     * 返回一个未排序的随机整型数组, 长度在 0 ~ maxLength, 数组每个位置的值为 -maxValue ~ maxValue
     * @param maxLength 数组的最大长度
     * @param maxValue 数组每个位置的最大值 maxValue, 最小值为 -maxValue
     * @return 未排序的随机int数组
     */
    public static int[] generateRandomArray(int maxLength, int maxValue) {
        int length = (int) (Math.random() * (1 + maxLength) );
        int[] arr = new int[length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * (1 + maxValue)) - (int) (Math.random() * (1 + maxValue));
        }
        return arr;
    }

    /**
     * 返回一个未排序的随机整型数组, 长度在 0 ~ maxLength, 数组每个位置的值为 -maxValue ~ maxValue 并且任意相邻位置不相等
     * @param maxLength 数组的最大长度
     * @param maxValue 数组每个位置的最大值 maxValue, 最小值为 -maxValue
     * @return 未排序的随机int数组 其中任意相邻元素均不相等
     */
    public static int[] generateRandomArrayWithNoSameNearby(int maxLength, int maxValue) {
        int length = (int) (Math.random() * (1 + maxLength) );
        int[] arr = new int[length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * (1 + maxValue)) - (int) (Math.random() * (1 + maxValue));
            if (i > 0) {
                while (arr[i] == arr[i-1]) {
                    arr[i] = (int) (Math.random() * (1 + maxValue)) - (int) (Math.random() * (1 + maxValue));
                }
            }
        }
        return arr;
    }

    public static Node.SingleNode generateSingleNodeList(int maxLength, int maxValue) {
        int length = (int) (Math.random() * (1 + maxLength) );
        Node.SingleNode head = new Node.SingleNode();
        head.value = (int) (Math.random() * (1 + maxValue)) - (int) (Math.random() * (1 + maxValue));
        Node.SingleNode pre = head;
        Node.SingleNode next = null;
        for (int i = 1; i < length; i++) {
            next = new Node.SingleNode();
            next.value = (int) (Math.random() * (1 + maxValue)) - (int) (Math.random() * (1 + maxValue));
            pre.next = next;
            pre = next;
        }
        return head;
    }
}
