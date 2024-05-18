package data_structure.heap;

import java.util.PriorityQueue;

/*
Min heap implementation
 */
public class PriorityQueueJdk {
    public static void main(String[] args) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(25);
        priorityQueue.add(-22);
        priorityQueue.add(1343);
        priorityQueue.add(54);
        priorityQueue.add(0);
        priorityQueue.add(-3492);
        priorityQueue.add(492);

        System.out.println(priorityQueue.peek());

        System.out.println(priorityQueue.remove());

        System.out.println(priorityQueue.peek());

        System.out.println(priorityQueue.poll());

        System.out.println(priorityQueue.peek());

        System.out.println(priorityQueue.remove(492));

        System.out.println(priorityQueue.peek());

        System.out.println(priorityQueue.add(-1));

        System.out.println(priorityQueue.peek());



    }
}
