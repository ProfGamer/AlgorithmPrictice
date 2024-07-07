package com.datastructure.algorithmprictice.newbee;

import java.util.Arrays;

public class SocialExperiment {
    public static void main(String[] args) {
        System.out.println("下面我们将进行一组社会实验: ");
        System.out.println("一开始有100个人, 每个人都有100元, 在每一轮都做如下的事情: ");
        System.out.println("每个人都必须拿出1元钱给除自己之外的其他人, 给谁完全随机");
        System.out.println("如果某个人在这一轮的钱数为0, 那么他可以不给, 但是仍然可以接收");
        System.out.println("发生很多很多轮之后, 这100人的财富分布会很均匀吗? 要求使用基尼系数体现");
        int peopleAmount = 100;
        int round = 1000000;
        System.out.println("人数: " + peopleAmount);
        System.out.println("轮数: " + round);
        experiment(peopleAmount, round);
        System.out.println("试验结束!");
    }

    public static void experiment(int peopleAmount, int round) {
        // 根据人数新建一个数组, 每个人初始分配相同的财富
        double[] wealth = new double[peopleAmount];
        Arrays.fill(wealth, 100);
        // 新建一个数组检查每个人是否还能给钱, 没钱则不能给钱只能收钱
        boolean[] hasMoney = new boolean[peopleAmount];
        // 开启实验
        for (int i = 0; i < round; i++) {
            Arrays.fill(hasMoney, false);
            // 监测每个人钱的状态
            for (int j = 0; j < peopleAmount; j++) {
                hasMoney[j] = wealth[j] > 0;
            }
            // 开始转钱
            for (int n = 0; n < peopleAmount; n++) {
                // 如果他有钱的话
                if (hasMoney[n]) {
                    // 确认他要给谁
                    int toIndex = n;
                    do {
                        toIndex = (int) (Math.random() * peopleAmount);
                    } while (toIndex == n); // 最后得出一个非当前的索引
                    wealth[n]--;
                    wealth[toIndex]++;
                }
            }
        }
        Arrays.sort(wealth);
        System.out.println("列出每个人的财富(贫穷到富有): ");
        for (int x = 0 ; x < peopleAmount; x++) {
            System.out.print((int)wealth[x] + " ");
            if (x % 10 == 9 ){
                System.out.println();
            }
        }
        System.out.println("最终基尼系数为: " + calculateGini(wealth));

    }

    /**
     * 基尼系数计算方法
     * 每个人财富相差的绝对值的总和 / 2 * 人数 * 财富总值
     * 基尼系数含义: 越低代表社会财富分配越平均, 0 代表所有人财富一致, 1代表一个人掌握了社会中所有的财富
     */
    public static double calculateGini(double[] wealth) {
        double wealthTotal = 0;
        double gapTotal = 0;
        int peopleAmount = wealth.length;
        for (double v : wealth) {
            wealthTotal += v;
            for (double value : wealth) {
                gapTotal += Math.abs(v - value);
            }
        }

        return gapTotal / (2 * peopleAmount * wealthTotal);
    }
}
