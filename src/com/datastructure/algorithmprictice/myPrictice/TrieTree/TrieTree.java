package com.datastructure.algorithmprictice.myPrictice.TrieTree;

import java.awt.dnd.DropTargetListener;

/**
 * @Author: Xin Yuchen
 * @Date: 2022/5/19 - 05 - 19 - 10:11
 * @Description: Any Ques or Concerns, plz contact e0838400@u.nus.edu
 */
// 自己实现一个前缀树
public class TrieTree implements ITrieTree {
    // 字符路径我们不存在节点中, 而是通过ASCII码的方式存在路径中
    public static class Node { // 前缀树中所需要的节点
        public int pass; // 来到了这个节点几次
        public int end; // 多少字符串以这个节点结尾
        public Node[] next;

        public Node() {
            pass = 0;
            end = 0;
            // 代表小写字母a~z 通过 char c - 'a' 获取对应字母字符的路径
            next = new Node[26];
        }
    }

    private Node root;

    public TrieTree() {
        root = new Node();
    }

    @Override
    public void insert(String str) {
        if (str == null) {
            return;
        }
        Node cur = root;
        root.pass++;
        char[] chars = str.toCharArray();
        int path = 0;
        for (char c : chars) {
            path = c - 'a';
            if (cur.next[path] == null) { // 这个节点还没有被创建, 新建节点
                cur.next[path] = new Node();
            }
            cur = cur.next[path];
            cur.pass++;
        }
        cur.end++;
    }

    @Override
    public void delete(String str) {
        if (search(str) == 0) {  // 如果树中没有这个字符串, 那就直接return
            return;
        }
        Node cur = root;
        cur.pass--;
        char[] chars = str.toCharArray();
        int path = 0;
        for (char c : chars) {
            path = c - 'a';
            if(--cur.next[path].pass == 0){ // 如果他下一个节点的pass-1之后为0, 那么直接删除cur.next[path]节点
                cur.next[path] = null;
                return;
            }
            cur = cur.next[path];
        }
        cur.end--;
    }

    @Override
    public int search(String str) {
        if (str == null) {
            return 0;
        }
        Node cur = root;
        char[] chars = str.toCharArray();
        int path = 0;
        for (char c : chars) {
            path = c - 'a';
            if (cur.next[path] == null) {
                return 0;
            }
            cur = cur.next[path];
        }
        return cur.end;
    }

    @Override
    public int prefixNumber(String str) {
        if (str == null) {
            return 0;
        }
        Node cur = root;
        char[] chars = str.toCharArray();
        int path = 0;
        for (char c : chars) {
            path = c - 'a';
            if (cur.next[path] == null) {
                return 0;
            }
            cur = cur.next[path];
        }
        return cur.pass;
    }


}
