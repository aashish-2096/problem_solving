public class LongestIncreasingSubSeq_300 {
    
    public int checkLIS(int index, int prevIndex, int[] nums, int[][] dp) {
        if (index >= nums.length)
            return 0;
        if (dp[index][prevIndex + 1] != -1) {
            return dp[index][prevIndex + 1];
        }
        int value = checkLIS(index + 1, prevIndex, nums, dp);
        if (prevIndex == -1 || nums[index] > nums[prevIndex]) {
            value = Math.max(value, 1 + checkLIS(index + 1, index, nums, dp));
        }
        dp[index][prevIndex + 1] = value;
        return dp[index][prevIndex + 1];
    }

    public int lengthOfLIS(int[] nums) {
        int size = nums.length;
        int[][] dp = new int[size + 1][size + 1];
        for (int index = size - 1; index >= 0; index--) {
            for (int prevIndex = index - 1; prevIndex >= -1; prevIndex--) {
                int value = dp[index + 1][prevIndex + 1];
                if (prevIndex == -1 || nums[index] > nums[prevIndex]) {
                    value = Math.max(value, 1 + dp[index + 1][index + 1]);
                }
                dp[index][prevIndex + 1] = value;
            }
        }
        return dp[0][-1 + 1];
    }
}
