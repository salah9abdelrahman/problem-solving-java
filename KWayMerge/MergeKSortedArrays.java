package KWayMerge;

import java.util.*;

public class MergeKSortedArrays {
    public static void main(String[] args) {
        List<Integer> l1 = Arrays.asList(2, 6, 8);
        List<Integer> l2 = Arrays.asList(3, 4, 7, 10);
        List<Integer> l3 = Arrays.asList(1, 4, 9);
        List<Integer> l4 = Arrays.asList(5, 10);
        System.out.println(kMerge_usingHeapApproach(Arrays.asList(l1, l2, l3, l4)));

    }

    static List<Integer> kMerge_usingHeapApproach(List<List<Integer>> lists) {
        List<Integer> output = new ArrayList<>();

        PriorityQueue<Element> minHeap = new PriorityQueue<>();

        for (int i = 0; i < lists.size(); i++) {
            minHeap.add(new Element(lists.get(i).get(0), i, 0));
        }

        while (!minHeap.isEmpty()) {
            Element e = minHeap.poll();

            output.add(e.val);

            if(e.idx < lists.get(e.source).size() - 1) {
                minHeap.add(new Element(lists.get(e.source).get(e.idx + 1), e.source, e.idx + 1));
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
