// https://leetcode.com/problems/jump-game/description/
package greedy;

public class JumpGame {
    public static void main(String[] args) {
//        System.out.println(new JumpGameGreedySolution().canJump(new int[]{3, 2, 2, 1, 1, 0, 1}));
//        System.out.println(new JumpGameDPBottomUpSolution().canJump(new int[]{3, 2, 2, 1, 1, 0, 1}));
        System.out.println(new JumpGameDPBottomUpSolution().canJump(new int[]{2, 3, 1, 1, 4}));
    }
}

enum JumpGameIndex {
    GOOD,
    BAD,
    UNKNOWN,
}

/**
 * @time o(n ^ 2)
 * @space o(n)
 */
class JumpGameDPTopDownSolution {
    JumpGameIndex[] memo;

    public boolean canJump(int[] nums) {
        memo = new JumpGameIndex[nums.length];
        for (int i = 0; i < memo.length; i++) {
            memo[i] = JumpGameIndex.UNKNOWN;
        }
        memo[memo.length - 1] = JumpGameIndex.GOOD;
        return canJumpFromPosition(0, nums);
    }

    public boolean canJumpFromPosition(int position, int[] nums) {
        if (memo[position] != JumpGameIndex.UNKNOWN) {
            return memo[position] == JumpGameIndex.GOOD ? true : false;
        }

        int furthestJump = Math.min(position + nums[position], nums.length - 1);
        for (
                int nextPosition = position + 1;
                nextPosition <= furthestJump;
                nextPosition++
        ) {
            if (canJumpFromPosition(nextPosition, nums)) {
                memo[position] = JumpGameIndex.GOOD;
                return true;
            }
        }

        memo[position] = JumpGameIndex.BAD;
        return false;
    }
}

/**
 * @time o(n ^ 2)
 * @space o(n)
 */
class JumpGameDPBottomUpSolution {

    public boolean canJump(int[] nums) {
        JumpGameIndex[] memo = new JumpGameIndex[nums.length];
        for (int i = 0; i < memo.length; i++) {
            memo[i] = JumpGameIndex.UNKNOWN;
        }
        memo[memo.length - 1] = JumpGameIndex.GOOD;

        for (int i = nums.length - 2;
             i >= 0;
             i--) {
            int furthestJump = Math.min(i + nums[i], nums.length - 1);
            for (int j = i + 1;
                 j <= furthestJump;
                 j++) {
                if (memo[j] == JumpGameIndex.GOOD) {
                    memo[i] = JumpGameIndex.GOOD;
                    break;
                }
            }
        }

        return memo[0] == JumpGameIndex.GOOD;
    }

}

/**
 * @time o(n)
 * @space o(1)
 */
class JumpGameGreedySolution {
    public boolean canJump(int[] nums) {
        int lastPos = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (i + nums[i] >= lastPos) {
                lastPos = i;
            }
        }
        return lastPos == 0;
    }
}