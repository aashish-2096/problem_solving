package leetcode.hard.java.recursion_dp;

import java.util.Arrays;

public class BurstBalloon_312 {
    public int burstBalloons(int[] nums, int low, int high, int[][] dp) {
        if (low > high)
            return 0;
        if (dp[low][high] != -1)
            return dp[low][high];
        int maxVal = Integer.MIN_VALUE;
        for (int i = low; i <= high; i++) {
            int left = burstBalloons(nums, low, i - 1, dp);
            int right = burstBalloons(nums, i + 1, high, dp);
            int val = (nums[low - 1] * nums[i] * nums[high + 1])
                    + left + right;
            maxVal = Math.max(val, maxVal);
        }
        dp[low][high] = maxVal;
        return maxVal;
    }

    public int maxCoins(int[] nums) {
        int len = nums.length;
        int[][] dp = new int[len + 2][len + 2];
        for (int i = 0; i <= len; i++) {
            Arrays.fill(dp[i], -1);
        }
        int[] modified = new int[len + 2];
        Arrays.fill(modified, 1);
        for (int i = 0; i < len; i++) {
            modified[i + 1] = nums[i];
        }
        return burstBalloons(modified, 1, len, dp);
    }
}
