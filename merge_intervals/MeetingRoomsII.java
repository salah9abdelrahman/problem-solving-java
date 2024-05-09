package merge_intervals;
/*
https://leetcode.com/problems/meeting-rooms-ii/description/
 */

import java.util.*;

public class MeetingRoomsII {
    /*
    Time O(N logN)
    Space O(N)
     */
    static public int minMeetingRooms(int[][] intervals) {
        if (intervals.length == 0) {
            return 0;
        }

        PriorityQueue<Integer> minHeap = new PriorityQueue<>(intervals.length, Comparator.comparingInt(a -> a));
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        minHeap.add(intervals[0][1]);

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= minHeap.peek()) {
                minHeap.poll();
            }
            minHeap.add(intervals[i][1]);

        }
        return minHeap.size();

    }

    /*
    Time O(N logN)
    Space O(N)
     */
    public static int minMeetingRooms_twoPointers(int[][] intervals) {
        if (intervals.length == 0) {
            return 0;
        }

        Integer[] start = new Integer[intervals.length];
        Integer[] end = new Integer[intervals.length];

        for (int i = 0; i < intervals.length; i++) {
            start[i] = intervals[i][0];
            end[i] = intervals[i][1];
        }

        Arrays.sort(end, Comparator.comparingInt(a -> a));
        Arrays.sort(start, Comparator.comparingInt(a -> a));

        int startPointer = 0, endPointer = 0;

        int usedRooms = 0;

        while (startPointer < intervals.length) {

            if (start[startPointer] >= end[endPointer]) {
                usedRooms -= 1;
                endPointer += 1;
            }

            // We do this irrespective of whether a room frees up or not.
            // If a room got free, then this used_rooms += 1 wouldn't have any effect. used_rooms would
            // remain the same in that case. If no room was free, then this would increase used_rooms
            usedRooms += 1;
            startPointer += 1;

        }

        return usedRooms;
    }

    public static void main(String[] args) {
        System.out.println(minMeetingRooms_twoPointers(new int[][]{{2, 8}, {3, 4}, {3, 9}, {5, 11}, {8, 20}, {11, 15}}));
        System.out.println(minMeetingRooms(new int[][]{{0, 30}, {5, 10}, {15, 20}}));
//        System.out.println(minMeetingRooms(new int[][]{{9,10}, {4,9}, {4,17}}));
    }
}
