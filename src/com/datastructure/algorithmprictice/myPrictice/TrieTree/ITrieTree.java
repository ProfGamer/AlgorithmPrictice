package com.datastructure.algorithmprictice.myPrictice.TrieTree;

/**
 * @Author: Xin Yuchen
 * @Date: 2022/5/19 - 05 - 19 - 10:18
 * @Description: Any Ques or Concerns, plz contact e0838400@u.nus.edu
 */
// 自定义前缀树所需要实现的方法
public interface ITrieTree {
    void insert(String str); // 将 字符串加入到前缀树
    void delete(String str); // 将 这个字符串从前缀数中删除一次, 如果删除后这个字符的某些节点完全消失, 则删除这些节点
    int search(String str); // 查询某个字符串在前缀树中加入了几次
    int prefixNumber(String str); // 找到前缀数中有多少字符串以str字符串为前缀
}
