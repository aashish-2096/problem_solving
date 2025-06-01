package leetcode.hard.java;

import java.util.Arrays;

public class PathInMatrixDivisbleByK_2435 {
    int m = -1;
    int n = -1;
    int MOD = 1000000007;
    int count = 0;
    public int traverse(int[][] grid, int[][][] dp, int row, int col, int rem, int k) {
        if (row >= this.m || col >= this.n) {
            return 0;
        }
        int newRem = (rem + grid[row][col]) % k;
        if (row == m - 1 && col == n - 1) {
            if (newRem % k == 0) {
                return 1;
            }
            return 0;
        }
        if (dp[row][col][newRem] != -1) {
            return dp[row][col][newRem] % MOD;
        }
        int left = traverse(grid, dp, row + 1, col, newRem, k);
        int right = traverse(grid, dp, row, col + 1, newRem, k);
        dp[row][col][newRem] = (left + right) % MOD;
        return dp[row][col][newRem];
    }

    public int numberOfPaths(int[][] grid, int k) {
        this.m = grid.length;
        this.n = grid[0].length;
        int[][][] dp = new int[m][n][k + 1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }
        return traverse(grid, dp, 0, 0, 0, k);
    }
}
