public class MinLenSubArray_209 {
    int minSubArrayLen(int target, int[] nums) {
        int minSize = Integer.MAX_VALUE;
        int left = 0;
        int sum = 0;
        int prefixSum[] = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            prefixSum[i] = sum;
            if (sum >= target) {
                if (i == 0 || left == 0) {
                    int index = i - left + 1;
                    minSize = Math.min(minSize, index);
                }
                while (left <= i && sum - prefixSum[left] >= target) {
                    int index = i - left;
                    minSize = Math.min(minSize, index);
                    left++;
                }
            }
        }
        return minSize == Integer.MAX_VALUE ? 0 : minSize;
    }
}
