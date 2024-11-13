package com.datastructure.algorithmprictice.advanced.dataStructureDesign.MedianFinder;

import java.util.PriorityQueue;

/**
 * https://leetcode.cn/problems/find-median-from-data-stream/description/
 * 中位数是有序整数列表中的中间值。如果列表的大小是偶数，则没有中间值，中位数是两个中间值的平均值
 */
public class MedianFinder {
    // 使用一个大根堆 + 一个小根堆 来实现该数据结构, 目标是 将所有数中较大的一部分放进小根堆, 将所有数中较小的一部分放进大根堆
    // 这样在总数为奇数的时候, 我们可以直接返回size较大的堆的堆顶元素 即为中位数
    // 在总数为偶数的时候, 我们将两个堆堆顶元素取平均值来获得中位数
    public static PriorityQueue<Integer> heap1, heap2;
    public MedianFinder() {
        heap1 = new PriorityQueue<>((a,b) -> a - b); // 小根堆 存放较大的数 最小的在堆顶
        heap2 = new PriorityQueue<>((a, b) -> b - a); // 大根堆, 存放较小的数 最大的在堆顶
    }

    /**
     * void addNum(int num) 将数据流中的整数 num 添加到数据结构中。
     * 在添加的时候, 如果大根堆没有数, 则直接进大根堆
     * 如果此时添加的数小于大根堆的堆顶, 则先添加至大根堆 并尝试执行balance方法
     * 如果此时添加的数大于大根堆的堆顶, 则先添加至小根堆, 并尝试执行balance方法
     * @param num
     */
    public void addNum(int num) {
        if (heap2.isEmpty()) {
            heap2.add(num);
            return;
        }
        Integer checkNum = heap2.peek();
        if (num <= checkNum) {
            heap2.add(num);
        } else {
            heap1.add(num);
        }
        balance();
    }

    /**
     * double findMedian() 返回到目前为止所有元素的中位数。与实际答案相差 10-5 以内的答案将被接受。
     * 如果总数是双数, 那么就返回两个堆堆顶元素的平均值
     * 如果总数是单数, 那么就返回数目较多的那个堆的堆顶元素
     * @return
     */
    public double findMedian() {
        int total = heap1.size() + heap2.size();
        if (total % 2 == 1) {
            return heap1.size() > heap2.size() ? heap1.peek() : heap2.peek();
        }
        return (heap1.peek() + heap2.peek()) * 1.0 / 2;
    }

    /**
     * 平衡两个堆中的元素, 使两个堆size的差值 < 2
     */
    private void balance() {
        int diff = Math.abs(heap1.size() - heap2.size());
        if (diff < 2) return;
        if (heap1.size() > heap2.size()) {
            heap2.add(heap1.poll());
        } else {
            heap1.add(heap2.poll());
        }
    }
}
