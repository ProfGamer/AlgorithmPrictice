package com.datastructure.algorithmprictice.newbee;

public class BinarySystem {
    public static void main(String[] args) {
        System.out.println("使用二进制形式直接定义int");
        int a = 78;
        int b = 0b01001110;
        System.out.println(a == b);
        System.out.println("使用16进制定义int");
        int c = 0x4e;
        System.out.println(a == c);
        printBinaryInt(a);
        System.out.println();
        printBinaryLong(78L);
        System.out.println();
        binaryMoveLeft(a, 2);
        System.out.println();
        binaryMoveRight(a, 2);
    }
    public static void binaryMoveLeft(int num, int step) {
        System.out.println("原数二进制形式为: ");
        printBinaryInt(num);
        System.out.println();
        System.out.println("左移" + step + "位后为: ");
        printBinaryInt(num << step);
    }

    public static void binaryMoveRight(int num, int step) {
        System.out.println("原数二进制形式为: ");
        printBinaryInt(num);
        System.out.println();
        System.out.println("右移" + step + "位后为: ");
        // 不带符号位右移
        printBinaryInt(num >> step);
    }
    /**
     * 打印一个32位int的二进制形式
     * @param num 32位int
     */
    public static void printBinaryInt(int num) {
        // 我们从左至右 从高位到低位进行循环打印
        for(int i = 31; i >=0 ; i--) {
            // 如何确定一个int在对应i位上 为 1 还是 0?
            // 将这个数 & 1 << i 如果i为为0 则结果为 0, 如果i位为1 则结果不为0
            // & 运算与 每个位上都1才1 有0则0
            System.out.print(( num & (1 << i) ) == 0 ? "0" : "1");
        }
    }
    /**
     * 打印一个64位long的二进制形式, 需要注意方法中用作确认的 1 需要使用 1L
     * @param num 64位long
     */
    public static void printBinaryLong(long num) {
        // 我们从左至右 从高位到低位进行循环打印
        for(int i = 63; i >=0 ; i--) {
            // 如何确定一个long在对应i位上 为 1 还是 0?
            // 将这个数 & 1L << i 如果i为为0 则结果为 0, 如果i位为1 则结果不为0
            // & 运算与 每个位上都1才1 有0则0
            System.out.print(( num & (1L << i) ) == 0 ? "0" : "1");
        }
    }
}
