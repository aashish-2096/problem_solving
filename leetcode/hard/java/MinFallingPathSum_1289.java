package leetcode.hard.java;

import java.util.Arrays;
/**
 * Top Down Solution
 */
public class MinFallingPathSum_1289 {
     int row = -1, col = -1;
    private int minFallPathSum(int x, int y, int[][] matrix, int[][] dp) {
        if (x >= row || y >= col || x < 0 || y < 0) {
            return Integer.MAX_VALUE;
        }
        if (dp[x][y] != Integer.MAX_VALUE) {
            return dp[x][y];
        }
        if (x == row - 1) {
            dp[x][y] = matrix[x][y];
            return matrix[x][y];
        }
        int maxValInd = Integer.MAX_VALUE;
        for (int i = 0; i < col; i++) {
            if (i != y) {
                int num = minFallPathSum(x + 1, i, matrix, dp);
                maxValInd = Math.min(maxValInd, num);
            }
        }
        dp[x][y] = matrix[x][y] + maxValInd;
        return dp[x][y];
    }

    public int minFallingPathSum(int[][] matrix) {
        this.row = matrix.length;
        this.col = matrix[0].length;
        int[][] dp = new int[row][col];
        for (int i = 0; i < row; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        int minValue = Integer.MAX_VALUE;
        for (int i = 0; i < col; i++) {
            int value = minFallPathSum(0, i, matrix, dp);
            minValue = Math.min(minValue, value);
        }
        return minValue;
    }
}
