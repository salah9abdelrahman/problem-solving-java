// https://leetcode.com/problems/gas-station/description/
package greedy;

class GasStationSolution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int currGain = 0, totalGain = 0, answer = 0;

        for (int i = 0; i < gas.length; ++i) {
            totalGain += gas[i] - cost[i];
            currGain += gas[i] - cost[i];

            if (currGain < 0) {
                answer = i + 1;
                currGain = 0;
            }
        }

        return totalGain >= 0 ? answer : -1;
    }
}

public class GasStation {
    public static void main(String[] args) {
//        System.out.println(new GasStationSolution().canCompleteCircuit(
//                new int[]{1, 2, 3, 4, 5},
//                new int[]{3, 4, 5, 1, 2}
//        ));
        System.out.println(new GasStationSolution().canCompleteCircuit(
                new int[]{5, 8, 2, 8},
                new int[]{6, 5, 6, 6}
        ));

    }
}