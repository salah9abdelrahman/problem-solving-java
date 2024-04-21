package sliding_window;

public class MinimumSizeSubarraySum {
    public static void main(String[] args) {
//        System.out.println(minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3}));
        System.out.println(minSubArrayLen(11, new int[]{1, 2, 3, 4, 5}));
//        System.out.println(minSubArrayLen(15, new int[]{5,1,3,5,10,7,4,9,2,8}));
    }

    static   public int minSubArrayLen(int target, int[] nums) {
        int start = 0, end = 0, minLen = Integer.MAX_VALUE, sum = 0;
        for (end = 0; end < nums.length; end++) {
            sum += nums[end];
            minLen = getMinLen(target, start, end, minLen, sum);
            while (sum > target && start < end) {
                sum -= nums[start];
                start++;
                minLen = getMinLen(target, start, end, minLen, sum);
            }
        }
        end--;
        while (sum >= target && start < end) {
            sum -= nums[start];
            start++;
            minLen = getMinLen(target, start, end, minLen, sum);
        }
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }

    private static int getMinLen(int target, int start, int end, int minLen, int sum) {
        if (sum >= target && end - start + 1 < minLen) {
            minLen = end - start + 1;
        }
        return minLen;
    }

}
