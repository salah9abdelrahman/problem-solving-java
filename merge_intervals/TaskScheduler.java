package merge_intervals;


import java.util.*;

/*
https://leetcode.com/problems/task-scheduler/description/
 */
public class TaskScheduler {

    /*
    Time complexity: O(N)
    Space : O(26) = O(1)
     */
    static public int leastInterval_pq(char[] tasks, int n) {
        // Build frequency map
        int[] freq = new int[26];
        for (char ch : tasks) {
            freq[ch - 'A']++;
        }

        // Max heap to store frequencies
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < 26; i++) {
            if (freq[i] > 0) {
                pq.offer(freq[i]);
            }
        }

        int time = 0;
        // Process tasks until the heap is empty
        while (!pq.isEmpty()) {
            int cycle = n + 1;
            List<Integer> store = new ArrayList<>();
            int taskCount = 0;
            // Execute tasks in each cycle
            while (cycle > 0 && !pq.isEmpty()) {
                int currentFreq = pq.poll();
                if (currentFreq > 1) {
                    store.add(currentFreq - 1);
                }
                taskCount++;
                cycle--;
            }
            // Restore updated frequencies to the heap
            store.forEach(pq::offer);
            // Add time for the completed cycle
            time += (pq.isEmpty() ? taskCount : n + 1);
        }
        return time;
    }


    public static void main(String[] args) {
        System.out.println(leastInterval_pq(new char[]{'A', 'A', 'A', 'B', 'B', 'B'}, 2));
    }


}
