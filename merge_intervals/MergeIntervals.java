package merge_intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

/*
https://leetcode.com/problems/merge-intervals/description/
 */
public class MergeIntervals {
    public static void main(String[] args) {

        int[][] input = {
                {1, 3},
                {2, 6},
                {8, 10},
                {10, 15}
        };

        int[][] output = mergeIntervals(input);

        for (int i = 0; i < output.length; i++) {
            for (int j = 0; j < output[i].length; j++) {
                System.out.print(output[i][j] + " ");
            }
            System.out.println();
        }

    }

    /*
    Time O(n log(n))
    space O(n)
     */
    public static int[][] mergeIntervals(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        LinkedList<int[]> output = new LinkedList<>();
        output.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            int[] j = intervals[i];
            if (output.getLast()[1] >= j[0]) {
                output.getLast()[1] = Math.max(j[1], output.getLast()[1]);
            } else {
                output.add(j);
            }
        }
        return output.toArray(new int[][]{});
    }
}
