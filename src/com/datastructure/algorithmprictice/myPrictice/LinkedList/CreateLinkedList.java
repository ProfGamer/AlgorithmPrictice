package com.datastructure.algorithmprictice.myPrictice.LinkedList;

/**
 * @Author: Xin Yuchen
 * @Date: 2022/5/5 - 05 - 05 - 15:22
 * @Description: Any Ques or Concerns, plz contact e0838400@u.nus.edu
 */
public class CreateLinkedList {
    public static Node createRandomLinkedList(int len, int maxValue){
        len = (int)(Math.random()*len + 1);

        //创建头结点
        Node head = new Node((int)(Math.random()*maxValue+1));
        Node pre = head;
        len--;
        while(len>0){
            Node cur = new Node((int)(Math.random()*maxValue+1));
            pre.next = cur;
            pre = cur;
            len--;
        }
        return head;
    }
}
