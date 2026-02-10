package recursion_dp;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak_139 {
    public boolean check(int index, String s, Set<String> dict, int min, int max, Boolean[] memo) {
        if (index == s.length())
            return true;
        if (index > s.length())
            return false;
        boolean result = false;
        if (memo[index] != null)
            return memo[index];
        for (int i = min; i <= max; i++) {
            if ((index + i) <= s.length()) {
                String target = s.substring(index, index + i);
                if (dict.contains(target)) {
                    boolean status = check(index + i, s, dict, min, max,memo);
                    result = result || status;
                }
            }
        }
        memo[index] = result;
        return result;
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        Set<String> dict = new HashSet<>();
        Boolean[] memo = new Boolean[s.length()];
        for (String str : wordDict) {
            int len = str.length();
            min = Math.min(len, min);
            max = Math.max(len, max);
            dict.add(str);
        }
        return check(0, s, dict, min, max, memo);
    }
}
