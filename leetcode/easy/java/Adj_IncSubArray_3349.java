package leetcode.easy.java;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Adj_IncSubArray_3349 {
    public boolean hasIncreasingSubarrays(List<Integer> nums, int k) {
        boolean isIncreasing = false;
        int len = nums.size();
        int constVal = -1001;
        int prev = constVal;
        Set<Integer> adjIndex = new HashSet<>();
        for (int i = 0; i <= len - k; i++) {
            int takenValues = 0;
            prev = constVal;
            for (int j = i; j < i + k; j++) {
                if (prev == constVal) {
                    prev = nums.get(j);
                    takenValues += 1;
                } else if (nums.get(j) > prev) {
                    prev = nums.get(j);
                    takenValues += 1;
                }
            }
            if (takenValues == k) {
                adjIndex.add(i);
            }
        }
        if (adjIndex.size() >= 2) {
            int count = 0;
            Iterator<Integer> iterator = adjIndex.iterator();
            while (iterator.hasNext()) {
                int val = iterator.next();
                int target = val + k;
                if (adjIndex.contains(target)) {
                    count++;
                }
            }
            if (count > 0) {
                isIncreasing = true;
            }
        }
        return isIncreasing;
    }
}
