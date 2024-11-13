package com.datastructure.algorithmprictice.LinkedList;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.cn/problems/copy-list-with-random-pointer/description/
 */
public class CopyRandomLinkedList {

    class Node {
        int val;
        Node next;
        Node random;

        public Node (int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    /**
     * 容器的方法解决, 使用一个HashMap, 遍历所有节点, 将原节点存为Key, 新建的节点设置为value,
     * 之后遍历每对Entre, 将新建节点的next设置为原节点的next的value, 将random设置为原节点random的value
     * @param head
     * @return
     */
    public Node copyRandomList1(Node head) {
        if (head == null) return head;
        Map<Node, Node> map = new HashMap<>();
        Node cur = head;
        while (cur != null) {
            map.put(cur, new Node(cur.val));
            cur = cur.next;
        }

        map.forEach((original, copy) -> {
            copy.next = map.get(original.next);
            copy.random = map.get(original.random);
        });
        return map.get(head);

    }

    /**
     * 不使用额外的容器, 直接在原链表上 每个节点的next位置插入拷贝节点, 之后按对遍历, 每个拷贝节点的random位置就是原节点random位置的next
     * 最后分离两条链表, 返回拷贝链表头节点
     * @param head
     * @return
     */
    public Node copyRandomList2(Node head) {
        if (head == null) return head;
        // 将每个节点的next位置设置为拷贝节点
        // 1 -> 2 -> 3 -> 4 -> null
        Node cur = head;
        while (cur != null) {
            Node next = cur.next;
            cur.next = new Node(cur.val);
            cur.next.next = next;
            cur = next;
        }
        // 1 -> 1' -> 2 -> 2' -> 3 -> 3' -> 4 -> 4' -> null
        // 两个节点一组遍历, 设置random指针位置
        cur = head;
        while (cur != null) {
            Node original = cur;
            Node copy = cur.next;
            copy.random = original.random == null ? null : original.random.next;
            cur = copy.next;
        }
        // 分离两条链表
        Node result = head.next;
        cur = head;
        // 1 -> 1' -> 2 -> 2' -> 3 -> 3' -> 4 -> 4' -> null
        // 1  -> 2 ->  3  -> 4  -> null
        //
        // 1' -> 2' -> 3' -> 4' -> null

        while (cur != null) {
            Node original = cur;
            Node copy = cur.next;
            Node next = copy.next;
            original.next = next;
            copy.next = next == null ? null : next.next;
            cur = next;

        }
        return result;
    }
}
