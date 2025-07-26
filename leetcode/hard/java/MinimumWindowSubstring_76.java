package leetcode.hard.java;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring_76 {
    class Solution {
    public static Map<Character, Integer> getCharCountMap(String s) {
        Map<Character, Integer> input = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (!input.containsKey(ch)) {
                input.put(ch, 0);
            }
            input.computeIfPresent(
                ch, (k, v)->{
                    v += 1;
                    return v;
                });
        }
        return input;
    }

    public int minWindow(String s, String t) {
        Map<Character, Integer> input = getCharCountMap(s);
        Map<Character, Integer> target = getCharCountMap(t);
        int left = 0;
        int right = s.length();
        int minLength = s.length();
        boolean leftFreeze = false, rightFreeze = false;
        while (left < right) {
            if (!leftFreeze) {
                char leftChar = s.charAt(left);
                if (target.containsKey(leftChar)) {
                    if (target.get(leftChar) == input.get(leftChar)) {
                        leftFreeze = true;
                    } else if (target.get(leftChar) < input.get(leftChar)) {
                        left++;
                    }
                } else {
                    left++;
                }
            } else if (!rightFreeze) {
                char rightChar = s.charAt(right);
                if (target.containsKey(rightChar)) {
                    if (target.get(rightChar) == input.get(rightChar)) {
                        rightFreeze = true;
                    } else if (target.get(rightChar) < input.get(rightChar)) {
                        right--;
                    }
                } else {
                    right--;
                }
            }
            if (leftFreeze && rightFreeze) {
                minLength = Math.min(minLength, right - left + 1);
                break;
            }
            minLength = Math.min(minLength, right - left + 1);
        }
        return minLength;
    }
};
}
