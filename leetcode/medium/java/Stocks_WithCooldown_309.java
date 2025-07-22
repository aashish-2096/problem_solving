import java.util.Arrays;

public class Stocks_WithCooldown_309 {
    public int compute(int[] prices, int index, int buy, int[][] dp) {
        if (index >= prices.length) {
            return 0;
        }
        if (dp[index][buy] != -1) {
            return dp[index][buy];
        }
        int sell = -1, by = -1;
        if (buy == 1) {
            sell = prices[index] + compute(prices, index + 2, Math.abs(buy - 1), dp);
            int noSell = 0 + compute(prices, index + 1, buy, dp);
            sell = Math.max(sell, noSell);
        } else {
            by = -prices[index] + compute(prices, index + 1, Math.abs(buy - 1), dp);
            int noBuy = compute(prices, index + 1, buy, dp);
            by = Math.max(by, noBuy);
        }
        dp[index][buy] = Math.max(sell, by);
        return dp[index][buy];
    }

    public int maxProfit(int[] prices) {
        int size = prices.length;
        if (size <= 1) {
            return 0;
        }
        int[][] dp = new int[size + 1][3];
        for (int i = 0; i <= size; i++) {
            Arrays.fill(dp[i], -1);
        }
        return compute(prices, 0, 0, dp);
    }
}
