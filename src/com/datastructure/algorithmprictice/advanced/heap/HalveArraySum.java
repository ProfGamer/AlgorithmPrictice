package com.datastructure.algorithmprictice.advanced.heap;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/*
 * https://leetcode.cn/problems/minimum-operations-to-halve-array-sum/description/
 */
public class HalveArraySum {
    public static void main(String[] args) {
        System.out.println(halveArray(new int[]{5,19,8,1}));
    }

    public static int minOperationToHalveArraySum(int[] arr) {
        // 大根堆
        PriorityQueue<Double> heap = new PriorityQueue<>(Comparator.reverseOrder());
        double sum = 0;
        for (int i : arr) {
            heap.add(i * 1.0);
            sum += i;
        }
        // 至少需要减少的数值
        sum /= 2;
        int step = 0;
        for(double minus = 0, cur; minus < sum; step++, minus += cur) {
            cur = heap.poll() / 2;
            heap.add(cur);
        }


        return step;
    }
    public static long[] heap = new long[100001];
    public static int size;
    public static int halveArray(int[] arr) {
        // 通过自建堆以及手动将int转为long类型来控制精度缓冲区
        // 从底至顶构建大根堆
        size = arr.length;
        long sum = 0L;
        for (int i = size - 1; i >= 0; i--) {
            // 选择将int类型左移20位, 可以保证不会溢出long类型限制
            heap[i] = (long) arr[i] << 20;
            sum += heap[i];
            heapify(i);
        }
        long target = sum >> 1;
        int step = 0;
        while (sum > target) {
            heap[0] = heap[0] >> 1;
            sum -= heap[0];
            heapify(0);
            step++;
        }
        return step;
    }


    /*
     * 将arr中i位置的数向下调整为大根堆
     */
    public static void heapify(int position) {
        int left = 2 * position + 1;
        // 如果左孩子越界, 说明没有孩子 结束方法
        // 如果左孩子没有越界, 说明有左孩子, 可能有右孩子
        while (left < size) {
            int largest = left + 1 < size && heap[left + 1] > heap[left] ? left + 1 : left;
            largest = heap[largest] > heap[position] ? largest : position;
            if (largest == position) {
                break;
            }
            swap(heap, position, largest);
            position = largest;
            left = 2 * position + 1;
        }
    }

    public static void swap(long[] heap, int i, int j) {
        long temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }
}
