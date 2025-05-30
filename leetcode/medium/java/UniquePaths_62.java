public class UniquePaths_62 {
        public int path(int row, int col, int rowMax, int colMax, int dp[][]) {
            if (row == rowMax - 1 && col == colMax - 1) {
                return 1;
            }
            if (row >= rowMax || col >= colMax) {
                return 0;
            }
            if (dp[row][col] != -1) {
                return dp[row][col];
            }
            int left = path(row + 1, col, rowMax, colMax, dp);
            int right = path(row, col + 1, rowMax, colMax, dp);
            dp[row][col] = left + right;
            return dp[row][col];
        }
    
        public int uniquePaths(int m, int n) {
            int dp[][] = new int[m + 1][n + 1];
            // for (int[] arr : dp) {
            //     Arrays.fill(arr, 0);
            // }
            for (int i = m - 1; i >= 0; i--) {
                for (int j = n - 1; j >= 0; j--) {
                    if (i == m - 1 && j == n - 1) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = dp[i + 1][j] + dp[i][j + 1];
                    }
                }
            }
            // dp[0][0] = path(0, 0, m, n, dp);
            return dp[0][0];
        }
}
