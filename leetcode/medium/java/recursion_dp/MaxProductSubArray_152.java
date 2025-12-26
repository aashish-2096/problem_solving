package recursion_dp;

public class MaxProductSubArray_152 {
    public int maxProduct(int[] nums) {
        if(nums.length == 0) return 0;
        int max = nums[0], min = nums[0];
        int maxProd = max;
        for (int i = 1; i < nums.length; i++) {
            int curr = nums[i];
            int value = Math.max(curr, Math.max(max * curr, min * curr));
            min = Math.min(curr, Math.min(max * curr, min * curr));
            max = value;
            maxProd = Math.max(maxProd, max);
        }
        return maxProd;
    }
}
