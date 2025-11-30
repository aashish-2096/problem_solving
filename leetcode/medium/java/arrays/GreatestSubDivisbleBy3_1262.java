package arrays;

import java.util.Arrays;

public class GreatestSubDivisbleBy3_1262 {
    public int recursion(int[] nums, int index, int mod, int[][] dp) {
        if (index == nums.length) {
            return mod == 0 ? 0 : Integer.MIN_VALUE;
        }       
        if (dp[index][mod] != Integer.MIN_VALUE) {
            return dp[index][mod];
        }
        int sumTake = mod + nums[index];
        int take = recursion(nums, index + 1, sumTake % 3, dp);
        int noTake = recursion(nums, index + 1, mod, dp);
        if (take != Integer.MIN_VALUE)
            take += nums[index];
        dp[index][mod] = Math.max(take, noTake);
        return dp[index][mod];
    }

    public int maxSumDivThree(int[] nums) {
        int len = nums.length;
        if (len > 0) {
            int[][] dp = new int[len + 1][3];
            for (int i = 0; i < len; i++) {
                Arrays.fill(dp[i], Integer.MIN_VALUE);
            }
            return recursion(nums, 0, 0, dp);
        }
        return 0;
    }
}
