package com.datastructure.algorithmprictice.newbee.LinkedList;

/**
 * 分隔链表 给定一个链表的头节点, 和一个目标值
 * 返回一个链表的头节点, 其中所有小于目标值的节点都在链表的开头, 大于等于该值的节点都在链表的末尾, 并且节点之间的相对顺序不会改变
 * 5 1 6 3 9 5 1  targetNum = 4
 * 1 3 1 5 6 9 5
 * 题目链接 <a href="https://leetcode.cn/problems/partition-list/submissions/546928960/">力扣链接</a>
 */
public class PartitionLinkedList {
    public static Node.SingleNode partitionLinkedList(Node.SingleNode h, int num) {
        if (h == null || h.next == null) {
            return h;
        }
        Node.SingleNode leftHead = null, leftTail = null;
        Node.SingleNode rightHead = null, rightTail = null;
        Node.SingleNode next = null;
        while (h != null) {
            next = h.next;
            h.next = null;
            if (h.value < num) {
                if (leftHead == null) {
                    leftHead = h;
                } else {
                    leftTail.next = h;
                }
                leftTail = h;
            } else {
                if (rightHead == null) {
                    rightHead = h;
                } else {
                    rightTail.next = h;
                }
                rightTail = h;
            }
            h = next;
        }
        if (leftHead == null) {
            return rightHead;
        }
        leftTail.next = rightHead;
        return leftHead;

    }
}
