public class MinPathSum_64 {
    int minSum(int i, int j, int[][] grid, int[][] dp) {
        int row = grid.length;
        int col = grid[0].length;
        if (i >= row || j >= col) {
            return Integer.MAX_VALUE;
        }
        if (i == row - 1 && j == col - 1) {
            return grid[i][j];
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        int down = minSum(i + 1, j, grid, dp);
        int right = minSum(i, j + 1, grid, dp);
        dp[i][j] = Math.min(down, right) + grid[i][j];
        return dp[i][j];
    }

    public int minPathSum(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int[][] dp = new int[row + 1][col + 1];
        dp[row - 1][col - 1] = grid[row - 1][col - 1];
        for (int i = 0; i <= col; i++) {
            dp[row][i] = Integer.MAX_VALUE;
        }
        for (int i = 0; i <= row; i++) {
            dp[i][col] = Integer.MAX_VALUE;
        }
        for (int i = row - 1; i >= 0; i--) {
            for (int j = col - 1; j >= 0; j--) {
                if (i == row - 1 && j == col - 1) {
                    continue;
                }
                int down = dp[i + 1][j];
                int right = dp[i][j + 1];
                dp[i][j] = Math.min(down, right) + grid[i][j];
            }
        }
        int[] dp2 = new int[col + 1];
        for (int i = row - 1; i >= 0; i--) {
            for (int j = col - 1; j >= 0; j--) {
                if (i == row - 1 && j == col - 1) {
                    dp2[j] = grid[i][j];
                } else if (i == row - 1) {
                    dp2[j] = dp2[j + 1] + grid[i][j];
                } else if (j == col - 1) {
                    dp2[j] = dp2[j] + grid[i][j];
                } else {
                    dp2[j] = Math.min(dp2[j], dp2[j + 1]) + grid[i][j];
                }
            }
        }
        return dp2[0];
    }
}
