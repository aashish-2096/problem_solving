import java.util.HashMap;
import java.util.Map;

public class MaximumErasure_1695 {
     public int maximumUniqueSubarray(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        Map<Integer, Integer> mp = new HashMap<>();
        int left = 0;
        int runningSum = 0;
        int size = nums.length;
        for (int i = 0; i < size; i++) {
            if (mp.containsKey(nums[i])) {
                int oldIndex = mp.get(nums[i]);
                while (left <= oldIndex) {
                    mp.remove(nums[left]);
                    runningSum -= nums[left];
                    left++;
                }
                runningSum += nums[i];
                mp.put(nums[i], i);
            } else {
                mp.put(nums[i], i);
                runningSum += nums[i];
            }
            maxSum = Math.max(maxSum, runningSum);
        }
        return maxSum;
    }
}
