package recursion_dp;

import java.util.ArrayList;
import java.util.List;

public class Permutations_PowerSet_46 {
    List<List<Integer>> result = new ArrayList<>();
    public void recursion(List<Integer> arr, int[] nums, boolean[] taken) {
        if (arr.size() == nums.length) {
            result.add(arr);
            return;
        }
        for (int i = 0; i < taken.length; i++) {
            if (!taken[i]) {
                taken[i] =  true;
                arr.add(nums[i]);
                List<Integer> ar = new ArrayList<>(arr);
                recursion(ar, nums, taken);
                taken[i] =  false;
                arr.remove(arr.size() - 1);
            }
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        List<Integer> ar = new ArrayList<>();
        boolean[] taken = new boolean[nums.length];
        recursion(ar, nums, taken);
        return result;
    }
}
