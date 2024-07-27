// https://leetcode.com/problems/k-closest-points-to-origin/description/
package top_k_elements;

import java.util.Arrays;
import java.util.PriorityQueue;

public class KClosestPointsToOrigin {
    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(kClosest(new int[][]{{-1, -3}, {-4, -5}, {-2, -2}, {-2, -3}}, 3)));
    }

    /**
     * Time O(n log k)
     * Space O(k)
     * @param points
     * @param k
     * @return
     */
    static public int[][] kClosest(int[][] points, int k) {

        PriorityQueue<int[]> heap = new PriorityQueue<>((p1, p2) -> Double.compare(calculate(p2), calculate(p1)));
        for (int i = 0; i < k; i++) {
            heap.add(points[i]);
        }

        for (int i = k; i < points.length; i++) {
            if (Double.compare(calculate(points[i]), calculate(heap.peek())) < 0) {
                heap.poll();
                heap.add(points[i]);
            }
        }

        return heap.toArray(new int[][]{});
    }

    static private double calculate(int[] p) {
        return p[0] * p[0] + p[1] * p[1];
    }
}
