package com.datastructure.algorithmprictice.newbee.LinkedList;

public class ReverseLinkedList {
    public static Node.SingleNode reverseSingleNodeList(Node.SingleNode head){
        if (head == null || head.next == null) {
            return head;
        }
        Node.SingleNode next = null;
        Node.SingleNode pre = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    public static Node.DoubleNode reverseDoubleNodeList(Node.DoubleNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node.DoubleNode pre = null;
        Node.DoubleNode next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            head.last = next;
            pre = head;
            head = next;
        }
        return pre;
    }
}
