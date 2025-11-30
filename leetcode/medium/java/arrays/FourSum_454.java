package arrays;

import java.util.HashMap;
import java.util.Map;

public class FourSum_454 {
    public Map<Integer, Integer> mapToSumSet(int[] num1, int[] num2) {
        Map<Integer, Integer> uniqueSum = new HashMap<>();
        int num = num1.length;
        for (int i = 0; i < num; i++) {
            for (int j = 0; j < num; j++) {
                int sum = num1[i] + num2[j];
                uniqueSum.put(sum, uniqueSum.getOrDefault(sum, 0) + 1);
            }
        }
        return uniqueSum;
    }

    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer, Integer> num1Map = mapToSumSet(nums1, nums2);
        Map<Integer, Integer> num2Map = mapToSumSet(nums3, nums4);
        int count = 0;
        for (Integer value : num1Map.keySet()) {
            int target = -1 * value;
            if (num2Map.containsKey(target)) {
                count += (num2Map.get(target) * num1Map.get(value));
            }
        }
        return count;
    }
}
