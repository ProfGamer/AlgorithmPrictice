package com.datastructure.algorithmprictice.LinkedList;

import java.util.HashSet;
import java.util.Set;

/**
 * 判断一个单链表是否有环
 * https://leetcode.cn/problems/linked-list-cycle/description/
 * 可以使用Set容器来检查是否有节点重复
 * 也可以使用快慢指针, 如果两个指针相遇 则证明有环, 如果快指针先走到了空, 那么证明无环
 */
public class HasCycle {
    public boolean hasCycle(ListNode head) {
        return hasCycleWithSet(head);

    }

    private static boolean hasCycleWithTwoPointers(ListNode head) {
        if (head == null) return false;
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }

    private static boolean hasCycleWithSet(ListNode head){
        Set<ListNode> set = new HashSet<>();
        while (head != null) {
            if (set.contains(head)) return true;
            set.add(head);
            head = head.next;
        }
        return false;
    }
}
