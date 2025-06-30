public class LongestCommonSubsequence_1143 
    {
        public int check(int l1, int l2, String s1, String s2, int[][] dp) {
            if (l1 < 0 || l2 < 0)
                return 0;
            if (dp[l1][l2] != -1) {
                return dp[l1][l2];
            }
            if (s1.charAt(l1) == s2.charAt(l2)) {
                dp[l1][l2] = 1 + check(l1 - 1, l2 - 1, s1, s2, dp);
            } else {
                dp[l1][l2] = Math.max(check(l1 - 1, l2, s1, s2, dp), check(l1, l2 - 1, s1, s2, dp));
            }
            return dp[l1][l2];
        }
    
        public int longestCommonSubsequence(String text1, String text2) {
            int l1 = text1.length();
            int l2 = text2.length();
            int[][] dp = new int[l1 + 1][l2 + 1];
            // for (int i = 0; i <= l1; i++) {
            //     Arrays.fill(dp[i], 0);
            // }
            for (int i = 1; i <= l1; i++) {
                for (int j = 1; j <= l2; j++) {
                    if (text1.charAt(i-1) == text2.charAt(j-1)) {
                        dp[i][j] = 1 + dp[i - 1][j - 1];
                    } else {
                        dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                    }
                }
            }
            // return check(l1 - 1, l2 - 1, text1, text2, dp);
            return dp[l1][l2];
        }
    }

