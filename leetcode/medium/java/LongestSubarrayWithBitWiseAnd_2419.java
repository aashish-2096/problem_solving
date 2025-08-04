public class LongestSubarrayWithBitWiseAnd_2419 {
      public int longestSubarray(int[] nums) {
        int size = nums.length;
        int maxNum = nums[0];
        int maxLen = 1;
        int lenCount = 1;
        for (int i = 1; i < size; i++) {
            if (nums[i] > maxNum) {
                maxNum = nums[i];
                lenCount = 1;
                maxLen = 1;
            } else if (nums[i] == maxNum) {
                lenCount++;
                maxLen = Math.max(lenCount, maxLen);
            } else {
                lenCount = 0;
            }
        }
        return maxLen;
    }
}
