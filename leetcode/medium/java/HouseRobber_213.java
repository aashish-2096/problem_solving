package leetcode.medium;

public class HouseRobber_213 {
        public int recursion(int[] nums, int[] dp, int index, int takenIndex, int maxEnd) {
            if (takenIndex != -1 && index - takenIndex == 1)
                return 0;
            if (index >= maxEnd)
                return 0;
            if (dp[index] != -1)
                return dp[index];
            int take = nums[index] + recursion(nums, dp, index + 2, index, maxEnd);
            int noTake = recursion(nums, dp, index + 1, takenIndex, maxEnd);
            dp[index] = Math.max(take, noTake);
            return dp[index];
        }
    
        public int rob(int[] nums) {
            int size = nums.length;
            if (size == 0)
                return 0;
            if (size == 1)
                return nums[0];
            int[] dp = new int[size + 1];
            int[] dp2 = new int[size + 1];
            java.util.Arrays.fill(dp, -1);
            java.util.Arrays.fill(dp2, -1);
            recursion(nums, dp, 0, -1, size - 1);
            recursion(nums, dp2, 1, -1, size);
            return Math.max(dp[0], dp2[1]);
        }
}
