import java.util.Arrays;

public class Ways2ExpressIntegerAsPowSum_2787 {
    int mod = (int) 1e9 + 7;
    private int countPowers(int n, int target, int pow, int[][] dp) {
        if (target == 0) {
            return 1;
        }
        if (target < 0 || n < 0)
            return 0;
        if (dp[n][target] != -1) {
            return dp[n][target];
        }
        int takenNum = target - (int) Math.pow(n, pow) % mod;
        int take = countPowers(n - 1, takenNum, pow, dp) % mod;
        int noTake = countPowers(n - 1, target, pow, dp) % mod;
        dp[n][target] = (take + noTake) % mod;
        return dp[n][target];
    }

    public int numberOfWays(int n, int x) {
        int nthRoot = (int) Math.pow(n, 1.0 / x) + 1;
        int index = x == 1 ? n : nthRoot + 1;
        int[][] dp = new int[index + 1][n + 1];
        for (int i = 0; i <= index; i++) {
            Arrays.fill(dp[i], -1);
        }
        int pow = x == 1 ? 1 : x;
        return countPowers(index, n, pow, dp);
    }
}
