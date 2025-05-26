import java.util.HashMap;
import java.util.Map;

public class LongestContanationPalindrome_2131 {
    public int longestPalindrome(String[] words) {
        int count = 0;
        int maxSimilar = 0;
        Map<String, Integer> map = new HashMap<>();
        Map<String, Integer> similar = new HashMap<>();
        for (String word : words) {
            String reversed = new StringBuilder(word).reverse().toString();
            if (word.equalsIgnoreCase(reversed)) {
                similar.computeIfAbsent(word, p -> 0);
                similar.computeIfPresent(word, (p, v) -> v + 1);
            } else if (map.containsKey(reversed)) {
                count += (word.length() * 2);
                if (map.get(reversed) == 1)
                    map.remove(reversed);
                else {
                    map.computeIfPresent(reversed, (p, v) -> v - 1);
                }
            } else if (!map.containsKey(word)) {
                map.put(word, 1);
            } else if (map.containsKey(word)) {
                map.computeIfPresent(word, (p, v) -> v + 1);
            }
        }
        for (Map.Entry<String, Integer> entry : similar.entrySet()) {
            if (entry.getValue() % 2 == 0) {
                count += (entry.getKey().length() * entry.getValue());
            } else {
                int currValue = entry.getValue();
                int wordSize = entry.getKey().length();
                count += (currValue / 2 * wordSize) * 2;
                maxSimilar = Math.max(currValue % 2 * wordSize, maxSimilar);
            }
        }
        return count + maxSimilar;
    }
}
