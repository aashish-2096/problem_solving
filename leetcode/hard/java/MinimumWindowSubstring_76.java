package leetcode.hard.java;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring_76 {

    public static Map<Character, Integer> getCharCountMap(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        return map;
    }

    private boolean checkForTargetPresence(Map<Character, Integer> target, Map<Character, Integer> source) {
        boolean allCharsPresent = true;
        for (Map.Entry<Character, Integer> et : target.entrySet()) {
            char key = et.getKey();
            int value = et.getValue();
            int valueSource = source.getOrDefault(key, -1);
            if (valueSource == -1 || value > valueSource) {
                allCharsPresent = false;
                break;
            }
        }
        return allCharsPresent;
    }

    public String minWindow(String s, String t) {
        if (t.length() > s.length()) {
            return "";
        }
        Map<Character, Integer> target = getCharCountMap(t);
        int left = 0, right = 0;
        int leftMin = -1, rightMin = -1;
        int minLength = Integer.MAX_VALUE;
        Map<Character, Integer> inputBuild = new HashMap<>();
        while (right < s.length()) {
            char ch = s.charAt(right);
            inputBuild.put(ch, inputBuild.getOrDefault(ch, 0) + 1);
            while (checkForTargetPresence(target, inputBuild)) {
                int length = right - left + 1;
                if (length < minLength) {
                    leftMin = left;
                    rightMin = right;
                    minLength = length;
                }
                char leftChar = s.charAt(left);
                inputBuild.put(leftChar, inputBuild.getOrDefault(leftChar, 0) - 1);
                if (inputBuild.get(leftChar) <= 0) {
                    inputBuild.remove(leftChar);
                }
                left++;
            }
            right++;
        }
        if (leftMin == -1)
            return "";
        return s.substring(leftMin, rightMin + 1);
    }
}
