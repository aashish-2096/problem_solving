package recursion_dp;

import java.util.ArrayList;
import java.util.List;

public class Subset_78 {
    List<List<Integer>> result = new ArrayList<>();
    public void recursion(int index, int[] nums, List<Integer> elements) {
        if (index == nums.length) {
            result.add(elements);
            return;
        }
        recursion(index + 1, nums, elements);
        List<Integer> temp = new ArrayList<>(elements);
        temp.add(nums[index]);
        recursion(index + 1, nums, temp);

    }

    public List<List<Integer>> subsets(int[] nums) {
        recursion(0, nums, new ArrayList<>());
        return result;
    }
}
