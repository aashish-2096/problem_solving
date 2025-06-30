package leetcode.easy.java;

public class BestTimeStocks_121 {
    public int maxProfit(int[] nums) {
        int size = nums.length;
        int maxPrice = nums[size - 1];
        int maxProfit = Integer.MIN_VALUE;
        for (int i = size - 1; i >= 0; i--) {
            if (maxPrice < nums[i]) {
                maxPrice = nums[i];
            }
            int profit = maxPrice - nums[i];
            maxProfit = Math.max(maxProfit, profit);
        }
        return maxProfit;
    }
}
