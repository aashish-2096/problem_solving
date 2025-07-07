import java.util.Arrays;

public class LongestIncreasingSubSeq_300 {
    public int checkLIS(int index, int prevIndex, int[] nums, int[][] dp) {
        if (index >= nums.length)
            return 0;
        int maxState = Integer.MIN_VALUE;
        int maxGrt = Integer.MIN_VALUE, maxNoGrt = Integer.MIN_VALUE;
        if (dp[index][prevIndex + 1] != -1) {
            return dp[index][prevIndex + 1];
        }
        if (prevIndex != -1 && nums[index] > nums[prevIndex]) {
            int take = 1 + checkLIS(index + 1, index, nums, dp);
            int noTake = checkLIS(index + 1, prevIndex, nums, dp);
            maxGrt = Math.max(take, noTake);
        } else {
            int take = Integer.MIN_VALUE;
            if (prevIndex == -1) {
                take = 1 + checkLIS(index + 1, index, nums, dp);
            }
            maxNoGrt = Math.max(take, checkLIS(index + 1, prevIndex, nums, dp));
        }
        maxState = Math.max(maxGrt, maxNoGrt);
        dp[index][prevIndex + 1] = maxState;
        return dp[index][prevIndex + 1];
    }

    public int lengthOfLIS(int[] nums) {
        int size = nums.length;
        int[][] dp = new int[size + 1][size + 1];
        for (int i = 0; i <= size; i++) {
            Arrays.fill(dp[i], -1);
        }
        return checkLIS(0, -1, nums, dp);
    }
}
