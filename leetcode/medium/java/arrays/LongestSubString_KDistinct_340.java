package arrays;

import java.util.HashMap;
import java.util.Map;

public class LongestSubString_KDistinct_340 {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if (k == 0 || s.length() <= 0) {
            return 0;
        }
        int maxLen = Integer.MIN_VALUE;
        Map<Integer, Integer> charMap = new HashMap<>();
        int start = 0;
        for (int i = 0; i < s.length(); i++) {
            int ch = s.charAt(i) - 'a';
            if (i == 0) {
                charMap.put(ch, 1);
                start = i;
            } else {
                if (charMap.containsKey(ch)) {
                    charMap.put(ch, charMap.get(ch) + 1);
                } else {
                    charMap.put(ch, 1);
                }
                int size = charMap.size();
                if (size > k) {
                    int initialChar = s.charAt(start) - 'a';
                    while (size > k && charMap.containsKey(initialChar)) {
                        int count = charMap.get(initialChar);
                        if (count > 1) {
                            charMap.put(initialChar, count - 1);
                        } else {
                            charMap.remove(initialChar);
                            size--;
                        }
                        start++;
                        if (start < s.length()) {
                            initialChar = s.charAt(start) - 'a';
                        }
                    }
                }
            }
            int diff = i - start + 1;
            maxLen = Math.max(diff, maxLen);
        }
        return maxLen;
    }
}
