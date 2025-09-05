package leetcode.hard.java;

import java.util.HashMap;
import java.util.Map;

public class SubarraysWithKDifferentInt_992 {
    int countArraysLessThan(int[] nums, int k) {
        int overall = 0;
        int left = 0;
        Map<Integer, Integer> mp = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (mp.containsKey(nums[i])) {
                int target = mp.get(nums[i]) + 1;
                mp.put(nums[i], target);
            } else {
                mp.put(nums[i], 1);
            }
            if (mp.size() > k) {
                while (mp.size() > k && left <= i) {
                    int val = mp.get(nums[left]) - 1;
                    if (val == 0) {
                        mp.remove(nums[left]);
                    } else {
                        mp.put(nums[left], val);
                    }
                    left++;
                }
            }
            overall += (i - left + 1);
        }
        return overall;
    }

    public int subarraysWithKDistinct(int[] nums, int k) {
        return countArraysLessThan(nums, k) - countArraysLessThan(nums, k-1);
    }
}
