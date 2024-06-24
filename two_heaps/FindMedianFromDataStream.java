package two_heaps;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class FindMedianFromDataStream {
    public static void main(String[] args) {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(41);
        medianFinder.addNum(35);
        medianFinder.addNum(62);
        medianFinder.addNum(4);
        System.out.println(medianFinder.findMedian());

    }

    static class MedianFinder {
        PriorityQueue<Integer> minHeapForHigherHalf;
        PriorityQueue<Integer> maxHeapForSmallHalf;

        public MedianFinder() {
            minHeapForHigherHalf = new PriorityQueue<>();
            maxHeapForSmallHalf = new PriorityQueue<>( Collections.reverseOrder() );
        }

        /*
         * Time: O(log n)
         * Space O(n)
         */
        public void addNum(int num) {
            if (maxHeapForSmallHalf.isEmpty() || maxHeapForSmallHalf.peek() >= num) {
                maxHeapForSmallHalf.add(num);
            } else {
                minHeapForHigherHalf.add(num);
            }

            // balancing the 2-heaps
            if (maxHeapForSmallHalf.size() > minHeapForHigherHalf.size() + 1) {
                minHeapForHigherHalf.add(maxHeapForSmallHalf.poll());
            } else if (maxHeapForSmallHalf.size() < minHeapForHigherHalf.size()) {
                maxHeapForSmallHalf.add(minHeapForHigherHalf.poll());
            }
        }

        public void addNum_leetcode(int num) {
            maxHeapForSmallHalf.add(num);
            minHeapForHigherHalf.add(maxHeapForSmallHalf.poll());
            if (minHeapForHigherHalf.size() > maxHeapForSmallHalf.size()) {
                maxHeapForSmallHalf.add(minHeapForHigherHalf.poll());
            }
        }

        /*
         * Time: O(1)
         */
        public double findMedian() {
            if (maxHeapForSmallHalf.size() == minHeapForHigherHalf.size()) {
                return maxHeapForSmallHalf.peek() / 2.0 + minHeapForHigherHalf.peek() / 2.0;
            }
            return maxHeapForSmallHalf.peek();
        }

        public void printHeaps() {
            System.out.print("Max heap: " + Arrays.toString(maxHeapForSmallHalf.toArray()) + " , ");
            System.out.println("Min heap: " + Arrays.toString(minHeapForHigherHalf.toArray()));
        

        }
    }

}
