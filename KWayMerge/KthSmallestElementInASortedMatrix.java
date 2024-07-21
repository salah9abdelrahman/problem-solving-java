package KWayMerge;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class KthSmallestElementInASortedMatrix {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 5, 9},
                {10, 11, 13},
                {12, 13, 15}
        };
        System.out.println(kthSmallest_usingHeapApproach(matrix, 8));
    }

    static public int kthSmallest_usingHeapApproach(int[][] matrix, int k) {
        List<Integer> output = new ArrayList<>();

        int minNeededRows = Math.min(matrix.length, k);

        PriorityQueue<Element> minHeap = new PriorityQueue<>(minNeededRows);

        for (int i = 0; i < minNeededRows; i++) {
            minHeap.add(new Element(matrix[i][0], i, 0));
        }

        int i = k;
        while (i > 0) {
            Element e = minHeap.poll();
            output.add(e.val);

            if (e.idx < matrix[e.source].length - 1) {
                minHeap.add(new Element(matrix[e.source][e.idx + 1], e.source, e.idx + 1));
            }
            i--;
        }
        System.out.println(output);
        return output.get(k - 1);
    }

    static class Element implements Comparable<Element> {
        public Element(int val, int source, int idx) {
            this.val = val;
            this.source = source;
            this.idx = idx;
        }

        int val;
        int source;
        int idx;

        @Override
        public int compareTo(Element o) {
            return this.val - o.val;
        }
    }
}
