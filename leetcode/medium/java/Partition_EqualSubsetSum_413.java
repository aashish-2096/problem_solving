import java.util.Arrays;

public class Partition_EqualSubsetSum_413 {
    private boolean partition(int index, int[] nums, int[][] dp, int target) {
        if (index < 0 || target < 0)
            return false;
        if (target == 0)
            return true;
        if (index == 0) {
            return nums[index] == target;
        }
        if (dp[index][target] != -1)
            return dp[index][target] == 1;
        boolean take = partition(index - 1, nums, dp, target - nums[index]);
        boolean noTake = partition(index - 1, nums, dp, target);
        dp[index][target] = (take || noTake) == true ? 1 : 0;
        return dp[index][target] == 1;
    }

    public boolean canPartition(int[] nums) {
        int size = nums.length;
        int sum = 0;
        for (int i : nums) {
            sum += i;
        }
        if (sum % 2 != 0)
            return false;
        int value = sum / 2;
        int[][] dp = new int[size][value + 1];
        boolean[][] dp2 = new boolean[size][value + 1];
        for (int i = 0; i < size; i++) {
            Arrays.fill(dp[i], -1);
        }
        for (int i = 0; i < size; i++)
            dp2[i][0] = true;

        if (nums[0] == value)
            dp2[0][nums[0]] = true;
        for (int i = 1; i < size; i++) {
            for (int target = 1; target <= value; target++) {
                boolean noTake = dp2[i - 1][target];
                boolean take = false;
                if (target - nums[i] >= 0)
                    take = dp2[i - 1][target - nums[i]];
                dp2[i][target] = noTake || take;
            }
        }
        return dp2[size - 1][value];
        //  return partition(size - 1, nums, dp, value); memoization
    }
}
