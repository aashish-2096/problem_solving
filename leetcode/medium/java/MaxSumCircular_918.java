public class MaxSumCircular_918 {
     public int maxSubarraySumCircular(int[] nums) {
        int len = nums.length;
        int maxSum = nums[0], minSum = nums[0];
        int currMax = nums[0], currMin = nums[0];
        int totalSum = nums[0];
        for (int i = 1; i < len; i++) {
            currMax = Math.max(nums[i], currMax + nums[i]);
            currMin = Math.min(nums[i], currMin + nums[i]);
            maxSum = Math.max(maxSum, currMax);
            minSum = Math.min(minSum, currMin);
            totalSum += nums[i];
        }
        if (maxSum < 0) return maxSum;
        return Math.max(maxSum, totalSum - minSum);
    }
}
