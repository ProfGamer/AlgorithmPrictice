package com.datastructure.algorithmprictice.LinkedList;

import java.util.Comparator;
import java.util.Objects;
import java.util.Stack;

/**
 * 判断链表是否为回文链表 https://leetcode.cn/problems/palindrome-linked-list/
 */
public class PalindromeLinkedList {
    /**
     * 容器做法, 将节点全部放入栈中, 再遍历链表和栈中弹出的元素是否一致
     * @param head
     * @return
     */
    public boolean isPalindrome1(ListNode head) {
        if (head == null || head.next == null) return true;
        Stack<ListNode> stack = new Stack<>();
        ListNode cur = head;
        while (cur != null) {
            stack.push(cur);
            cur = cur.next;
        }
        cur = head;
        while (!stack.empty()) {
            if (!Objects.equals(cur.val, stack.pop().val)) {
                return false;
            }
            cur = cur.next;
        }
        return true;
    }

    /**
     * 不使用额外的容器, 使用快慢指针的方式, 找到单链表的中点, 也就是慢指针的位置, 随后从慢指针位置开始做单链表翻转
     *  1 -> 2 -> 3 -> 3 -> 2 -> 1 -> null
     *            s         f
     *  1 -> 2 -> 3 <- 3 <- 2 <- 1
     *  l    l    l    r    r    r
     *  l r两边开始遍历, 如果不一样 break 最后返回false, 直到两个指针有一个为null 最后返回true
     *  r位置做单链表翻转
     *  1 -> 2 -> 3 -> 3 -> 2 -> 1 -> null 将链表恢复原样
     * @param head
     * @return
     */
    public boolean isPalindrome2(ListNode head){
        if (head == null || head.next == null) return true;
        boolean result = true;
        ListNode slow = head;
        ListNode fast = head;
        // 快指针先判断 如果快指针还能走两步 那就两个指针都走, 如果快指针不能走, 那么就停住
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        // 从slow位置开始单链表反转
        ListNode tail = reverseLinkedList(slow);
        // l 和 r 同时遍历节点并比较
        slow = head;
        fast = tail;
        while (slow != null && fast != null) {
            if (!Objects.equals(slow.val, fast.val)) {
                result = false;
                break;
            }
            slow = slow.next;
            fast = fast.next;
        }
        // 还原链表, 从tail开始做单链表翻转
        reverseLinkedList(tail);

        return result;
    }

    public static ListNode reverseLinkedList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        ListNode next = null;
        while (cur != null) {
            next = cur.next;
            cur.next = pre;
            pre =cur;
            cur = next;
        }
        return pre;
    }
}
