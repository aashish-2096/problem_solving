package leetcode.hard.java;

public class ShortestCommon_SuperSeq_1092 {
        public String longestCommonSubsequence(String text1, String text2) {
            int l1 = text1.length();
            int l2 = text2.length();
            int[][] dp = new int[l1 + 1][l2 + 1];
            for (int i = 1; i <= l1; i++) {
                for (int j = 1; j <= l2; j++) {
                    if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                        dp[i][j] = 1 + dp[i - 1][j - 1];
                    } else {
                        dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                    }
                }
            }
            int left = l1, right = l2;
            String result = "";
            while (left >= 0 && right >= 0) {
                if (left >= 1 && right >= 1 && text1.charAt(left - 1) == text2.charAt(right - 1)) {
                    result = text1.charAt(left - 1) + result;
                    left--;
                    right--;
                } else if (left >= 1 && dp[left][right] == dp[left - 1][right]) {
                    result = text1.charAt(left - 1) + result;
                    left--;
                } else {
                    if (right >= 1)
                        result = text2.charAt(right - 1) + result;
                    right--;
                }
            }
    
            while (left > 0) {
                result = text1.charAt(left - 1) + result;
                left--;
            }
            while (right > 0) {
                result = text2.charAt(right - 1) + result;
                right--;
            }
            return result;
        }
    
        public String shortestCommonSupersequence(String str1, String str2) {
            return longestCommonSubsequence(str1, str2);
        }
    
}
