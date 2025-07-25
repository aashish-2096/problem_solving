package leetcode.medium.java;

import java.util.Arrays;

public class HIndex_274 {
    public int hIndex(int[] citations) {
        int result = Integer.MIN_VALUE;
        Arrays.sort(citations);
        int size = citations.length;
        if (size == 1 && citations[0] > 0) {
            result = 1;
        }
        for (int i = 0; i < size; i++) {
            int cite = citations[i];
            int papers = size - i;
            if (papers >= cite) {
                result = Math.max(cite, result);
            } else {
                result = Math.max(Math.min(cite, papers), result);
            }
            if (i == size - 1 && cite > 0) {
                result = Math.max(result, 1);
            }
        }
        return result;
    }
}
