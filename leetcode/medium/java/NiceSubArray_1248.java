public class NiceSubArray_1248 {
    int countArraysLessThan(int[] nums, int k) {
        int left = 0;
        int ones = 0;
        int overall = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 1) {
                ones += 1;
            }
            if (ones > k) {
                while (ones > k && left <= i) {
                    if (nums[left] % 2 != 0) {
                        ones--;
                    }
                    left++;
                }
            }
            overall += (i - left + 1);
        }
        return overall;
    }

    public int numberOfSubarrays(int[] nums, int k) {
        return countArraysLessThan(nums, k) - countArraysLessThan(nums, k - 1);
    }
}
