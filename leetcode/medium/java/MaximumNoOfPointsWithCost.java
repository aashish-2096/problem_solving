import java.util.Arrays;

public class MaximumNoOfPointsWithCost {
    int row = -1, col = -1;

    private long maxPointCost(int x, int y, int[][] points, long[][] dp) {
        if (x > row || y > col) {
            return -1;
        }
        if (x == row - 1) {
            return points[x][y];
        }
        if (dp[x][y] != -1) {
            return dp[x][y];
        }
        long maxValInd = Long.MIN_VALUE;
        for (int i = 0; i < col; i++) {
            long val = maxPointCost(x + 1, i, points, dp) - Math.abs(y - i);
            maxValInd = Math.max(maxValInd, val);
        }
        dp[x][y] = points[x][y] + maxValInd;
        return dp[x][y];
    }

    public long maxPoints(int[][] points) {
        row = points.length;
        col = points[0].length;
        long[][] dp = new long[row][col];
        for (int i = 0; i < row; i++) {
            Arrays.fill(dp[i], Integer.MIN_VALUE);
        }
        long maxValue = Integer.MIN_VALUE;
        for (int i = 0; i < col; i++) {
            dp[row - 1][i] = points[row - 1][i];
            maxValue = Math.max(maxValue, dp[row - 1][i]);
        }
        long[] prev = new long[col];
        for (int i = 0; i < col; i++) {
            prev[i] = points[row - 1][i];
        }
        // for (int i = 0; i < col; i++) {
        //     long val = maxPointCost(0, i, points, dp);
        //     maxValue = Math.max(maxValue, val);
        // }

        for (int i = row - 2; i >= 0; i--) {
            long[] left = new long[col];
            long[] right = new long[col];
            long[] curr = new long[col];
            left[0] = prev[0];
            for (int j = 1; j < col; j++) {
                left[j] = Math.max(left[j - 1] - 1, prev[j]);
            }
            right[col - 1] = prev[col - 1];
            for (int j = col - 2; j >= 0; j--) {
                right[j] = Math.max(right[j + 1] - 1, prev[j]);
            }
            for (int j = 0; j < col; j++) {
                curr[j] = points[i][j] + Math.max(left[j], right[j]);
            }
            prev = curr;
        }
        for (int i = 0; i < col; i++) {
            maxValue = Math.max(prev[i], maxValue);
        }
        return maxValue;
    }
}
