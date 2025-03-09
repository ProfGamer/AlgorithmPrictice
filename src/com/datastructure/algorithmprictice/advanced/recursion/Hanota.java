package com.datastructure.algorithmprictice.advanced.recursion;

/**
 * 递归打印汉诺塔最优移动路径
 */
public class Hanota {
    /**
     * 将n层汉诺塔由From 移动到To, 经过Other
     * @param n n层盘子
     * @param from 起始位置
     * @param to 目标位置
     * @param other 经由位置
     */
    public static void hanota(int n, String from, String to, String other) {
        if( n == 1) {
            System.out.println("Move 1 from " + from + " to " + to);
            return;
        }
        hanota(n - 1, from, other, to);
        System.out.println("Move " + n + " from " + from + " to " + to);
        hanota(n - 1, other, to, from);
    }

    public static void main(String[] args) {
        hanota(3, "左", "中", "右");
    }
}
