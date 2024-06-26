package two_heaps;

import java.util.*;

/*
https://www.educative.io/courses/grokking-coding-interview-patterns-java/schedule-tasks-on-minimum-machines
 */
public class ScheduleTasksOnMinimumMachines {

    public static int tasks(List<List<Integer>> tasksList) {
        int optimalMachines = 0;

        PriorityQueue<int[]> machinesAvailable = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        PriorityQueue<int[]> tasksQueue = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        for (List<Integer> task : tasksList) {
            tasksQueue.offer(new int[]{
                    task.get(0), task.get(1)
            });
        }

        while (!tasksQueue.isEmpty()) {
            int[] task = tasksQueue.poll();
            int[] machineInUse;
            if (!machinesAvailable.isEmpty() && task[0] >= machinesAvailable.peek()[0]) {
                machineInUse = machinesAvailable.poll();
                machineInUse = new int[]{
                        task[1], machineInUse[1]
                };
            } else {
                optimalMachines += 1;
                machineInUse = new int[]{
                        task[1], optimalMachines
                };
            }
            machinesAvailable.offer(machineInUse);
        }
        return optimalMachines;
    }

    public static void main(String[] args) {
        List<List<Integer>> inputs = Arrays.asList(
                Arrays.asList(5, 6),
                Arrays.asList(1, 8),
                Arrays.asList(6, 7),
                Arrays.asList(10, 14),
                Arrays.asList(8, 13)
        );

        System.out.println(tasks(inputs));
    }


}
