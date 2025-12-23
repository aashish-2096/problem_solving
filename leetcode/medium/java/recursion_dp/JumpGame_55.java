package recursion_dp;

import java.util.Arrays;

public class JumpGame_55 {
    private int check(int index, int[] nums, int[] dp) {
        if (index >= nums.length - 1) {
            return 1;
        }
        if (dp[index] != -1) {
            return dp[index];
        }
        int jumpLength = nums[index];
        if (jumpLength <= 0)
            return 0;
        int result = 0;
        for (int i = 1; i <= jumpLength; i++) {
            int jumpIndex = i + index;
            int checkState = check(jumpIndex, nums, dp);
            result += checkState;
            if (result > 0) {
                break;
            }
        }
        dp[index] = result;
        return result;
    }

    public boolean canJump(int[] nums) {
        int length = nums.length;
        if (length == 1)
            return true;
        int[] dp = new int[length];
        Arrays.fill(dp, -1);
        return check(0, nums, dp) > 0;
    }
}
