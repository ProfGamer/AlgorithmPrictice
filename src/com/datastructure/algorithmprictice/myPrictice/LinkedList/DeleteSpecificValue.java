package com.datastructure.algorithmprictice.myPrictice.LinkedList;

import java.util.ArrayList;

/**
 * @Author: Xin Yuchen
 * @Date: 2022/5/5 - 05 - 05 - 15:09
 * @Description: Any Ques or Concerns, plz contact e0838400@u.nus.edu
 */
// 在一个单链表中删除所有的给定值
public class DeleteSpecificValue {
    public static void main(String[] args) {
        testForDeleteSpecificValue(10,20,10000);
    }
    // 采用有限几个变量的做法
    public static Node deleteSpecificValue(Node head, int value){
        // 如果要删除的值是头结点的值->一致删到第一个值不一样的节点
        while(head != null){
            if(head.value != value){
                break;
            }
            head = head.next;
        }

        // 这里我们考虑删除中间节点的情况
        Node pre = head;
        Node cur = head;
        while(cur != null){
            if(cur.value == value){
                Node next = cur.next;
                pre.next = next;
            }else{
                pre = cur;
            }
            cur = cur.next;
        }
        return head;
    }
    //这里我们使用容器法暴力求解
    public static Node forceDelete(Node head, int value){
        ArrayList<Node> list = new ArrayList<>();
        // 这里我们直接将删除后剩下的节点加入list就好
        while(head!=null){
            if(head.value!=value){
                list.add(head);
            }
            head = head.next;
        }
        Node newHead = null;
        if(list.size()>0){
            newHead = list.get(0);
            newHead.next = null;
        }
        Node pre = newHead;
        // 遍历一遍容器,链接出新的链表
        for(int i = 1; i < list.size(); i++){
            Node cur = list.get(i);
            cur.next = null;
            pre.next = cur;
            pre = cur;
        }
        return newHead;
    }
    public static void testForDeleteSpecificValue(int len, int max, int times){
        for(int i = 0 ; i < times ; i++){
            Node head = CreateLinkedList.createRandomLinkedList(len,max);
            int value = (int) (Math.random()* max + 1);
            Node forceHead = forceDelete(head,value);
            Node targetHead = deleteSpecificValue(head,value);
            while(forceHead!=null && targetHead!=null){
                if(forceHead.value != targetHead.value){
                    System.out.println("Value not match");
                }
                forceHead = forceHead.next;
                targetHead = targetHead.next;
            }
            if(forceHead!=null || targetHead!=null){
                System.out.println("Length not match");
            }
        }
        System.out.println("Pass!!!");
    }
}
