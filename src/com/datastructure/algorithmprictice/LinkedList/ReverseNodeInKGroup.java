package com.datastructure.algorithmprictice.LinkedList;

import java.util.ArrayList;
import java.util.List;

/**
 * 以K个节点一组反转链表, 返回新的头节点, 如果一组内不足k个, 则不反转 https://leetcode.cn/problems/reverse-nodes-in-k-group/
 * 1. 容器化做法, 将链表的全部节点都放进容器中, 然后每K个节点进行反转, 最后再重新连接此链表, 返回新的头部
 */
public class ReverseNodeInKGroup {

    public ListNode reverseKGroup2(ListNode head, int k) {
        // 方法返回的新头节点, 一定是newHead, 如果长度不足K, 代表无法翻转, 那么直接返回head
        ListNode newHead = countKReturnEnd(head, k);
        if (newHead == null) {
            return head;
        }
        // 需要对第一组进行特殊处理
        ListNode lastGroupEnd = head;
        reverseLinkedList(head, k);
        while (lastGroupEnd.next != null) {
            ListNode teamEnd = lastGroupEnd.next;
            ListNode teamHead = countKReturnEnd(teamEnd, k);
            if (teamHead == null) break;
            reverseLinkedList(teamEnd, k);
            lastGroupEnd.next = teamHead;
            lastGroupEnd = teamEnd;
        }

        return newHead;
    }

    /**
     *
     * @param start
     * @param k
     * @return 从该节点开始包括该节点K个节点中的最后一个节点, 如果之后不足K个, 那么返回null
     */
    private static ListNode countKReturnEnd(ListNode start, int k) {
        ListNode end = start;
        for (int i = 1 ; i < k && end != null ; i++) {
            end = end.next;
        }
        return end;
    }

    /**
     * 在这个翻转方法中, 我们不需要考虑不足K个的情况, 方法外会进行判断, 同时, 我们将链表翻转后, 还需要将新的尾部(原start)连接到K+1节点, 防止链表断链
     * @param start
     * @param k
     * @return
     */
    private static ListNode reverseLinkedList(ListNode start, int k){
        ListNode cur = start;
        ListNode pre = null;
        ListNode next = null;
        for (int i = 0; i< k ; i++) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        start.next = next;
        return pre;
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) return null;
        ListNode[] nodes = new ListNode[100001];
        int size = 0;
        ListNode cur = head;
        while (cur != null) {
            nodes[size++] = cur;
            cur = cur.next;
        }
        if (size < k) return head;
        for (int i = 0; i < size; i += k) {
            if (i + k > size) break;
            swapScope(nodes, i, i + k - 1);
        }
        // 再都串起来
        for (int i = 0 ; i < size; i++) {
            nodes[i].next = nodes[i+1];
        }
        return nodes[0];
    }

    private void swapScope(ListNode[] nodes, int left, int right) {
        while (left < right) {
            ListNode temp = nodes[left];
            nodes[left] = nodes[right];
            nodes[right] = temp;
            left++;
            right--;
        }
    }


}
