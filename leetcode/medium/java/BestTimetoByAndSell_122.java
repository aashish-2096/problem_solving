import java.util.Arrays;

public class BestTimetoByAndSell_122 {
    public int recursion(int[] prices, int index, int buy, int[][] dp) {
        if (index == prices.length) {
            return 0;
        }
        if (dp[index][buy] != -1) {
            return dp[index][buy];
        }
        int by = Integer.MIN_VALUE, sell = Integer.MIN_VALUE;
        if (buy == 0) {
            by = -prices[index] + recursion(prices, index + 1, Math.abs(buy - 1), dp);
            int noBuy = recursion(prices, index + 1, buy, dp);
            by = Math.max(by, noBuy);
        } else {
            sell = prices[index] + recursion(prices, index + 1, Math.abs(buy - 1), dp);
            int noSell = recursion(prices, index + 1, buy, dp);
            sell = Math.max(sell, noSell);
        }
        dp[index][buy] = Math.max(by, sell);
        return dp[index][buy];
    }

    public int maxProfit(int[] prices) {
        int size = prices.length;
        int[][] dp = new int[size + 1][2];
        for(int i = 0;i<=size;i++){
            Arrays.fill(dp[i],-1);
        }
        return recursion(prices, 0, 0, dp);
    }
}
