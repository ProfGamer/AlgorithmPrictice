package com.datastructure.algorithmprictice.advanced.mergeSort;

import java.io.*;

/**
 * 使用归并分治思想实现小和问题
 */
public class SmallSum {
    public static int MAXN = 100001;
    public static int[] DATA = new int[MAXN];
    public static int[] HELP = new int[MAXN];
    public static int SIZE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StreamTokenizer in = new StreamTokenizer(br);
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        while (in.nextToken() != StreamTokenizer.TT_EOF) {
            SIZE = (int)in.nval;
            for(int i = 0 ; i < SIZE ; i++) {
                in.nextToken();
                DATA[i] = (int)in.nval;
            }
        }
        long sum = smallSum(0, SIZE -1);
        out.println(sum);
        out.flush();
        br.close();
        out.close();
    }

    /**
     * 计算l ~ r范围上的小和
     */
    public static long smallSum(int l, int r) {
        if (l == r) return 0;
        int m = l + (r - l) /2;
        return smallSum(l, m) + smallSum(m+1, r) + merge(l, m ,r);
    }

    /**
     * l ~ m 和 m+1 ~ r上的小和已经各自算完, 现在要计算左跨右所产生的小和, 计算完之后需要保证l ~ r整体有序, 以方便下一次运算
     */
    public static long merge(int l, int m, int r) {
        // 计算左跨右的小和
        long result = 0;
        for (int i = l, j = m+1, sum = 0; j <= r ; j++) {
            while (i <= m && DATA[i] <= DATA[j]) {
                sum += DATA[i];
                i++;
            }
            result += sum;
        }
        // 归并排序保证左右各自有序
        int helpIndex = l;
        int leftIndex = l;
        int rightIndex = m+1;
        while (leftIndex <= m && rightIndex <= r) {
            HELP[helpIndex++] = DATA[leftIndex] <= DATA[rightIndex] ? DATA[leftIndex++] : DATA[rightIndex++];
        }
        while (leftIndex <= m) {
            HELP[helpIndex++] = DATA[leftIndex++];
        }
        while (rightIndex <= r) {
            HELP[helpIndex++] = DATA[rightIndex++];
        }
        for(; l<=r; l++) {
            DATA[l] = HELP[l];
        }
        return result;
    }
}
