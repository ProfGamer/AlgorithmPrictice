package com.datastructure.algorithmprictice.myPrictice.LinkedList;

import java.util.ArrayList;

/**
 * @Author: Xin Yuchen
 * @Date: 2022/5/19 - 05 - 19 - 17:47
 * @Description: Any Ques or Concerns, plz contact e0838400@u.nus.edu
 */

public class FindMiddle {
    public static void main(String[] args) {
        int times = 1000;
        for (int i = 0; i < times; i++) {
            Node test = generateSingleLinkedList(10, 10);

            Node ans1 = null;
            Node ans2 = null;

            ans1 = findMiddleOrFirstMiddle(test);
            ans2 = right1(test);
            if(ans1==null && ans2 == null){
                System.out.println("Pass");
            }else{
                System.out.println(ans1.value == ans2.value ? "Pass" : "Fail");
            }

            ans1 = findMiddleOrSecondMiddle(test);
            ans2 = right2(test);
            if(ans1==null && ans2 == null){
                System.out.println("Pass");
            }else{
                System.out.println(ans1.value == ans2.value ? "Pass" : "Fail");
            }

            ans1 = findBeforeMiddleOrFirstMiddle(test);
            ans2 = right3(test);
            if(ans1==null && ans2 == null){
                System.out.println("Pass");
            }else{
                System.out.println(ans1.value == ans2.value ? "Pass" : "Fail");
            }


            ans1 = findBeforeMiddleOrSecondMiddle(test);
            ans2 = right4(test);
            if(ans1==null && ans2 == null){
                System.out.println("Pass");
            }else{
                System.out.println(ans1.value == ans2.value ? "Pass" : "Fail");
            }
        }
    }

    /**
     * 快慢指针方法找到 奇数长度链表的唯一中点, 偶数长度链表的上中点
     *
     * @param head 头结点
     * @return 中点或上中点位置的节点
     */
    public static Node findMiddleOrFirstMiddle(Node head) {
        // 定义两个快慢指针, 慢指针一次一步,快指针一次两步
        Node slow = head;
        Node fast = head;
        while (fast.next != null) { // 这种情况 快指针先尝试动两步 如果成功, 慢指针再跟着动一步
            fast = fast.next;
            if (fast.next != null) {
                fast = fast.next;
                slow = slow.next;
            }
        }
        return slow;
    }

    /**
     * 快慢指针方法找到 奇数长度链表的唯一中点, 偶数长度链表的下中点
     *
     * @param head 头结点
     * @return 中点或下中点位置结点
     */
    public static Node findMiddleOrSecondMiddle(Node head) {
        // 定义两个快慢指针, 慢指针一次一步,快指针一次两步
        Node slow = head;
        Node fast = head;
        while (fast.next != null) { // 这种情况 快指针先尝试动一步 如果成功, 慢指针再跟着动一步, 然后快指针再尝试动一步
            fast = fast.next;
            slow = slow.next;
            if (fast.next != null) {
                fast = fast.next;
            }
        }
        return slow;
    }

    /**
     * 快慢指针方法找到 奇数长度链表的唯一中点的前一个结点, 偶数长度链表的上中点的前一个结点
     *
     * @param head 头结点
     * @return 中点或上中点前一个位置结点
     */
    public static Node findBeforeMiddleOrFirstMiddle(Node head) {
        // 无节点,或一个节点,或者两个节点, 返回null
        if (head == null || head.next == null || head.next.next == null) {
            return null;
        }
        // 定义两个快慢指针, 慢指针一次一步,快指针一次两步
        Node slow = head;
        Node fast = head;
        while (fast.next != null) { // 这种情况 快指针先动两步, 再尝试动, 如果可以, 则慢指针动一步
            fast = fast.next;
            if (fast.next != null) {
                fast = fast.next;
            }
            if (fast.next != null && fast.next.next != null) {
                slow = slow.next;
            }
        }
        return slow;
    }

    /**
     * 快慢指针方法找到 奇数长度链表的唯一中点前一个结点, 偶数长度链表的下中点的前一个结点
     *
     * @param head 头结点
     * @return 中点或下中点前一个位置结点
     */
    public static Node findBeforeMiddleOrSecondMiddle(Node head) {
        // 无节点,或一个节点,或者两个节点, 返回null
        if (head == null || head.next == null) {
            return null;
        }
        if (head.next.next == null) {
            return head;
        }
        // 定义两个快慢指针, 慢指针一次一步,快指针一次两步
        Node slow = head;
        Node fast = head;
        while (fast.next != null) { // 这种情况 快指针先动两步, 再尝试动, 如果可以, 则慢指针动一步
            fast = fast.next;
            if (fast.next != null) {
                fast = fast.next;
            }
            if (fast.next != null) {
                slow = slow.next;
            }
        }
        return slow;
    }

    /**
     * 单链表节点
     */
    public static class Node {
        public int value;
        public Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    /**
     * 生成随机长度 随机值的单链表
     *
     * @param num   链表长度在 1 ~ num
     * @param value 链表每个节点的值在 0 ~ value
     * @return
     */
    public static Node generateSingleLinkedList(int num, int value) {
        num = (int) (Math.random() * (num + 1));
        value = (int) (Math.random() * (value + 1));
        Node head = new Node(value);
        Node pre = head;
        num--;

        while (num > 0) {
            pre.next = new Node((int) (Math.random() * (value + 1)));
            pre = pre.next;
            num--;
        }
        return head;
    }

    /**
     * 容器法
     * @param head
     * @return
     */
    public static Node right1(Node head) {
        if (head == null) {
            return null;
        }
        Node cur = head;
        ArrayList<Node> arr = new ArrayList<>();
        while (cur != null) {
            arr.add(cur);
            cur = cur.next;
        }
        return arr.get((arr.size() - 1) / 2);
    }
    /**
     * 容器法
     * @param head
     * @return
     */
    public static Node right2(Node head) {
        if (head == null) {
            return null;
        }
        Node cur = head;
        ArrayList<Node> arr = new ArrayList<>();
        while (cur != null) {
            arr.add(cur);
            cur = cur.next;
        }
        return arr.get(arr.size() / 2);
    }
    /**
     * 容器法
     * @param head
     * @return
     */
    public static Node right3(Node head) {
        if (head == null || head.next == null || head.next.next == null) {
            return null;
        }
        Node cur = head;
        ArrayList<Node> arr = new ArrayList<>();
        while (cur != null) {
            arr.add(cur);
            cur = cur.next;
        }
        return arr.get((arr.size() - 3) / 2);
    }
    /**
     * 容器法
     * @param head
     * @return
     */
    public static Node right4(Node head) {
        if (head == null || head.next == null) {
            return null;
        }
        Node cur = head;
        ArrayList<Node> arr = new ArrayList<>();
        while (cur != null) {
            arr.add(cur);
            cur = cur.next;
        }
        return arr.get((arr.size() - 2) / 2);
    }
}
