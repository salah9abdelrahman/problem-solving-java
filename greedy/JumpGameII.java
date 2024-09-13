// https://leetcode.com/problems/jump-game-ii/
package greedy;

/**
 * @time O(n)
 * @space O(1)
 */
class GreedyJumpGameIISolution {
    public int jump(int[] nums) {
        // The starting range of the first jump is [0, 0]
        int answer = 0, n = nums.length;
        int curEnd = 0, curFar = 0;

        for (int i = 0; i < n - 1; i++) {
            // Update the farthest reachable index of this jump.
            curFar = Math.max(curFar, i + nums[i]);

            // If we finish the starting range of this jump,
            // Move on to the starting range of the next jump.
            if (i == curEnd) {
                answer++;
                curEnd = curFar;
            }
        }

        return answer;
    }
}

/**
 * @time O(n ^ 2)
 * @space O(n)
 */
class DPBottomUpJumpGameIISolution {
    public int jump(int[] nums) {
        if (nums.length == 0 || nums.length == 1) {
            return 0;
        }
        int[] memo = new int[nums.length];
        memo[nums.length - 1] = 0;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] == 0) {
                memo[i] = Integer.MAX_VALUE;
                continue;
            }
            int furthestJump = i + nums[i];
            if (furthestJump >= nums.length - 1) {
                memo[i] = 1;
                continue;
            }

            int min = Integer.MAX_VALUE;
            for (int j = i + 1; j <= furthestJump; j++) {
                if (memo[j] < min && memo[j] != 0) {
                    min = memo[j];
                    memo[i] = memo[j] + 1;
                }
            }

        }
        return memo[0];
    }
}

public class JumpGameII {
    public static void main(String[] args) {
        System.out.println(new GreedyJumpGameIISolution().jump(new int[]{
                //5, 9, 3, 2, 1, 0, 2, 3, 3, 1, 0, 0
                2, 3, 1, 1, 4
        }));
    }
}
