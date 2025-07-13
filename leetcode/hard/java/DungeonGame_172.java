package leetcode.hard.java;

import java.util.Arrays;

public class DungeonGame_172 {
    class Solution {
    int row = -1, col = -1;
    private int rescue(int x, int y, int[][] matrix, int[][] dp) {
        if (x >= row || y >= col) {
            return Integer.MAX_VALUE;
        }
        if (x == row - 1 && y == col - 1) {
            return Math.max(1, 1 - matrix[x][y]);
        }
        if (dp[x][y] != -1) {
            return dp[x][y];
        }
        int down = rescue(x + 1, y, matrix, dp);
        int right = rescue(x, y + 1, matrix, dp);
        int val = Math.max(1, Math.min(down, right) - matrix[x][y]);
        dp[x][y] = val;
        return dp[x][y];
    }

    public int calculateMinimumHP(int[][] matrix) {
        this.row = matrix.length;
        this.col = matrix[0].length;
        int[][] dp = new int[row][col];
        for (int i = 0; i < row; i++) {
            Arrays.fill(dp[i], -1);
        }
        return rescue(0, 0, matrix, dp);
        }
    }
}
