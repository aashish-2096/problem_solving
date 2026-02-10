package recursion_dp;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class DecodeString_92 {
    Set<String> stringLen = new HashSet<>();
    int count = 0;

    public void decodeStringTrackString(int index, String s, LinkedList<Character> temp) {
        if (index == s.length()) {
            StringBuilder sb = new StringBuilder();
            for (char c : temp) {
                sb.append(c);
            }
            //System.out.println("StringTarget" + sb.toString());
            stringLen.add(sb.toString());
            return;
        }
        char ch = s.charAt(index);
        boolean consumed = false;
        if (ch != '0') {
            int val = 'A' + (ch - '0') - 1;
            temp.add((char) val);
            decodeStringTrackString(index + 1, s, temp);
            temp.removeLast();
        }

        if (index + 1 < s.length()) {
            int intVal = ((ch - '0') * 10) + (s.charAt(index + 1) - '0');
            if (intVal >= 10 && intVal <= 26) {
                int target = 'A' + (intVal - 1);
                temp.add((char) target);
                decodeStringTrackString(index + 2, s, temp);
                temp.removeLast();
            }
        }
    }

    public int decode(int index, String s, int[] dp) {
        if (index == s.length()) {
            count++;
            return 1;
        }
        if (index > s.length())
            return 0;
        if (dp[index] != -1)
            return dp[index];
        char ch = s.charAt(index);
        int one = 0, two = 0;
        if (index + 1 < s.length()) {
            int num = (ch - '0') * 10 + s.charAt(index + 1) - '0';
            if (num >= 10 && num <= 26) {
                two = decode(index + 2, s, dp);
            }
        }
        if (ch != '0') {
            one = decode(index + 1, s, dp);
        }
        dp[index] = one + two;
        return dp[index];
    }

    public int numDecodings(String s) {
        if (s.isEmpty() || s.charAt(0) == '0')
            return 0;
        int len = s.length();
        int[] dp = new int[len];
        Arrays.fill(dp, -1);
        return decode(0, s, dp);
    }
}
