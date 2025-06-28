public class DeleteTwoStrings_583 {
    public int minDistance(String s, String s1) {
        int l1 = s.length();
        int l2 = s1.length();
        int[][] dp = new int[l1 + 1][l2 + 1];
        for (int i = 1; i <= l1; i++) {
            for (int j = 1; j <= l2; j++) {
                if (s.charAt(i - 1) == s1.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }
        return l1 + l2 - (2 * dp[l1][l2]);
    }
}
