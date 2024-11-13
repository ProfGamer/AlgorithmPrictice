package com.datastructure.algorithmprictice.LinkedList;

/**
 * 判断两条链表是否相交
 * 最后一个非空节点是否一样
 */
public class CheckIntersection {
    public boolean checkIntersection(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return false;
        }
        ListNode endA = headA;
        ListNode endB = headB;
        while (endA.next != null) {
            endA = endA.next;
        }
        while (endB.next != null) {
            endB = endB.next;
        }
        return endA == endB;
    }
}
