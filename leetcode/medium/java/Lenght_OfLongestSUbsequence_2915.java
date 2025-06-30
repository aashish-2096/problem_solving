import java.util.*;;
public class Lenght_OfLongestSUbsequence_2915 {

    public int compute(List<Integer> nums, int target, int index, int[][] dp) {
        if (target == 0)
            return 0;
        if (index >= nums.size() || target < 0)
            return Integer.MIN_VALUE;

        if (dp[index][target] != Integer.MIN_VALUE)
            return dp[index][target];
        int take = compute(nums, target - nums.get(index), index + 1, dp);
        if (take != Integer.MIN_VALUE)
            take += 1;
        int notTake = compute(nums, target, index + 1, dp);
        dp[index][target] = Math.max(take, notTake);
        return dp[index][target];
    }

    public int lengthOfLongestSubsequence(List<Integer> nums, int target) {
        int n = nums.size();
        int[][] dp = new int[n + 1][target + 1];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], Integer.MIN_VALUE);
        }
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 0;
        }
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j <= target; j++) {
                int take = Integer.MIN_VALUE;
                if (j - nums.get(i) >= 0)
                    take = dp[i + 1][j - nums.get(i)];
                if (take != Integer.MIN_VALUE)
                    take += 1;
                int notTake = dp[i + 1][j];
                dp[i][j] = Math.max(take, notTake);
            }
        }
        // int result = compute(nums, target, 0, dp);
        int result = dp[0][target];
        return result == Integer.MIN_VALUE ? -1 : result;
    }

}
