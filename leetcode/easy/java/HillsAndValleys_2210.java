package leetcode.easy.java;

import java.util.ArrayList;
import java.util.List;

public class HillsAndValleys_2210 {
    public int countHillValley(int[] nums) {
        int count = 0;
        List<Integer> modified = new ArrayList<>();
        int pre = -1;
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                modified.add(nums[i]);
                pre = nums[i];
            } else if (nums[i] != pre) {
                modified.add(nums[i]);
                pre = nums[i];
            }
        }
        for (int i = 1; i < modified.size() - 1; i++) {
            int prev = modified.get(i - 1);
            int next = modified.get(i + 1);
            int curr = modified.get(i);
            if (curr > prev && curr > next) {
                count += 1;
            }
            else if (curr < prev && curr < next) {
                count += 1;
            }
        }
        return count;
    }
}
