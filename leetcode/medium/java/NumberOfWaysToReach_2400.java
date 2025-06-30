import java.util.Arrays;

public class NumberOfWaysToReach_2400 {
    int MOD = 1000000007;
    int offset = 1000;
    int paths(int k, int currentPos, int steps, int[][] dp) {
        if (Math.abs(currentPos) > dp[0].length / 2) return 0; 
        if (steps > k)
            return 0;
        if (steps == k) {
            return currentPos == 0 ? 1 : 0;
        }
        if (dp[steps][currentPos + offset] != -1)
            return dp[steps][currentPos + offset];
        int leftMove = paths(k, currentPos - 1, steps + 1, dp) % MOD;
        int rightMove = paths(k, currentPos + 1, steps + 1, dp) % MOD;
        dp[steps][currentPos + offset] = (leftMove + rightMove) % MOD;
        return dp[steps][currentPos + offset];
    }

    public int numberOfWays(int startPos, int endPos, int k) {
        int[][] dp = new int[k + 1][2 * offset + 1];
        for (int[] line : dp) {
            Arrays.fill(line, -1);
        }
        return paths(k, endPos - startPos, 0, dp);
    }
}
