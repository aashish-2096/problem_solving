package leetcode.hard.java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubStringContanation_30 {
    class Solution {
    public Map<String, Integer> getAllSplitString(String input, int chunkSize) {
        Map<String, Integer> result = new HashMap<>();
        for (int i = 0; i < input.length(); i += chunkSize) {
            int end = Math.min(i + chunkSize, input.length());
            String str = input.substring(i, end);
            result.put(str, result.getOrDefault(str, 0) + 1);
        }
        return result;
    }

    public boolean containsAll(String str, Map<String, Integer> target, int chunk) {
        Map<String, Integer> st = getAllSplitString(str, chunk);
        boolean contains = true;
        for (Map.Entry<String, Integer> s : target.entrySet()) {
            String key = s.getKey();
            if (!st.containsKey(key) || Integer.compare(st.get(key), s.getValue()) != 0) {
                contains = false;
                break;
            }
        }
        return contains;
    }

    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        int chunkSize = -1;
        if (words.length > 0) {
            chunkSize = words[0].length();
        }
        if (chunkSize == -1 || chunkSize * words.length > s.length()) {
            return result;
        }
        Map<String, Integer> target = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            target.put(words[i], target.getOrDefault(words[i], 0) + 1);
        }
        int reqWindow = chunkSize * words.length;
        int startIndex = 0, endIndex = reqWindow;
        while (endIndex <= s.length()) {
            String st = s.substring(startIndex, endIndex);
            boolean contains = containsAll(st, target, chunkSize);
            if (contains) {
                result.add(startIndex);
            }
            startIndex++;
            endIndex++;
        }
        return result;
    }
}
}
