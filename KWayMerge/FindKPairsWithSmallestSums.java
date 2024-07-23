package KWayMerge;

//https://leetcode.com/problems/find-k-pairs-with-smallest-sums/description/

import java.util.*;

public class FindKPairsWithSmallestSums {
    public static void main(String[] args) {
//        int[] nums1 = new int[]{1, 2, 6, 13, 15};
//        int[] nums2 = new int[]{3, 7, 8, 9, 10};
        int[] nums1 = new int[]{2, 8, 9};
        int[] nums2 = new int[]{1, 3, 6};
        System.out.println(kSmallestPairs(nums1, nums2, 3));
    }

    /**
    Time: o(k(log(k))
     Space: o(k)
     */
    static public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> output = new ArrayList<>(k);
        PriorityQueue<Element> heap = new PriorityQueue<>();
        Set<Pair> visited = new HashSet<>();
        visited.add(new Pair(0, 0));
        heap.add(new Element(nums1[0], 0, nums2[0], 0));
        while (output.size() < k) {
            Element element = heap.poll();
            output.add(List.of(element.x, element.y));
            Pair pair = new Pair(element.xIdx, element.yIdx);
            if (!visited.contains(pair) && element.xIdx < nums1.length && element.yIdx < nums2.length) {
                Element element1 = new Element(nums1[element.xIdx], element.xIdx, nums2[element.yIdx], element.yIdx);
                heap.add(element1);
                visited.add(pair);
            }
            Pair pairYPlus1 = new Pair(element.xIdx, element.yIdx + 1);
            if (!visited.contains(pairYPlus1) && element.xIdx < nums1.length && element.yIdx + 1 < nums2.length) {
                Element element1 = new Element(nums1[element.xIdx], element.xIdx, nums2[element.yIdx + 1], element.yIdx + 1);
                heap.add(element1);
                visited.add(pairYPlus1);
            }

            Pair pairXPlus1 = new Pair(element.xIdx + 1, element.yIdx);
            if (!visited.contains(pairXPlus1) && element.yIdx < nums2.length && element.xIdx + 1 < nums1.length) {
                Element element1 = new Element(nums1[element.xIdx + 1], element.xIdx + 1, nums2[element.yIdx], element.yIdx);
                heap.add(element1);
                visited.add(pairXPlus1);
            }
        }
        // print heap
//        System.out.println(heap);
        return output;
    }

    static class Element implements Comparable<Element> {
        int x;
        int xIdx;
        int y;
        int yIdx;

        public Element(int x, int xIdx, int y, int yIdx) {
            this.x = x;
            this.xIdx = xIdx;
            this.y = y;
            this.yIdx = yIdx;
        }

        @Override
        public int compareTo(Element o) {
            return (this.x + this.y) - (o.x + o.y);
        }

        @Override
        public String toString() {
            return "Element{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }


    }

    static class Pair {
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Pair pair)) return false;
            return x == pair.x && y == pair.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }

}
