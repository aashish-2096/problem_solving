package leetcode.easy.java;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class IsomorphicString_205 {
    public boolean isIsomorphic(String s, String t) {
        int sizeL = s.length();
        int sizeR = t.length();
        if (sizeL != sizeR) {
            return false;
        }
        Map<Character, Character> mp = new TreeMap<>();
        boolean status = true;
        Set<Character> st = new TreeSet<>();
        for (int i = 0; i < sizeL; i++) {
            char ch = s.charAt(i);
            char ct = t.charAt(i);
            if (mp.containsKey(ch)) {
                char target = mp.get(ch);
                if (target != ct) {
                    status = false;
                    break;
                }
            } else {
                if (st.contains(ct)) {
                    status = false;
                    break;
                } else {
                    st.add(ct);
                }
                mp.put(ch, ct);

            }
        }
        return status;
    }
}
