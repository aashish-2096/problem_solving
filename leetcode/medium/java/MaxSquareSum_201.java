public class MaxSquareSum_201 {
    public int maximalSquare(char[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        int maxVal = Integer.MIN_VALUE;
        int[][] dp = new int[row][col];
        for (int i = 0; i < col; i++) {
            if (matrix[0][i] != '0') {
                dp[0][i] = 1;
                maxVal = Math.max(maxVal, dp[0][i]);
            }
        }
        for (int i = 0; i < row; i++) {
            if (matrix[i][0] != '0') {
                dp[i][0] = 1;
                maxVal = Math.max(maxVal, dp[i][0]);
            }
        }
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                int abv = dp[i - 1][j];
                int tleft = dp[i - 1][j - 1];
                int left = dp[i][j - 1];
                int minVal = Math.min(abv, tleft);
                minVal = Math.min(minVal, left);
                if (matrix[i][j] == '1') {
                    dp[i][j] = minVal + 1;
                    maxVal = Math.max(maxVal, dp[i][j]);
                }
            }
        }
        return maxVal == Integer.MIN_VALUE ? 0 : (int) Math.pow(maxVal, 2);
    }
}
