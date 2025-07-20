import java.util.Arrays;

public class Editdistance_72 {
    class Solution {
    int helper(int indL, int indR, String s, String t, int[][] dp) {
        if (indL == 0)
            return indR;
        if (indR == 0)
            return indL;
        if (dp[indL][indR] != -1) {
            return dp[indL][indR];
        }
        int op1 = Integer.MAX_VALUE, op2 = Integer.MAX_VALUE, op3 = Integer.MAX_VALUE, op4 = Integer.MAX_VALUE;
    if (indL >= 1 && indR >= 1 && s.charAt(indL - 1) == t.charAt(indR - 1)) {
            // match
            op1 = helper(indL - 1, indR - 1, s, t, dp);
        } else {
            // insertion
            op2 = 1 + helper(indL, indR - 1, s, t, dp);
            // deletion
            op3 = 1 + helper(indL - 1, indR, s, t, dp);
            //swap
            op4 = 1 + helper(indL - 1, indR - 1, s, t, dp);
        }
        int value = Math.min(op1, op2);
        dp[indL][indR] = Math.min(value, Math.min(op3, op4));
        return dp[indL][indR];
    }

    public int minDistance(String s, String t) {
        int indL = s.length();
        int indR = t.length();
        if (indL == 0) {
            return indR;
        }
        if (indR == 0) {
            return indL;
        }
        int[][] dp = new int[indL + 1][indR + 1];
        for (int i = 0; i <= indL; i++) {
            Arrays.fill(dp[i], -1);
        }
        return helper(indL, indR, s, t, dp);
    }
}
}
