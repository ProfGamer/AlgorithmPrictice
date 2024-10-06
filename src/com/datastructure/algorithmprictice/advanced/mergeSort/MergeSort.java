package com.datastructure.algorithmprictice.advanced.mergeSort;


import java.io.*;

/**
 * 归并排序
 */
public class MergeSort {
    public static int MAXN = 100001;
    /**
     * 用于读取数组的数组
     */
    public static int[] DATA = new int[MAXN];
    /**
     * 相同长度的辅助数组
     */
    public static int[] HELP = new int[MAXN];
    public static void main(String[] args) throws IOException {
        // BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StreamTokenizer in = new StreamTokenizer(br);
        PrintWriter writer = new PrintWriter(new OutputStreamWriter(System.out));
        in.nextToken();
        int size = (int)in.nval;
        for (int i = 0; i < size; i++) {
            in.nextToken();
            DATA[i] = (int)in.nval;
        }
        //mergeSortRecursion(0, size -1);
        mergeSortIteration(0, size -1);
        for (int i = 0 ; i < size -1; i++) {
            writer.print(DATA[i] + " ");
        }
        writer.println(DATA[size - 1]);
        writer.flush();
        writer.close();
        br.close();


    }

    /**
     * 递归方法进行归并排序
     * @param l
     * @param r
     */
    public static void mergeSortRecursion(int l, int r) {
        if (l == r) {
            return;
        }
        int m = l + (r - l) / 2;
        mergeSortRecursion(l , m);
        mergeSortRecursion(m+1, r);
        merge(l , m , r);
    }

    /**
     * 迭代方法及逆行归并排序
     */
    public static void mergeSortIteration(int left, int right) {
        for (int l, r, m, step = 1; step <= right ; step <<= 1) {
            l = left;
            while(l <= right) {
                m = l + step -1;
                if (m + 1 > right) {
                    break;
                }
                r = Math.min(right, l + (step<<1) -1);
                merge(l, m, r);
                l = r+1;
            }
        }
    }

    /**
     * 已知数组在l ~ m范围上有序 在 m+1 ~ r范围上有序, 现在将两段数组合并 使其在l~r上有序, 并且保持稳定性
     * @param l
     * @param m
     * @param r
     */
    public static void merge(int l, int m, int r) {
        int helpArrIndex = l;
        int leftIndex = l;
        int rightIndex = m+1;
        while (leftIndex <= m && rightIndex <= r) {
            HELP[helpArrIndex++] = DATA[leftIndex] <= DATA[rightIndex] ? DATA[leftIndex++] : DATA[rightIndex++];
        }

        while (leftIndex <= m) {
            HELP[helpArrIndex++] = DATA[leftIndex++];
        }
        while(rightIndex <= r) {
            HELP[helpArrIndex++] = DATA[rightIndex++];
        }
        for (; l <= r ; l++) {
            DATA[l] = HELP[l];
        }
    }
}
