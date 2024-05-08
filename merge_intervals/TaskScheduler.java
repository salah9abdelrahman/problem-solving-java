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

    /*
Time complexity: O(N)
Space : O(26) = O(1)
 */
    static public int leastInterval_2(char[] tasks, int n) {
        // Create a frequency array to keep track of the count of each task
        int[] freq = new int[26];
        for (char task : tasks) {
            freq[task - 'A']++;
        }

        // Sort the frequency array in non-decreasing order
        Arrays.sort(freq);

        // Calculate the maximum frequency of any task
        int maxFreq = freq[25] - 1;

        // Calculate the number of idle slots that will be required
        int idleSlots = maxFreq * n;


        // Iterate over the frequency array from the second-highest frequency to the lowest frequency
        for (int i = 24; i >= 0 && freq[i] > 0 && idleSlots > 0; i--) {
            // Subtract the minimum of the maximum frequency and the current frequency from the idle slots
            idleSlots -= Math.min(maxFreq, freq[i]);
        }
        // If there are any idle slots left, add them to the total number of tasks
        return idleSlots > 0 ? idleSlots + tasks.length : tasks.length;
    }

    /*
Time complexity: O(N)
Space : O(26) = O(1)
*/
    static public int leastInterval_greedy(char[] tasks, int n) {
        // Counter array to store the frequency of each task
        int[] counter = new int[26];
        int maximum = 0;
        int maxCount = 0;

        // Traverse through tasks to calculate task frequencies
        for (char task : tasks) {
            counter[task - 'A']++;
            if (maximum == counter[task - 'A']) {
                maxCount++;
            } else if (maximum < counter[task - 'A']) {
                maximum = counter[task - 'A'];
                maxCount = 1;
            }
        }

        // Calculate idle slots, available tasks, and idles needed
        int partCount = maximum - 1;
        int partLength = n - (maxCount - 1);
        int emptySlots = partCount * partLength;
        int availableTasks = tasks.length - maximum * maxCount;
        int idles = Math.max(0, emptySlots - availableTasks);

        return tasks.length + idles;
    }


    public static void main(String[] args) {
        System.out.println(leastInterval_greedy(new char[]{'A', 'A', 'A', 'B', 'B', 'C', 'C', 'D',}, 3));
    }


}
