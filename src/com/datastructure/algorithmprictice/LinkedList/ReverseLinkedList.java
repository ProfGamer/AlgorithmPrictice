package com.datastructure.algorithmprictice.LinkedList;


/**
 * 单链表反转
 * https://leetcode.cn/problems/reverse-linked-list/description/
 */
public class ReverseLinkedList {
    /**
     * 需要返回一个新的头部
     * @param head
     * @return
     */
    public ListNode reverseLinkedList(ListNode head) {
        // 如果head为null 或者 链表的长度为1 则直接返回头部
        //
        ListNode pre = null, next = null, cur = head;
        while (cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
