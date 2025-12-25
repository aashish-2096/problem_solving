package leetcode.hard.java.recursion_dp;

import java.util.Arrays;

public class PaintHouse_265 {
     public int dp(int row, int prevCol, int[][] costs, int[][] dp) {
        int k = costs[0].length;
        if (row >= costs.length)
            return 0;
        int minSum = Integer.MAX_VALUE;
        if (dp[row][prevCol + 1] != -1) {
            return dp[row][prevCol + 1];
        }
        for (int i = 0; i < k; i++) {
            if (i != prevCol || prevCol == -1) {
                minSum = Math.min(costs[row][i] + dp(row + 1, i, costs, dp), minSum);
            }
        }
        dp[row][prevCol + 1] = minSum;
        return minSum;
    }
    public int minCostII(int[][] costs) {
        int row = costs.length;
        int col = costs[0].length;
        int[][] dp = new int[row][col + 1];
        for (int i = 0; i < row; i++) {
            Arrays.fill(dp[i], -1);
        }
        return dp(0, -1, costs, dp);
    }
}
