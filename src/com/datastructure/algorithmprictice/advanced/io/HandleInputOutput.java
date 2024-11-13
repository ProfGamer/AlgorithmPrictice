package com.datastructure.algorithmprictice.advanced.io;

import java.io.*;

public class HandleInputOutput {
    /**
     * 使用静态变量来复用空间
     */
    public static final int[][] MATRIX = new int[201][201];
    public static final int[] ARR = new int[201];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StreamTokenizer in = new StreamTokenizer(br);
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        while (in.nextToken() != StreamTokenizer.TT_EOF) {
            int n = (int) in.nval;
            in.nextToken();
            int m = (int) in.nval;

        }

    }

}
