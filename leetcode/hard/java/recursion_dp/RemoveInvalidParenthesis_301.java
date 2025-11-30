package leetcode.hard.java.recursion_dp;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class RemoveInvalidParenthesis_301 {
    Map<Integer, Set<String>> validString = new HashMap<>();
    int minIndex = Integer.MAX_VALUE;

    private void check(String s, int index, String str, Deque<Character> st, int removal) {
        if (index >= s.length()) {
            if (st.isEmpty()) {
                if (!validString.containsKey(removal)) {
                    validString.put(removal, new HashSet<>());
                }
                validString.get(removal).add(str);
                minIndex = Math.min(minIndex, removal);
            }
            return;
        }
        char ch = s.charAt(index);
        if (ch == ')') {
            if (!st.isEmpty() && st.getLast() == '(') {
                String strB = str + ch;
                Deque<Character> st2 = new ArrayDeque<>(st);
                st2.pollLast();
                check(s, index + 1, strB, st2, removal);
            }
            check(s, index + 1, str, st, removal + 1);
        } else if (ch == '(') {
            Deque<Character> st2 = new ArrayDeque<>(st);
            st2.addLast(ch);
            String strB = str + ch;
            check(s, index + 1, strB, st2, removal);
            check(s, index + 1, str, st, removal + 1);
        } else {
            String strB = str + ch;
            check(s, index + 1, strB, st, removal);
        }
    }

    public List<String> removeInvalidParentheses(String s) {
        check(s, 0, "", new ArrayDeque<>(), 0);
        return new ArrayList<>(validString.getOrDefault(minIndex, new HashSet<>()));
    }
}
