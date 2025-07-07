import java.util.Arrays;

public class StocksWithTransactionFee_714 {
    public int compute(int[] prices, int index, int buy, int[][] dp, int fee) {
        if (index >= prices.length) {
            return 0;
        }
        if (dp[index][buy] != -1) {
            return dp[index][buy];
        }
        int sell = -1, by = -1;
        if (buy == 1) {
            sell = prices[index] + compute(prices, index + 1, Math.abs(buy - 1), dp, fee) - fee;
            int noSell = 0 + compute(prices, index + 1, buy, dp, fee);
            sell = Math.max(sell, noSell);
        } else {
            by = -prices[index] + compute(prices, index + 1, Math.abs(buy - 1), dp, fee);
            int noBuy = compute(prices, index + 1, buy, dp, fee);
            by = Math.max(by, noBuy);
        }
        dp[index][buy] = Math.max(sell, by);
        return dp[index][buy];
    }

    public int maxProfit(int[] prices, int fee) {
        int size = prices.length;
        if (size <= 1) {
            return 0;
        }
        int[][] dp = new int[size + 1][3];
        for (int i = 0; i <= size; i++) {
            Arrays.fill(dp[i], -1);
        }
        return compute(prices, 0, 0, dp, fee);
    }
}
