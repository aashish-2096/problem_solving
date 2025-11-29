package arrays;

import java.util.Arrays;

public class ArrayProductExceptSelf_238 {
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] res = new int[len];
        Arrays.fill(res, 1);
        int prod = nums[0];
        for (int i = 1; i < len; i++) {
            res[i] = prod;
            prod *= nums[i];
        }
        int prod2 = nums[len - 1];
        for (int i = len - 2; i >= 0; i--) {
            res[i] = res[i] * prod2;
            prod2 *= nums[i];
        }
        return res;
    }
}
