package merge_intervals;

import java.util.LinkedList;

/*
https://leetcode.com/problems/interval-list-intersections/description/
 */
public class IntervalListIntersections {
    public static void main(String[] args) {

        int[][] array1 = {{3, 5}, {9, 20}};
        int[][] array2 = {{4, 5}, {7, 10}, {11, 12}, {14, 15}, {16, 20}};

        int[][] output = intervalIntersection(array1, array2);

        for (int[] i : output) {
            for (int j : i) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }


    public static int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        LinkedList<int[]> ans = new LinkedList<>();
        int i = 0, j = 0;

        while (i < firstList.length && j < secondList.length) {
            // hi - the endpoint of the intersection
            int lo = Math.max(firstList[i][0], secondList[j][0]);
            int hi = Math.min(firstList[i][1], secondList[j][1]);
            if (lo <= hi)
                ans.add(new int[]{lo, hi});

            // Remove the interval with the smallest endpoint
            if (firstList[i][1] < secondList[j][1])
                i++;
            else
                j++;
        }

        return ans.toArray(new int[ans.size()][]);
    }
}
