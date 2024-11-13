package com.datastructure.algorithmprictice.LinkedList;

import java.util.HashSet;

/**
 * 找到两条无环单链表的第一个相交节点, 如果不相交则返回null
 * 注意，函数返回结果后，链表必须 保持其原始结构
 * 1. 使用额外容器的做法, 建立一个HashSet, 遍历其中一条链表, 将所有节点放入Set中, 然后遍历第二条链表如果contains返回true则该节点为第一个相交节点
 * 2. 不使用额外容器的做法, 只创建固定两个节点辅助变量, 先分别遍历两条链表, 计算其长度差值diff, 然后让长链表先移动diff步, 再同时移动两个链表, 第一个==的节点即为首个相交节点
 * https://leetcode.cn/problems/intersection-of-two-linked-lists/description/
 */
public class IntersectionOfTwoLinkedList {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // 如果有链表为空 则一定不相交
        if (headA == null || headB == null) {
            return null;
        }
        ListNode longHead = headA;
        ListNode shortHead = headB;
        // 计算两条链表的长度差
        int diff = 0;
        while (longHead != null) {
            diff++;
            longHead = longHead.next;
        }
        while (shortHead != null) {
            diff--;
            shortHead = shortHead.next;
        }
        longHead = diff >= 0 ? headA : headB;
        shortHead = diff >= 0 ? headB : headA;
        diff = Math.abs(diff);
        // 长链表先走diff步
        while (diff > 0) {
            longHead = longHead.next;
            diff--;
        }
        // 两个链表同时走 直到相遇
        while (longHead != shortHead) {
            longHead = longHead.next;
            shortHead = shortHead.next;
        }
        return shortHead;
    }

    public ListNode getIntersectionNodeWithExtraSpace(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        HashSet<ListNode> set = new HashSet<>();
        set.add(headA);
        ListNode curA = headA.next;
        ListNode curB = headB;

        while (curA != null) {
            set.add(curA);
            curA = curA.next;
        }
        while (curB != null) {
            if (set.contains(curB)) {
                return curB;
            }
            curB = curB.next;
        }
        return null;
    }
}
