package arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class DNA_Sequence_187 {
    public List<String> findRepeatedDnaSequences(String s) {
        if (s.length() < 10)
            return List.of();
        Set<String> set = new HashSet<>();
        Map<String, Integer> charMap = new HashMap<>();
        StringBuilder stringB = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            int charIndex = s.charAt(i) - 'A';
            stringB.append(s.charAt(i));
        }
        charMap.put(stringB.toString(), 1);
        for (int i = 10; i < s.length(); i++) {
            stringB.deleteCharAt(0);
            stringB.append(s.charAt(i));
            String str = stringB.toString();
            if (charMap.containsKey(str)) {
                charMap.put(str, charMap.get(str) + 1);
                set.add(str);
            } else {
                charMap.put(str, 1);
            }
        }
        return new ArrayList<>(set);
    }
}
