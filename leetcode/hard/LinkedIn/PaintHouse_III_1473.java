package leetcode.hard.LinkedIn;

import java.util.Arrays;

public class PaintHouse_III_1473 {
    public int dp(int[] houses, int[][] cost, int target, int index, int colorIndex, int[][][] dp) {
        int m = cost.length;
        int n = cost[0].length;
        if (index == m && target == 0) {
            return 0;
        }
        if (target < 0 || index >= m)
            return Integer.MAX_VALUE;
        int minValue = Integer.MAX_VALUE;
        if (dp[index][colorIndex][target] != -1)
            return dp[index][colorIndex][target];
        // case of already painted house
        if (houses[index] != 0) {
            int updatedTarget = target;
            if (houses[index] != colorIndex) {
                updatedTarget--;
            }
            int trackVal = dp(houses, cost, updatedTarget, index + 1, houses[index], dp);
            if (trackVal != Integer.MAX_VALUE)
                minValue = Math.min(trackVal, minValue);
        }
        // initiate painting, new stuff
        else
            for (int i = 1; i <= n; i++) {
                int effectiveTarget = (i == colorIndex) ? target : target - 1;
                int iterCost = dp(houses, cost, effectiveTarget, index + 1, i, dp);
                if (iterCost != Integer.MAX_VALUE) {
                    minValue = Math.min(iterCost + cost[index][i - 1], minValue);
                }
            }
        return dp[index][colorIndex][target] = minValue;

    }

    public int minCost(int[] houses, int[][] cost, int m, int n, int target) {
        int[][][] dp = new int[m + 1][n + 1][target + 1];
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }
        int res = dp(houses, cost, target, 0, 0, dp);
        return res == Integer.MAX_VALUE ? -1 : res;
    }
}
