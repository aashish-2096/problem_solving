public class CoinChange_518 {
        private int take(int target, int[] coins, int index, int[][] dp) {
            if (index == 0) {
                return target % coins[0] == 0 ? 1 : 0;
            }
            if (dp[index][target] != -1) {
                return dp[index][target];
            }
            int take = 0;
            if (target >= coins[index]) {
                take = take(target - coins[index], coins, index, dp);
            }
            int noTake = take(target, coins, index - 1, dp);
            dp[index][target] = take + noTake;
            return dp[index][target];
        }
    
        public int change(int target, int[] coins) {
            int size = coins.length;
            int[][] dp = new int[size + 1][target + 1];
            // for (int i = 0; i < size; i++) {
            //     Arrays.fill(dp[i], -1);
            // }
            for (int i = 0; i <= target; i++) {
                dp[0][i] = i % coins[0] == 0 ? 1 : 0;
            }
            for (int i = 1; i < size; i++) {
                for (int t = 0; t <= target; t++) {
                    int take = 0;
                    if (t >= coins[i]) {
                        take = dp[i][t - coins[i]];
                    }
                    int noTake = dp[i - 1][t];
                    dp[i][t] = take + noTake;
                }
            }
            //return take(target, coins, size - 1, dp);
            return dp[size - 1][target];
        }
}
