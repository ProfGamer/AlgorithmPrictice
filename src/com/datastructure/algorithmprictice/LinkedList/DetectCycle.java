package com.datastructure.algorithmprictice.LinkedList;

import java.util.HashSet;
import java.util.Set;

/**
 * 返回一条链表的第一个入环节点, 如果链表无环 则返回null
 * https://leetcode.cn/problems/linked-list-cycle-ii/description/
 * 1. 可以使用Set容器法, 具体实现参考com.datastructure.algorithmprictice.LinkedList.HasCycle#hasCycleWithSet
 * 2. 可以使用快慢指针法, 先使用快慢指针判断是否有环 如果有环, 则将快指针移动回head, 调整快指针的速度, 两个指针再次相遇时, 即为入环节点
 */
public class DetectCycle {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) return null;
        return detectCycleWithPointer(head);
    }

    private static ListNode detectCycleWithPointer(ListNode head){
        ListNode slow = head;
        ListNode fast = head;
        while (slow != fast) {
            if (fast.next == null || fast.next.next == null) return null;
            fast = fast.next.next;
            slow = slow.next;
        }
        fast = head;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }


    private static ListNode detectCycleWithSet(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        while (head != null) {
            if (set.contains(head)) {
                break;
            }
            set.add(head);
            head = head.next;
        }
        return head;
    }
}
