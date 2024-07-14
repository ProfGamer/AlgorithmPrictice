package com.datastructure.algorithmprictice.newbee.BinarySearch;

import com.datastructure.algorithmprictice.newbee.utils.Utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.datastructure.algorithmprictice.newbee.BinarySearch.BinarySearch.*;

public class Validator {
    /**
     * 对数期 -> 检查一个有序数组中 Number是否存在
     * @param maxLength
     * @param maxValue
     * @param times
     */
    public static void testBinarySearch(int maxLength, int maxValue, int times) {

        for(int i = 0; i < times; i++) {
            int[] arr = Utils.generateRandomArray(maxLength, maxValue);
            int targetNum = (int) (Math.random() * (maxValue + 1)) - (int) (Math.random() * (maxValue + 1));
            int[] arr1 = Arrays.copyOf(arr, arr.length);
            Arrays.sort(arr1);
            int[] arr2 = Arrays.copyOf(arr, arr.length);
            Arrays.sort(arr2);
            if (Arrays.stream(arr1).filter(v -> v == targetNum).findFirst().isPresent() != numberExist(arr2, targetNum)) {
                System.out.println("出错了!!!");
                break;
            }
        }
        System.out.println("测试完成!");

    }

    /**
     * 对数器 -> 确认一个有序数组中 >= num的最左位置
     * @param maxLength
     * @param maxValue
     * @param times
     */
    public static void testBinarySearchLeftPosition(int maxLength, int maxValue, int times) {
        for(int i = 0; i < times; i++) {
            int[] arr = Utils.generateRandomArray(maxLength, maxValue);
            int targetNum = (int) (Math.random() * (maxValue + 1)) - (int) (Math.random() * (maxValue + 1));
            int[] arr1 = Arrays.copyOf(arr, arr.length);
            Arrays.sort(arr1);
            int[] arr2 = Arrays.copyOf(arr, arr.length);
            Arrays.sort(arr2);
            if (forceFindMostLeft(arr1, targetNum) != findMostLeftPositionGreaterThanOrEqualsTarget(arr2, targetNum)) {
                System.out.println("出错了!!!");
                break;
            }
        }
        System.out.println("测试完成!");
    }

    /**
     * 对数器 -> 确认一个有序数组中 <= num的最右位置
     * @param maxLength
     * @param maxValue
     * @param times
     */
    public static void testBinarySearchRightPosition(int maxLength, int maxValue, int times) {
        for(int i = 0; i < times; i++) {
            int[] arr = Utils.generateRandomArray(maxLength, maxValue);
            int targetNum = (int) (Math.random() * (maxValue + 1)) - (int) (Math.random() * (maxValue + 1));
            int[] arr1 = Arrays.copyOf(arr, arr.length);
            Arrays.sort(arr1);
            int[] arr2 = Arrays.copyOf(arr, arr.length);
            Arrays.sort(arr2);
            if (forceFindMostRight(arr1, targetNum) != searchMostRightPositionNotGreaterThanTarget(arr2, targetNum)) {
                System.out.println("出错了!!!");
                break;
            }
        }
        System.out.println("测试完成!");
    }


    /**
     * 对数器 -> 确认一个有序数组中 <= num的最右位置
     * @param maxLength
     * @param maxValue
     * @param times
     */
    public static void testBinaryFindPeak(int maxLength, int maxValue, int times) {
        for(int i = 0; i < times; i++) {
            int[] arr = Utils.generateRandomArrayWithNoSameNearby(maxLength, maxValue);
            int[] arr1 = Arrays.copyOf(arr, arr.length);
            List<Integer> peaks = forceFindPeaks(arr1);

            if (!peaks.contains(findPeakElement(arr1))) {
                System.out.println("出错了!!!");
                break;
            }
        }
        System.out.println("测试完成!");
    }


    public static int forceFindMostLeft(int[] arr, int target) {
        int position = -1;
        if (arr == null || arr.length == 0 || arr[arr.length - 1] < target) {
            return position;
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= target) {
                return i;
            }
        }
        return position;
    }

    public static int forceFindMostRight(int[] arr, int target) {
        if (arr== null || arr.length == 0) {
            return -1;
        }
        int position = -1;
        for (int i = 0; i < arr.length; i++){
            if (arr[i] <= target) {
                position = i;
            } else {
                return position;
            }

        }
        return position;
    }

    public static List<Integer> forceFindPeaks(int[] arr) {
        List<Integer> peaks = new ArrayList<>();
        if (arr == null || arr.length == 0) {
            peaks.add(-1);
            return peaks;
        }
        if (arr.length == 1) {
            peaks.add(0);
            return peaks;
        }
        if (arr[0] > arr[1]) {
            peaks.add(0);
        }
        if (arr[arr.length - 1] > arr[arr.length-2]) {
            peaks.add(arr.length-1);
        }
        for (int i = 1 ; i < arr.length - 1; i++) {
            if (arr[i] > arr[i-1] && arr[i] > arr[i+1]){
                peaks.add(i);
            }
        }
        return peaks;
    }
}
