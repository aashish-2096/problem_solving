public class TwoSum_Sorted_167 {
    public int[] twoSum(int[] nums, int target) {
        int size = nums.length;
        int left = 0, right = size - 1;
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum == target) {
                break;
            }
            if (sum > target) {
                right--;
            }
            if (sum < target) {
                left++;
            }
        }
        int[] res = new int[2];
        res[0] = left+1;
        res[1] = right+1;
        return res;
    }
}
