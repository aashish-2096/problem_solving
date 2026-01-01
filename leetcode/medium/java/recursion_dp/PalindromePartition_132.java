package recursion_dp;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PalindromePartition_132 {
    boolean isPalindrome(String s) {
        int start = 0, end = s.length() - 1;
        boolean isTrue = true;
        while (start <= end) {
            if (s.charAt(start) == s.charAt(end)) {
                start++;
                end--;
            } else {
                isTrue = false;
                break;
            }
        }
        return isTrue;
    }

    public Set<List<String>> partitionCheck(String s) {
        if (s.length() == 1) {
            List<String> inner = new ArrayList<>();
            inner.add(s);
            Set<List<String>> result = new HashSet<>();
            result.add(inner);
            return result;
        }
        Set<List<String>> result = new HashSet<>();
        if (isPalindrome(s)) {
            List<String> tp = new ArrayList<>();
            tp.add(s);
            result.add(tp);
        }
        for (int i = 1; i < s.length(); i++) {
            String s1 = s.substring(0, i);
            String s2 = s.substring(i);
            boolean isPalindromeFirst = isPalindrome(s1);
            if (!isPalindromeFirst)
                continue;
            Set<List<String>> res2 = partitionCheck(s2);
            for (List<String> r2 : res2) {
                List<String> first = new ArrayList<>();
                first.add(s1);
                first.addAll(r2);
                result.add(first);
            }
        }
        return result;
    }

    public List<List<String>> partition(String s) {
        Set<List<String>> result = partitionCheck(s);
        List<List<String>> rp = new ArrayList<>();
        for (var item : result) {
            rp.add(item);
        }
        return rp;
    }
}
