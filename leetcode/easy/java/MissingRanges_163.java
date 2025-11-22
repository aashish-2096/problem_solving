package leetcode.easy.java;

import java.util.ArrayList;
import java.util.List;

public class MissingRanges_163 {
    public List<List<Integer>> findMissingRanges(int[] nums, int lower, int higher) {
        List<List<Integer>> result = new ArrayList<>();
        int length = nums.length;
        if (length > 0) {
            int first = nums[0];
            if (lower < nums[0]) {
                int lowerM = nums[0] - 1;
                result.add(List.of(lower, lowerM));
            }
            for (int i = 0; i < length - 1; i++) {
                int curr = nums[i];
                int next = nums[i + 1];
                if (next - curr > 1) {
                    result.add(List.of(curr + 1, next - 1));
                }
            }
            if (higher > nums[length - 1]) {
                int higherM = nums[length - 1] + 1;
                result.add(List.of(higherM, higher));
            }
        } else {
             result.add(List.of(lower, higher));
        }
        return result;
    }
}
