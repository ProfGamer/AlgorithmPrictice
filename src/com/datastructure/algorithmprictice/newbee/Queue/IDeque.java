package com.datastructure.algorithmprictice.newbee.Queue;

public interface IDeque extends IQueue {
    boolean insertFront(int value);

    boolean deleteLast();

    int getRear();

}
