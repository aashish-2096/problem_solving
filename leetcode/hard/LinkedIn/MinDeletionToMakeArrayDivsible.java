package leetcode.hard.LinkedIn;

import java.util.Map;
import java.util.TreeMap;

public class MinDeletionToMakeArrayDivsible {
    int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    public int minOperations(int[] nums, int[] numsDivide) {
        Map<Integer, Integer> mp = new TreeMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!mp.containsKey(nums[i])) {
                mp.put(nums[i], 0);
            }
            mp.put(nums[i], mp.get(nums[i]) + 1);
        }
        int deleted = 0;
        int gcdV = numsDivide[0];
        for (int i : numsDivide) {
            gcdV = gcd(gcdV, i);
        }
        for (Map.Entry<Integer, Integer> entry : mp.entrySet()) {
            int item = entry.getKey();
            if (gcdV % item == 0) {
                return deleted;
            }
            deleted += entry.getValue();
        }
        return -1;
    }
}
