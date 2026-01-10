package recursion_dp;

import java.util.Arrays;
import java.util.Collections;

public class PartitionKEqualSUmSubset_698 {
    public boolean recurse(int index, int currSum, int target,
            int k, int[] nums, boolean[] indexes) {
        if (k == 1)
            return true;
        if (target == currSum) {
            return recurse(0, 0, target, k - 1, nums, indexes);
        }
        if(currSum > target) return false;
        for (int i = index; i < nums.length; i++) {
            if (!indexes[i] && target >= nums[i]) {
                indexes[i] = true;
                if (recurse(i, currSum + nums[i], target, k, nums, indexes)) {
                    return true;
                }
                indexes[i] = false;
            }
        }
        return false;
    }

    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = Arrays.stream(nums).sum();
        Arrays.sort(nums);
        Collections.reverse(Arrays.asList(nums));
        if (sum % k != 0)
            return false;
        boolean[] indexes = new boolean[nums.length];
        return recurse(0, 0, sum / k, k, nums, indexes);
    }
}
