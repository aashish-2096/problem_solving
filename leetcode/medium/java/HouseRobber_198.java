package leetcode.medium;
public class HouseRobber_198 {
        public int recursion(int[] nums, int[] dp, int index, int takenIndex) {
            int size = nums.length;
            if (takenIndex != -1 && index - takenIndex == 1)
                return 0;
            if (index >= size)
                return 0;
            if (dp[index] != -1)
                return dp[index];
            int take = nums[index] + recursion(nums, dp, index + 2, index);
            int noTake = recursion(nums, dp, index + 1, takenIndex);
            dp[index] = Math.max(take, noTake);
            return dp[index];
        }
    
        public int rob(int[] nums) {
            int size = nums.length;
            if (size == 0)
                return 0;
            int[] dp = new int[size + 2];
            java.util.Arrays.fill(dp, -1);
            //recursion(nums, dp, 0, -1);
            dp[size] = 0;
            dp[size+1] = 0;
            for (int i = size-1; i >= 0; i--) {
                int take =  nums[i] + dp[i+2];
                int noTake = dp[i+1];
                dp[i] = Math.max(take, noTake);
            }
            return dp[0];
        }
}
