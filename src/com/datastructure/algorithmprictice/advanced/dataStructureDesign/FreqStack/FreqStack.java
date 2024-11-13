package com.datastructure.algorithmprictice.advanced.dataStructureDesign.FreqStack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/**
 * 设计一个类似堆栈的数据结构，将元素推入堆栈，并从堆栈中弹出出现频率最高的元素。
 * https://leetcode.cn/problems/maximum-frequency-stack/description/
 * 由两个map 和 一个maxFreq变量实现这个结构
 * NumFreqMap记录已进入栈中的数字和对应的词频
 * FreqNumsMap 记录每个词频对饮有哪些数字 1, [] 2, [] 3, []
 * MaxFreq记录当前栈中最大词频
 */
public class FreqStack {
    public HashMap<Integer, Integer> numFreqMap;
    public HashMap<Integer, ArrayList<Integer>> freqNumsMap;
    public int maxFreq = 0;
    public FreqStack() {
        numFreqMap = new HashMap<>();
        freqNumsMap = new HashMap<>();
    }

    /**
     * void push(int val) 将一个整数 val 压入栈顶
     * @param val
     */
    public void push(int val) {
        // 尝试从NumFreqMap中获取这个数的词频, 如果存在则词频 + 1, 如果不存在则将词频设置为 1
        numFreqMap.put(val, numFreqMap.getOrDefault(val, 0) + 1);
        int curFreq = numFreqMap.get(val);
        // 如果存在, 尝试从FreqNumsMap中获取现在词频的value list, 如果不存在则创建, 如果存在则add val
        ArrayList<Integer> curFreqValues = freqNumsMap.getOrDefault(curFreq, new ArrayList<>());
        curFreqValues.add(val);
        freqNumsMap.put(curFreq, curFreqValues);
        // 比较现在词频和maxFreq 更新为最大值
        maxFreq = Math.max(curFreq, maxFreq);
    }

    /**
     * int pop() 删除并返回堆栈中出现频率最高的元素。
     * 如果出现频率最高的元素不只一个，则移除并返回最接近栈顶的元素
     * @return
     */
    public int pop() {
        // 根据maxFreq从freqNumsMap中找到对应词频 value list
        ArrayList<Integer> valueList = freqNumsMap.get(maxFreq);
        // 从该value list中移除最后一个元素 -> 返回值
        Integer result = valueList.remove(valueList.size() - 1);
        // 检查此时该value list是否为空, 如果已经空了
        if (valueList.isEmpty()) {

            // 从freqNumsMap中移除该键值对
            // maxFreq--
            freqNumsMap.remove(maxFreq--);
        }
        // 在numFreqMap更新该返回值的value, 如果为0则移除
        if (numFreqMap.get(result) == 1) {
            numFreqMap.remove(result);
        } else {
            // 如果不为0 则 --
            numFreqMap.put(result, numFreqMap.get(result) - 1);
        }

        return result;
    }
}
