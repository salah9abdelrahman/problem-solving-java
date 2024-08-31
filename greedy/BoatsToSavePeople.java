// https://leetcode.com/problems/boats-to-save-people/description/
package greedy;

import java.util.Arrays;

public class BoatsToSavePeople {
}


/**
 * @time O(n log n)
 * @space o(n)
 */
class BoatsToSavePeopleSolution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int boats = 0;
        int p1=0;
        int p2 = people.length - 1;
        while(p1 <= p2){
            if (people[p1] + people[p2] <= limit){
                p1++;
            }
            p2--;
            boats++;
        }

        return boats;
    }
}