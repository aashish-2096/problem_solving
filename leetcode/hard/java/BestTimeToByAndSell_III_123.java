package leetcode.hard.java;
import java.util.Arrays;

public class BestTimeToByAndSell_III_123 {
    public int recursion(int[] prices, int index, int buy, int[][][] dp, int cap) {
        if (cap == 0) {
            return 0;
        }
        if (index == prices.length) {
            return 0;
        }
        if (dp[index][buy][cap] != -1) {
            return dp[index][buy][cap];
        }
        int by = Integer.MIN_VALUE, sell = Integer.MIN_VALUE;
        if (buy == 0) {
            by = -prices[index] + recursion(prices, index + 1, Math.abs(buy - 1), dp, cap);
            int noBuy = recursion(prices, index + 1, buy, dp, cap);
            by = Math.max(by, noBuy);
        } else {
            sell = prices[index] + recursion(prices, index + 1, Math.abs(buy - 1), dp, cap - 1);
            int noSell = recursion(prices, index + 1, buy, dp, cap);
            sell = Math.max(sell, noSell);
        }
        dp[index][buy][cap] = Math.max(by, sell);
        return dp[index][buy][cap];
    }

    public int maxProfit(int[] prices) {
        int size = prices.length;
        int[][][] dp = new int[size + 1][3][3];
        for (int i = 0; i <= size; i++) {
            for (int j = 0; j <= 2; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }
        return recursion(prices, 0, 0, dp, 2);
    }
}
