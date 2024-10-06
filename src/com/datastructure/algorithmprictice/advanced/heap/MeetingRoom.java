package com.datastructure.algorithmprictice.advanced.heap;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MeetingRoom {
    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);
        PriorityQueue<Integer> heap = new PriorityQueue<>((a,b)-> a - b);
        int max = 0;
        for (int[] interval : intervals) {
            if (!heap.isEmpty() && heap.peek() <= interval[0]) {
                heap.poll();
            }
            heap.add(interval[1]);
            max = Math.max(max, heap.size());
        }
        return max;
    }
}
