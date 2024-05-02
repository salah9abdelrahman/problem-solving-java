package merge_intervals;

import java.util.LinkedList;

public class InsertInterval {
    public static void main(String[] args) {

        int[][] input = {
                {1, 5}
        };

        int[][] output = insert(input, new int[]{0, 1});

        for (int i = 0; i < output.length; i++) {
            for (int j = 0; j < output[i].length; j++) {
                System.out.print(output[i][j] + " ");
            }
            System.out.println();
        }
    }

    /*
    Time: O(N)
    Space: O(N)
     */
    public static int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals.length == 0) {
            return new int[][]{newInterval};
        }

        LinkedList<int[]> output = new LinkedList<>();
        boolean newIntervalNotAdded = true;
        for (int i = 0; i < intervals.length; i++) {
            int[] j = intervals[i];
            if (newIntervalNotAdded) {
                if (newInterval[1] < j[0]) {
                    output.add(newInterval);
                    output.add(j);
                    newIntervalNotAdded = false;
                } else {
                    if (newInterval[0] <= j[1]) {
                        output.add(new int[]{Math.min(newInterval[0], j[0]), Math.max(newInterval[1], j[1])});
                        newIntervalNotAdded = false;
                    } else {
                        output.add(j);
                    }
                }
            } else {
                for ( i = i; i < intervals.length;i++) {
                    int[] x = intervals[i];
                    if (output.getLast()[1] >= x[0]) {
                        output.getLast()[1] = Math.max(x[1], output.getLast()[1]);
                    } else {
                        output.add(x);
                    }
                }
                break;
            }

        }

        if(newIntervalNotAdded){
            output.add(newInterval);
        }
        return output.toArray(new int[][]{});
    }
}
