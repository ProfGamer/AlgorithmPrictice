package com.datastructure.algorithmprictice.LinkedList;

public class SortLinkedList {
    public static ListNode SLOW, FAST;
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        // 先用快慢指针找到链表的中点mNode
        ListNode mNode = findMiddleNode(head);
        // 之后记录mNode.next
        ListNode rHead = mNode.next;
        // 将mNode的next设置为null 将链表切断为左右两条
        mNode.next = null;
        // 再分别递归调用sortList head和mNode.next
        ListNode left = sortList(head);
        ListNode right  = sortList(rHead);
        // 两边都调用完之后, 我们认为两条链表已经分别有序, 再merge两条链表, 返回链表的头节点
        return merge(left, right);
    }

    private ListNode merge(ListNode left, ListNode right) {
        ListNode head = left.val <= right.val ? left : right;
        ListNode cur = head;
        if (head == left) {
            left = left.next;
        } else {
            right = right.next;
        }

        while (left != null && right != null) {
            if (left.val <= right.val) {
                cur.next = left;
                left = left.next;
            } else {
                cur.next = right;
                right = right.next;
            }
            cur = cur.next;
        }
        cur.next = right == null ? left : right;
        return head;
    }

    /**
     * 使用快慢指针找出链表中点
     * @param head
     * @return
     */
    private ListNode findMiddleNode(ListNode head) {
        SLOW = head;
        FAST = head;
        if (FAST.next != null && FAST.next.next != null) {
            FAST = FAST.next.next;
            SLOW = SLOW.next;
        }
        return SLOW;
    }
}
