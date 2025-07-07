import java.util.Arrays;

public class TargetSum_494 {
    public int compute(int[] nums, int target, int index, int dp[][]) {
        int size = nums.length;
        if (index == size) {
            if (target == 0) {
                return 1;
            }
            return 0;
        }
        int positive = compute(nums, target - nums[index], index + 1, dp);
        int negative = compute(nums, target + nums[index], index + 1, dp);
        return positive + negative;
    }

    public int findTargetSumWays(int[] nums, int target) {
        int size = nums.length;
        int[][] dp = new int[size][2001];
        for (int i = 0; i < size; i++) {
            Arrays.fill(dp[i], -1);
        }
        return compute(nums, target, 0, dp);
    }
}
