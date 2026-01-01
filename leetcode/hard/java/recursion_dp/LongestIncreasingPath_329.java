package leetcode.hard.java.recursion_dp;

import java.util.Arrays;

public class LongestIncreasingPath_329 {
    boolean validIndex(int i, int j, int[][] matrix) {
        return i >= 0 && j >= 0 && i < matrix.length && j < matrix[0].length;
    }

    int maxPath(int i, int j, int[][] matrix, int[][] dp) {
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        int left = 0, right = 0, top = 0, bottom = 0;
        int current = matrix[i][j];
        if (validIndex(i + 1, j, matrix) && matrix[i + 1][j] > current) {
            left = maxPath(i + 1, j, matrix, dp);
        }
        if (validIndex(i - 1, j, matrix) && matrix[i - 1][j] > current) {
            right = maxPath(i - 1, j, matrix, dp);
        }
        if (validIndex(i, j + 1, matrix) && matrix[i][j + 1] > current) {
            top = maxPath(i, j + 1, matrix, dp);
        }
        if (validIndex(i, j - 1, matrix) && matrix[i][j - 1] > current) {
            bottom = maxPath(i, j - 1, matrix, dp);
        }
        int maxPresent = 1 + Math.max(Math.max(left, right), Math.max(top, bottom));
        dp[i][j] = maxPresent;
        return dp[i][j];
    }

    public int longestIncreasingPath(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        int maxValue = Integer.MIN_VALUE;
        int[][] dp = new int[row][col];
        for (int i = 0; i < row; i++) {
            Arrays.fill(dp[i], -1);
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int value = maxPath(i, j, matrix, dp);
                maxValue = Math.max(maxValue, value);
            }
        }
        return maxValue;
    }
}
