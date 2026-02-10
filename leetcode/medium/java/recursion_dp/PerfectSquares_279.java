package recursion_dp;

import java.util.Arrays;

public class PerfectSquares_279 {
    public int countSum(int target, int numRange, int[][] dp) {
        if (target == 0) {
            return 1;
        }
        if (dp[target][numRange] != -1)
            return dp[target][numRange];
        if (numRange <= 0)
            return Integer.MAX_VALUE;
        int currentVal = Integer.MAX_VALUE;
        int prod = (int) Math.pow(numRange, 2);
        if (target >= prod) {
            int result = countSum(target - prod, numRange, dp);
            if (result != Integer.MAX_VALUE) {
                currentVal = Math.min(result + 1, currentVal);
            }
        }
        int result2 = countSum(target, numRange - 1, dp);
        dp[target][numRange] = Math.min(result2, currentVal);
        return dp[target][numRange];
    }

    public int numSquares(int n) {
        int numRange = (int) Math.sqrt(n);
        int[][] dp = new int[n + 1][numRange + 1];
        for (int i = 0; i < n + 1; i++) {
            Arrays.fill(dp[i], -1);
        }
        return countSum(n, numRange, dp) - 1;
    }
}
