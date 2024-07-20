package KWayMerge;

import java.util.*;

public class MergeKSortedArrays {
    public static void main(String[] args) {
        List<Integer> l1 = Arrays.asList(2, 6, 8);
        List<Integer> l2 = Arrays.asList(3, 4, 7, 10);
        List<Integer> l3 = Arrays.asList(1, 4, 9);
        List<Integer> l4 = Arrays.asList(5, 10);
        System.out.println((kMerge_usingHeapApproach(l1, l2, l3, l4)));

    }

    static List<Integer> kMerge_usingHeapApproach(List<Integer> l1, List<Integer> l2, List<Integer> l3, List<Integer> l4) {
        List<Integer> output = new ArrayList<>();

        PriorityQueue<Element> minHeap = new PriorityQueue<>();

        minHeap.add(new Element(l1.get(0), 1, 0));
        minHeap.add(new Element(l2.get(0), 2, 0));
        minHeap.add(new Element(l3.get(0), 3, 0));
        minHeap.add(new Element(l4.get(0), 4, 0));
        int count = 0;

        while (count < 4) {
            Element e = minHeap.poll();

            output.add(e.val);
            if (e.source == 1) {
                if (e.idx < l1.size() - 1) {
                    minHeap.add(new Element(l1.get(e.idx + 1), 1, e.idx + 1));
                } else {
                    count++;
                }
            } else if (e.source == 2) {
                if (e.idx < l2.size() - 1) {
                    minHeap.add(new Element(l2.get(e.idx + 1), 2, e.idx + 1));
                } else {
                    count++;
                }
            } else if (e.source == 3) {
                if (e.idx < l3.size() - 1) {
                    minHeap.add(new Element(l3.get(e.idx + 1), 3, e.idx + 1));
                } else {
                    count++;
                }
            } else if (e.source == 4) {
                if (e.idx < l4.size() - 1) {
                    minHeap.add(new Element(l4.get(e.idx + 1), 4, e.idx + 1));
                } else {
                    count++;
                }
            }
        }


        return output;
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
