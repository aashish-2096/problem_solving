package leetcode.easy.java;

import java.util.Arrays;

public class LongestHarmoniusSubSeq_594 {
     public int findLHS(int[] nums) {
        Arrays.sort(nums);
        int size = nums.length;
        int maxLength = 0;
        int currentIndex = 0;
        for (int i = 0; i < size; i++) {
            if (Math.abs(nums[currentIndex] - nums[i]) == 0) {
                continue;
            } else if (Math.abs(nums[currentIndex] - nums[i]) == 1) {
                int diff = i - currentIndex + 1;
                maxLength = Math.max(diff, maxLength);
            } else {
                int currentNum = nums[currentIndex];
                for (int j = currentIndex; j <= i; j++) {
                    if (nums[j] > currentNum) {
                        currentIndex = j;
                        break;
                    }
                }
            }
        }
        return maxLength;
    }
}
