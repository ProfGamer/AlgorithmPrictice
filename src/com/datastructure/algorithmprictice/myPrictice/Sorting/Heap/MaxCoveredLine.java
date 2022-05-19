package com.datastructure.algorithmprictice.myPrictice.Sorting.Heap;

import javax.sound.sampled.Line;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Author: Xin Yuchen
 * @Date: 2022/5/16 - 05 - 16 - 17:12
 * @Description: Any Ques or Concerns, plz contact e0838400@u.nus.edu
 */
// 最大线段重合问题
// 给定很多线段,每个线段都有两个数[start,end] 分别表示线段的开始位置和结束位置,左右都是闭区间
// 规定: 1. 线段的开始和结束位置一定都是整数值 2. 线段重合区域的长度必须>=1
// 返回线段最多重合区域中包含了几条线段
public class MaxCoveredLine {
    public static void main(String[] args) {
        PriorityQueue<Integer> p = new PriorityQueue<>();

        testMaxCoveredLine(100,0,200,1000);
    }
    /**
     * 用小根堆的解法, O(N*logN)
     *
     * @param lines
     * @return
     */
    public static int maxCoveredLine(Line[] lines) {
        if (lines == null || lines.length < 1) {
            return 0;
        }
        // 首先我们要对lines根据start位置 从小到大重新排序
        Arrays.sort(lines, Comparator.comparingInt(o -> o.start));
        int res = 0;
        // 创建一个小根堆
        PriorityQueue<Integer> smallHeap = new PriorityQueue<>();
        // 之后我们遍历排好序的lines
        for (Line line : lines) {
            // 弹出堆中所有 <= line.start的值
            while (!smallHeap.isEmpty() && smallHeap.peek() <= line.start) {
                smallHeap.poll();
            }
            // 把自己的end加进堆中
            smallHeap.add(line.end);
            // 这个时候堆size就是 以 这条line start 为起点 的线段重合数
            res = Math.max(res, smallHeap.size());
        }
        return res;
    }

    /**
     * 暴力解法 O((max-min) * N)
     *
     * @param lines
     * @return
     */
    public static int forceMaxCoveredLine(Line[] lines) {
        if (lines == null || lines.length < 1) {
            return 0;
        }
        // 先找到所有线段 start的最小值和 end 的最大值
        int minStart = lines[0].start;
        int maxEnd = lines[0].end;
        for (int i = 0; i < lines.length; i++) {
            minStart = Math.min(minStart, lines[i].start);
            maxEnd = Math.max(maxEnd, lines[i].end);
        }
        // 之后我们从 start+0.5 开始, 到 end结束, 为每个数遍历一边lines 看看有几个line 覆盖了这个点, 返回最大值
        int res = 0;
        for (double p = minStart + 0.5; p < maxEnd; p++) {
            int max = 0;
            for (Line line : lines) {
                if (line.start < p && line.end > p) {
                    max++;
                }
            }
            res = Math.max(res, max);
        }
        return res;
    }

    public static Line[] convert2DArrayToLineArray(int[][] initArray) {
        int index = 0;
        Line[] lines = new Line[initArray.length];
        for (int[] line : initArray) {
            lines[index++] = new Line(line[0], line[1]);

        }
        return lines;
    }

    /**
     * 生成二维数组形式的线段数组
     *
     * @param N 数目
     * @param L start起点
     * @param R end终点
     * @return
     */
    public static int[][] generateLines(int N, int L, int R) {
        int size = (int) (Math.random() * N) + 1;
        int[][] ans = new int[size][2];
        for (int i = 0; i < size; i++) {
            int a = L + (int) (Math.random() * (R - L + 1));
            int b = L + (int) (Math.random() * (R - L + 1));
            if (a == b) {
                b = a + 1;
            }
            ans[i][0] = Math.min(a, b);
            ans[i][1] = Math.max(a, b);
        }
        return ans;
    }

    /**
     * 对数器
     * @param n 线段长度 0 ~ n
     * @param l 线段起点
     * @param r 线段重点
     * @param times 测试次数
     */
    public static void testMaxCoveredLine(int n , int l , int r, int times){
        for( int i = 0 ; i < times ; i++){
            int[][] lines = generateLines(n,l,r);
            Line[] lineArr = convert2DArrayToLineArray(lines);
            int first = forceMaxCoveredLine(lineArr);
            int second = maxCoveredLine(lineArr);
            if(first != second){
                System.out.println("出错了!");
            }
        }
        System.out.println("测试结束!");
    }
    /**
     * 静态内部类线段, 有起点start和终点end end-start >= 1
     */
    public static class Line {
        public int start;
        public int end;

        public Line(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}
