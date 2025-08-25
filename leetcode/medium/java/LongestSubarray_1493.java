public class LongestSubarray_1493 {
    public int longestSubarray(int[] nums) {
        int left = -1, right = -1, midIndex = -1;
        boolean isLeftZero = false, isMidZero = false;
        int maxWindow = Integer.MIN_VALUE;
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            if (i == 0) {
                if (nums[i] == 0) {
                    isLeftZero = true;
                }
                left = 0;
                right = 0;
                continue;
            }
            if (nums[i] == 0) {
                if (isLeftZero) {
                    left++;
                    isLeftZero = false;
                    isMidZero = true;
                    midIndex = i;
                } else if (isMidZero) {
                    left = midIndex + 1;
                    if (nums[left] == 0) {
                        isLeftZero = true;
                        isMidZero = false;
                    } else {
                        midIndex = i;
                    }
                } else {
                    isMidZero = true;
                    midIndex = i;
                }
            }
            right = i;
            int window = right - left + 1;
            maxWindow = Math.max(maxWindow, window);
        }
        return maxWindow == Integer.MIN_VALUE ? 0 : maxWindow - 1;
    }
}
