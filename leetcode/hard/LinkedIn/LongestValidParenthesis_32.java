package leetcode.hard.LinkedIn;

import java.util.Stack;

public class LongestValidParenthesis_32 {
    public int longestValidParentheses(String s) {
        int maxLen = 0;
        Stack<Integer> st = new Stack<>();
        st.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                st.push(i);
            } else {
                st.pop();
                if (!st.isEmpty()) {
                    int diff = i - st.peek();
                    maxLen = Math.max(diff, maxLen);
                } else {
                    st.push(i);
                }
            }
        }
        return maxLen;
    }
}
