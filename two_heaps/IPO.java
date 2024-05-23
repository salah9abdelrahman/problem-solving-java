package two_heaps;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

/*
https://leetcode.com/problems/ipo/description/
 */
public class IPO {
    static public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        Project[] projects = new Project[capital.length];
        for (int i = 0; i < capital.length; i++) {
            projects[i] = new Project(capital[i], profits[i]);
        }
        Arrays.sort(projects);
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(projects.length, Collections.reverseOrder());
        int ptr = 0;
        for (int i = 0; i < k; i++) {
            while (ptr < projects.length && projects[ptr].c <= w) {
                maxHeap.add(projects[ptr].p);
            }
            if (maxHeap.isEmpty()) {
                break;
            }
            w += maxHeap.poll();
        }
        return w;
    }

    public static void main(String[] args) {
        System.out.println(findMaximizedCapital(3, 2, new int[]{1, 2, 3, 4, 5}, new int[]{1, 3, 4, 5, 6}));
//        System.out.println(findMaximizedCapital(2, 0, new int[]{1, 2, 3}, new int[]{0, 9, 10}));
    }

    static class Project implements Comparable<Project> {
        int c;
        int p;

        public Project(int c, int p) {
            this.c = c;
            this.p = p;
        }

        @Override
        public int compareTo(Project o) {
            return this.c - o.c;
        }
    }
}
