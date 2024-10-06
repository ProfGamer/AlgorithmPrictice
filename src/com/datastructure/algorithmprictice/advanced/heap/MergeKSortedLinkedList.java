package com.datastructure.algorithmprictice.advanced.heap;

import com.datastructure.algorithmprictice.newbee.LinkedList.Node;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class MergeKSortedLinkedList {
    public static Node.SingleNode mergeKSortedList(Node.SingleNode[] arr) {
        if (arr == null || arr.length == 0) return null;
        PriorityQueue<Node.SingleNode> heap = new PriorityQueue<>((a, b) -> a.value - b.value);
        for (Node.SingleNode node : arr) {
            if (node != null) heap.add(node);
        }
        Node.SingleNode head = heap.poll();
        Node.SingleNode cur = head;
        if (head.next != null) {
            heap.add(head.next);
        }
        while (!heap.isEmpty()) {
            if (heap.size() == 1) break;
            cur.next = heap.poll();
            cur = cur.next;
            if (cur.next != null) {
                heap.add(cur.next);
            }
        }
        cur.next = heap.poll();
        return head;
    }
}
