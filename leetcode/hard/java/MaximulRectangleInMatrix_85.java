package leetcode.hard.java;

import java.util.Stack;

public class MaximulRectangleInMatrix_85 {
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

    public int maximalRectangle(char[][] matrix) {
        int row = matrix.length;
        int maxRect = 0;
        int col = matrix[0].length;
        int[] process = new int[col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == '0') {
                    process[j] = 0;
                } else {
                    process[j] += 1;
                }
            }
            int currArea = largestRectangleArea(process);
            maxRect = Math.max(maxRect, currArea);
        }
        return maxRect;
    }
}
