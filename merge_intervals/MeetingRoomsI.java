package merge_intervals;

import java.util.Arrays;
import java.util.Comparator;

/*
https://leetcode.com/problems/meeting-rooms/description/
 */
public class MeetingRoomsI {
    /*
    Time: O(N log N) due to sorting
    space: O(1)
     */
    public boolean canAttendMeetings(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        for (int i = 0; i < intervals.length -1; i++) {
            if(intervals[i][1] > intervals[i+1][0]){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

    }
}
