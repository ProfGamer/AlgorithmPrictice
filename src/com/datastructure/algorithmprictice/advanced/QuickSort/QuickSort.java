package com.datastructure.algorithmprictice.advanced.QuickSort;

public class QuickSort {
    public static int[] DATA;
    public static int LEFT;
    public static int RIGHT;
    public int[] sortArray(int[] nums) {
        if (nums == null || nums.length == 1) return nums;
        DATA = nums;
        quickSortBlock(0, nums.length - 1);
        return DATA;
    }

    public static void quickSortSingle(int l, int r) {
    // 经典随机快速排序, 我们需要在 l - r上随机一个target值, 将小于target的都放在target左侧 大于target的都放在target右侧, 返回target的索引返回
        if(l >= r) return;
        int target = DATA[l + (int)(Math.random() * ( r - l + 1))];

        int index = partitionSingle(l, r, target);
        quickSortSingle(l, index-1);
        quickSortSingle(index+1, r);
    }

    /**
     *
     * @param l
     * @param r
     */
    public static void quickSortBlock(int l, int r) {
        if (l >= r) return;
        int target = DATA[l + (int)(Math.random() * ( r - l + 1))];
        System.out.println(target);
        partitionBlock(l, r, target);
        int less = LEFT;
        int great = RIGHT;
        quickSortBlock(l, less - 1);
        quickSortBlock(great + 1, r);
    }

    private static void partitionBlock(int l, int r, int target) {
        LEFT = l;
        RIGHT = r;
        int i = l;
        while (i<= RIGHT){
            // 如果小于则放入小于区
            // 等于则只i移动
            // 大于则放入大于区 但i不移动
            if (DATA[i] < target) {
                swap(DATA, i++, LEFT++);
            } else if (DATA[i] == target) {
                i++;
            } else {
                swap(DATA, i, RIGHT--);
            }

        }
    }

    private static int partitionSingle(int l, int r, int target) {
        // 建立一个小于区变量less, 开始时位于l处, 从l开始遍历l~r, 如果小于等于target就交换i和less, 然后less++ i++ 如果大于target则仅i++
        int index = l;
        int less = l;
        for (int i = l ; i <=r ; i++) {
            if (DATA[i] <= target) {
                swap(DATA, i, less++);
                if (DATA[less - 1] == target) {
                    index = less - 1;
                }
            }
        }
        swap(DATA, less-1, index);
        return less -1;
    }

    public static void swap(int[] data, int i, int j) {
        int temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }
}
