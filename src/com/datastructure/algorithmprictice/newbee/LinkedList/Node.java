package com.datastructure.algorithmprictice.newbee.LinkedList;

public class Node {
    public static class SingleNode {
        public int value;
        public SingleNode next;
        public SingleNode(){}
        public SingleNode(int value) {
            this.value = value;
        }
    }
    public static class DoubleNode {
        public int value;
        public DoubleNode last;
        public DoubleNode next;

    }
}
