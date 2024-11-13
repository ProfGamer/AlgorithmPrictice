package com.datastructure.algorithmprictice.advanced.dataStructureDesign.randomizedCollection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/**
 * RandomizedCollection 是一种包含数字集合(可能是重复的)的数据结构。它应该支持插入和删除特定元素，以及删除随机元素。
 * https://leetcode.cn/problems/insert-delete-getrandom-o1-duplicates-allowed/description/
 */
public class RandomizedCollection {
    // 使用一个Map<Integer, ArrayList<Integer> > 来存放数字和他的所有索引集合
    // 使用一个ArrayList来存放所有数字
    private HashMap<Integer, HashSet<Integer>> numberIndexs;
    private ArrayList<Integer> nums;

    public RandomizedCollection() {
        this.numberIndexs = new HashMap<>();
        this.nums = new ArrayList<>();
    }

    /**
     * bool insert(int val) 将一个 val 项插入到集合中，即使该项已经存在。如果该项不存在，则返回 true ，否则返回 false
     * @param val
     * @return
     */
    public boolean insert(int val) {
        // 检查该项是否在Map中存在
        // 如果存在, 则在nums中加入该元素, 并且在Map对应的value List中add该元素的索引位置
        // 如果不存在, 则在nums中加入该元素, 并且在Map中Put对应的键值对, 记录该元素与该索引位置
        nums.add(val);
        HashSet<Integer> valueSet = numberIndexs.getOrDefault(val, new HashSet<>());
        valueSet.add(nums.size() - 1);
        if (numberIndexs.containsKey(val)) {
            return false;
        } else {
            numberIndexs.put(val, valueSet);
            return true;
        }

    }

    /**
     * bool remove(int val) 如果存在，从集合中移除一个 val 项。如果该项存在，则返回 true ，否则返回 false 。注意，如果 val 在集合中出现多次，我们只删除其中一个
     * @param val
     * @return
     */
    public boolean remove(int val) {
        if (!numberIndexs.containsKey(val)) return false;
        // 如果该项存在, 并且该项等于数组nums中的最后一个元素, 则可以直接移除该元素并且更新他的value list, 不需要补空和交换
        HashSet<Integer> targetNumIndexSet = numberIndexs.get(val);
        Integer lastNumber = nums.get(nums.size() - 1);

        if (val == lastNumber) {
            if (targetNumIndexSet.size() == 1) {
                numberIndexs.remove(val);
            } else {
                targetNumIndexSet.remove(nums.size() - 1);
            }
            nums.remove(nums.size() - 1);
            return true;
        }

        // 如果该项存在, 我们需要先从value list中找到第一个索引位置
        Integer targetIndex = targetNumIndexSet.iterator().next();

        // 然后将该索引位置设置为nums中最后一个数
        nums.set(targetIndex, lastNumber);
        // 从value list中移除该索引位置, 如果list空了, 则移除键值对
        if (targetNumIndexSet.size() == 1) {
            numberIndexs.remove(val);
        } else {
            targetNumIndexSet.remove(targetIndex);
        }
        // 在最后一个数的value list中将最后一个索引位置修改为我们设置的索引位置
        HashSet<Integer> lastNumberIndexSet = numberIndexs.get(lastNumber);
        lastNumberIndexSet.remove(nums.size() - 1);
        lastNumberIndexSet.add(targetIndex);
        // 从nums中移除最后一位
        nums.remove(nums.size() - 1);
        return true;
    }

    public int getRandom() {
        return nums.get((int) (Math.random() * nums.size()));
    }
}
