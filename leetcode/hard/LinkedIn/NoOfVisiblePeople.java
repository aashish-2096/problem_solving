package leetcode.hard.LinkedIn;

import java.util.Stack;

public class NoOfVisiblePeople {
    public int[] canSeePersonsCount(int[] heights) {
        int len = heights.length;
        int[] res = new int[len];
        Stack<Integer> st = new Stack<>();
        for (int i = len - 1; i >= 0; i--) {
            if (i == len - 1) {
                st.push(heights[i]);
            } else {
                Integer top = st.peek();
                int current = heights[i];
                int count = 0;
                if (current >= top) {
                    while (!st.isEmpty() && st.peek() < current) {
                        st.pop();
                        count++;
                    }
                }
                if (!st.isEmpty()) {
                    count++;
                }
                res[i] = count;
                st.push(heights[i]);
            }
        }
        return res;
    }
}
