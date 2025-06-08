package leetcode.medium;

import java.util.Arrays;

public class Target_Sum_494_Memoization {
    int result = -1;
    public int compute(int[] nums, int target, int index, int dp[][]) {
        int size = nums.length;
        if (index == size) {
            if (target == result + 1000) {
                return 1;
            }
            return 0;
        }
        if (target < 0 || target > 2001)
            return 0;
        if (dp[index][target] != -1) {
            return dp[index][target];
        }
        int positive = compute(nums, target - nums[index], index + 1, dp);
        int negative = compute(nums, target + nums[index], index + 1, dp);
        dp[index][target] = positive + negative;
        return dp[index][target];
    }
    public int findTargetSumWays(int[] nums, int target) {
        int size = nums.length;
        result = target;
        int[][] dp = new int[size][2001];
        for (int i = 0; i < size; i++) {
            Arrays.fill(dp[i], -1);
        }
        return compute(nums, 1000, 0, dp);
    }
}
