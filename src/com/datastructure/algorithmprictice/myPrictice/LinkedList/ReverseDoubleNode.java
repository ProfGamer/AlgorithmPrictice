package com.datastructure.algorithmprictice.myPrictice.LinkedList;


import java.util.ArrayList;

/**
 * @Author: Xin Yuchen
 * @Date: 2022/5/5 - 05 - 05 - 13:53
 * @Description: Any Ques or Concerns, plz contact e0838400@u.nus.edu
 */
public class ReverseDoubleNode {
    //双向链表类
    private static class MyDoubleNode {
        public int value;
        public MyDoubleNode pre;
        public MyDoubleNode next;

        public MyDoubleNode(int data) {
            value = data;
        }
    }

    public static void main(String[] args) {
        testForReverseDoubleNodeLinkedList(5,10,100);


    }
    public static MyDoubleNode reverseDoubleNodeLinkedList(MyDoubleNode head){
        MyDoubleNode pre = null;
        MyDoubleNode next = null;
        while(head!=null){
            next = head.next;
            head.pre = next;
            head.next = pre;
            pre = head;
            head = head.pre;
        }
        return pre;
    }
    public static MyDoubleNode reverseDoubleNodeLinkedListWithArrayList(MyDoubleNode head){
        // 首先我们用一个ArrayList记录初始链表的顺序位置
        ArrayList<MyDoubleNode> nodeList = new ArrayList<>();
        while(head!=null){
            nodeList.add(head);
            head = head.next;
        }
        // 我们这里可以直接将节点next设置为null了 因为next顺序已经在list中记好了
        nodeList.get(0).next = null;
        MyDoubleNode pre = nodeList.get(0);
        int size = nodeList.size();
        for(int i = 1 ; i < size ; i++){
            MyDoubleNode cur = nodeList.get(i);
            cur.pre = cur.next;
            cur.next = pre;
            pre = cur;

        }
        return nodeList.get(size-1);
    }

    // for test 如何生成一个随机的双向链表
    public static MyDoubleNode generateRandomDoubleList(int len, int value) {
        // 随机出链表长度
        int size = (int) (Math.random() * (len + 1));
        while(size==0){
            size = (int) (Math.random() * (len + 1));
        }
        // 随机头
        size--;
        MyDoubleNode head = new MyDoubleNode((int) (Math.random() * (value + 1)));
        MyDoubleNode pre = head;
        // 随机之后的节点
        while (size != 0) {
            MyDoubleNode cur = new MyDoubleNode((int) (Math.random() * (value + 1)));
            pre.next = cur;
            cur.pre = pre;
            pre = cur;
            size--;
        }
        // 返回头
        return head;
    }
    public static void testForReverseDoubleNodeLinkedList(int len, int value, int times){
        while(times>0){
            MyDoubleNode head = generateRandomDoubleList(len,value);
            MyDoubleNode tail = head;
            while(tail.next !=null){
                tail = tail.next; // 这个tail的值应该和我们的新头一致, pre next 关系相反

            }
            MyDoubleNode newHead = head;
            //newHead = reverseDoubleNodeLinkedList(newHead);// 获取了翻转后的新头
            newHead = reverseDoubleNodeLinkedListWithArrayList(newHead);
            while(tail!=null && newHead!=null){
                if(tail.value != newHead.value){
                    System.out.println("Value not match");
                }
                tail = tail.pre;
                newHead = newHead.next;
            }
            times--;
        }
        System.out.println("Pass!!!");
    }
}
