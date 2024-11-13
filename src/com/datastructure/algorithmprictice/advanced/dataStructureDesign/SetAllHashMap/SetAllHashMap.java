package com.datastructure.algorithmprictice.advanced.dataStructureDesign.SetAllHashMap;

import java.util.HashMap;

/**
 * 实现一个可以一次性设置所有键值对的value为某个值的setAll方法的HashMap, 并且要求get put setAll方法的时间复杂度都是O(1)
 * 通过引入一个加入时间count变量来管理该返回原始value还是setAllValue,
 * 每次的put和setAll都会更新这个变量 在get返回前, 需要比较该值加入时的count和setALlValueCount, 如果setAll靠后, 则需要返回setAllValue
 */
public class SetAllHashMap {
    private static class ValuePair {
        public int value;
        public int valueCount;
        public ValuePair(int value, int valueCount) {
            this.value = value;
            this.valueCount = valueCount;
        }
    }

    private int count;

    private HashMap<Integer, ValuePair> map;

    private int setAllValue;

    private int setAllCount;

    public SetAllHashMap() {
        this.count = 0;
        this.map = new HashMap<>();
        this.setAllValue = 0;
        this.setAllCount = -1;
    }

    public void put(int key, int value) {
        map.put(key, new ValuePair(value, this.count++));
    }

    public int get(int key) {
        if (!map.containsKey(key)) return -1;

        ValuePair valuePair = map.get(key);

        return valuePair.valueCount < setAllCount ? setAllValue : valuePair.value;

    }

    public void setAll(int value) {
        this.setAllValue = value;
        this.setAllCount = count++;
    }

}
