package com.datastructure.algorithmprictice.newbee.LinkedList;

/**
 * 合并两个升序单链表
 * 原题连接 <a href="https://leetcode.cn/problems/merge-two-sorted-lists/">力扣链接</a>
 */
public class MergeTwoSortedLinkedList {
    public static Node.SingleNode mergeTwoLinkedList(Node.SingleNode head1, Node.SingleNode head2) {
        if (head1 == null || head2 == null) {
            return head1 == null ? head2 : head1;
        }
        Node.SingleNode head = head1.value <= head2.value ? head1 : head2;
        Node.SingleNode pointer1 = head.next;
        Node.SingleNode pointer2 = head == head1 ? head2 : head1;
        Node.SingleNode sortedPointer = head;
        while (pointer1 != null && pointer2 != null) {
            if (pointer1.value <= pointer2.value) {
                sortedPointer.next = pointer1;
                pointer1 = pointer1.next;
            } else {
                sortedPointer.next = pointer2;
                pointer2 = pointer2.next;
            }
            sortedPointer = sortedPointer.next;
        }
        sortedPointer.next = pointer1 == null ? pointer2 : pointer1;
        return head;
    }
}
