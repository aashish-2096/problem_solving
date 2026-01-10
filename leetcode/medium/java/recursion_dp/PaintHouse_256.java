package recursion_dp;

import java.util.Arrays;

public class PaintHouse_256 {
    public int dp(int row, int prevCol, int[][] costs, int[][] dp) {
        if (row >= costs.length)
            return 0;
        int minSum = Integer.MAX_VALUE;
        if (dp[row][prevCol + 1] != -1) {
            return dp[row][prevCol + 1];
        }
        for (int i = 0; i < 3; i++) {
            if (i != prevCol || prevCol == -1) {
                minSum = Math.min(costs[row][i] + dp(row + 1, i, costs, dp), minSum);
            }
        }
        dp[row][prevCol + 1] = minSum;
        return minSum;
    }

    public int minCost(int[][] costs) {
        int row = costs.length;
        int[][] dp = new int[row][3 + 1];
        for (int i = 0; i < row; i++) {
            Arrays.fill(dp[i], -1);
        }
        return dp(0, -1, costs, dp);
    }
}
