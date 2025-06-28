public class LongestPalindromSubSequence_516 {
    public int longestPalindromeSubseq(String s) {
        int l1 = s.length();
        int l2 = s.length();
        String s1 = new StringBuilder(s).reverse().toString();
        int[][] dp = new int[l1 + 1][l2 + 1];
        int maxVal = 0;
        for (int i = 1; i <= l1; i++) {
            for (int j = 1; j <= l2; j++) {
                if (s.charAt(i - 1) == s1.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
                maxVal = Math.max(maxVal, dp[i][j]);
            }
        }
        return maxVal;
    }
}
