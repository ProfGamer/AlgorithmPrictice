package com.datastructure.algorithmprictice.newbee.LinkedList;

/**
 * 两个链表相加 eg 976 + 9380
 * 6 -> 7 -> 9 -> null 链表
 * 0 -> 8 -> 3 -> 9 -> null 链表
 * 6 -> 5 -> 3 -> 0 -> 1 -> null 结果
 */
public class AddTwoNumbers {
    public static Node.SingleNode addTwoNumbersWithWhile(Node.SingleNode h1, Node.SingleNode h2) {
        // 这里我们用新建一个链表的形式来做题
        Node.SingleNode head = null;
        Node.SingleNode cur = null;
        Node.SingleNode cur1 = h1;
        Node.SingleNode cur2 = h2;
        int sum, value, carry = 0;
        while (cur1 != null || cur2 != null) {
            sum = (cur1 == null ? 0 : cur1.value) + (cur2 == null ? 0 : cur2.value) + carry;
            value = sum % 10;
            carry = sum / 10;
            if (head == null) {
                head = new Node.SingleNode(value);
                cur = head;
            } else {
                cur.next = new Node.SingleNode(value);
                cur = cur.next;
            }
            cur1 = cur1 == null ? null : cur1.next;
            cur2 = cur2 == null ? null : cur2.next;

        }
        if (carry != 0) {
            cur.next = new Node.SingleNode(1);
        }
        return head;
    }

    public static Node.SingleNode addTwoNumbersWithFor(Node.SingleNode h1, Node.SingleNode h2) {
        Node.SingleNode head = null;
        Node.SingleNode cur = null;
        Node.SingleNode cur1 = h1;
        Node.SingleNode cur2 = h2;
        int carry = 0;
        for (int value, sum;
             cur1 != null || cur2 != null;
             cur1 = cur1 == null ? null : cur1.next,
                     cur2 = cur2 == null ? null : cur2.next) {
            sum = (cur1 == null ? 0 : cur1.value) + (cur2 == null ? 0 : cur2.value) + carry;
            value = sum % 10;
            carry = sum / 10;
            if (head == null) {
                head = new Node.SingleNode(value);
                cur = head;
            } else {
                cur.next = new Node.SingleNode(value);
                cur = cur.next;
            }
        }
        if (carry != 0) {
            cur.next = new Node.SingleNode(1);
        }
        return head;
    }
}
