package leetcode.hard.java.recursion_dp;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class WordBreak_140 {
    Set<String> result = new HashSet<>();
    public void check(int index, String s, Set<String> dict, int min, int max, LinkedList<String> linkedList) {
        if (index == s.length()) {
            result.add(String.join(" ", new ArrayList<>(linkedList)));
            return;
        }
        if (index > s.length())
            return;
        for (int i = min; i <= max; i++) {
            if ((index + i) <= s.length()) {
                String target = s.substring(index, index + i);
                if (dict.contains(target)) {
                    linkedList.add(target);
                    check(index + i, s, dict, min, max, linkedList);
                    linkedList.removeLast();
                }
            }
        }
    }

    public List<String> wordBreak(String s, List<String> wordDict) {
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
        LinkedList<String> temp = new LinkedList<>();
        check(0, s, dict, min, max, temp);
        return new ArrayList<>(result);
    }
}
