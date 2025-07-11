package leetcode.hard.java;

import java.util.Stack;

public class LargestRectangleArea_84 {
    public int largestRectangleArea(int[] height) {
        int maxArea = 0;
        if (height.length == 0) {
            return maxArea;
        }
        int[] heights = new int[height.length + 1];
        for (int i = 0; i < height.length; i++) {
            heights[i] = height[i];
        }
        heights[height.length] = 0;
        Stack<Integer> st = new Stack<>();
        st.push(-1);
        for (int i = 0; i < heights.length; i++) {
            while (st.peek() != -1 && heights[i] < heights[st.peek()]) {
                int ht = heights[st.pop()];
                int wt = i - st.peek() - 1;
                maxArea = Math.max(maxArea, ht * wt);
            }
            st.push(i);
        }
        return maxArea;
    }
}
