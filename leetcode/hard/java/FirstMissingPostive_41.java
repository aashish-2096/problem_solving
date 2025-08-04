package leetcode.hard.java;

/**
 * Asked in Hike OA - Failed
 */
public class FirstMissingPostive_41 {
    public int firstMissingPositive(int[] nums) {
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            while (nums[i] <= len && nums[i] > 0 && nums[nums[i] - 1] != nums[i]) {
                int value = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = value;
            }
        }

        int result = -1;
        for (int i = 0; i < len; i++) {
            if (nums[i] != i + 1) {
                result = i + 1;
                break;
            }
        }
        if (result == -1) {
            result = len + 1;
        }
        return result;
    }
}
