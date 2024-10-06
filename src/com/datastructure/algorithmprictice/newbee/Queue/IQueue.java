package com.datastructure.algorithmprictice.newbee.Queue;

public interface IQueue {
    boolean insertLast(int value);

    boolean deleteFront();

    int getFront();

    boolean isEmpty();

    boolean isFull();
}
