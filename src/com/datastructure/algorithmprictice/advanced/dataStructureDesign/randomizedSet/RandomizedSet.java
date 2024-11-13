package com.datastructure.algorithmprictice.advanced.dataStructureDesign.randomizedSet;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * O(1)时间插入删除和获取随机元素的数据结构
 * 实现RandomizedSet 类：
 *
 * RandomizedSet() 初始化 RandomizedSet 对象
 * bool insert(int val) 当元素 val 不存在时，向集合中插入该项，并返回 true ；否则，返回 false 。
 * bool remove(int val) 当元素 val 存在时，从集合中移除该项，并返回 true ；否则，返回 false 。
 * int getRandom() 随机返回现有集合中的一项（测试用例保证调用此方法时集合中至少存在一个元素）。每个元素应该有 相同的概率 被返回。
 * 你必须实现类的所有函数，并满足每个函数的 平均 时间复杂度为 O(1) 。
 * https://leetcode.cn/problems/insert-delete-getrandom-o1/
 */
public class RandomizedSet {
    public HashMap<Integer, Integer> eleToIndexMap;
    public ArrayList<Integer> data;
    public RandomizedSet() {
        this.eleToIndexMap = new HashMap<>();
        this.data = new ArrayList<>();
    }

    public boolean insert(int val) {
        if(eleToIndexMap.containsKey(val)) return false;
        data.add(val);
        eleToIndexMap.put(val, data.size() - 1);
        return true;
    }

    public boolean remove(int val) {
        if (!eleToIndexMap.containsKey(val)) {
            return false;
        }

        Integer removeEleIndex = eleToIndexMap.get(val);
        Integer ele = data.get(data.size() - 1);
        eleToIndexMap.put(ele, removeEleIndex);
        data.set(removeEleIndex, ele);
        // 因为val和removeEleIndex有关, 所以需要在所有更新后再删除它
        eleToIndexMap.remove(val);
        data.remove(data.size() - 1);
        return true;


    }

    /**
     * 等概率返回随机元素
     * @return
     */
    public int getRandom() {
        return data.get( (int) (Math.random() * data.size()));
    }
}
