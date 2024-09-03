// https://leetcode.com/problems/minimum-number-of-refueling-stops/
package greedy;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @time O(n log (n))
 * @space o(n)
 */
class MinimumNumberOfRefuelingStopsHeapSolution {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        if (startFuel >= target) return 0;
        Queue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        int i = 0, n = stations.length, refuels = 0, maxDistance = startFuel;
        while (maxDistance < target) {
            while (i < n && stations[i][0] <= maxDistance) {
                queue.offer(stations[i++][1]);
            }
            if (queue.isEmpty()) return -1;
            maxDistance += queue.poll();
            refuels++;
        }
        return refuels;
    }
}

/**
 * @time O(n ^ 2)
 * @space o(n)
 */
class DPSolution {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        int N = stations.length;
        long[] dp = new long[N + 1];
        dp[0] = startFuel;
        for (int i = 0; i < N; i++)
            for (int j = i; j >= 0; j--)
                if (dp[j] >= stations[i][0])
                    dp[j + 1] = Math.max(dp[j + 1], dp[j] + stations[i][1]);

        for (int i = 0; i <= N; ++i)
            if (dp[i] >= target) return i;
        return -1;
    }
}

public class MinimumNumberOfRefuelingStops {
    public static void main(String[] args) {
        System.out.println(new MinimumNumberOfRefuelingStopsHeapSolution().minRefuelStops(15, 3,
                new int[][]{{2, 5}, {3, 1}, {6, 4}, {12, 6}}
        ));
    }
}
