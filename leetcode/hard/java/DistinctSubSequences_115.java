package leetcode.hard.java;
import java.util.Arrays;
public class DistinctSubSequences_115 {
     int helper(int indL, int indR, String s, String t, int[][] dp) {
        if (indR == 0) {
            return 1;
        }
        if (indL < 0) {
            return 0;
        }
        if (dp[indL][indR] != -1) {
            return dp[indL][indR];
        }
        int op1 = 0, op2 = 0, op3 = 0;
        if (indL >= 1 && indR >= 1 && s.charAt(indL - 1) == t.charAt(indR - 1)) {
            op1 = helper(indL - 1, indR - 1, s, t, dp);
            op2 = helper(indL - 1, indR, s, t, dp);
        } else {
            op3 = helper(indL - 1, indR, s, t, dp);
        }
        int value = op1 + op2 + op3;
        dp[indL][indR] = value;
        return value;

    }

    public int numDistinct(String s, String t) {
        int indL = s.length();
        int indR = t.length();
        int[][] dp = new int[indL + 1][indR + 1];
        for (int i = 0; i <= indL; i++) {
            Arrays.fill(dp[i], -1);
        }
        return helper(indL, indR, s, t, dp);
    }
}
