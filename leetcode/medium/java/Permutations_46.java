import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Permutations_46 {
    List<List<Integer>> result = new ArrayList<>();
    public void recursion(List<Integer> arr, int[] nums, List<Boolean> taken) {
        if (arr.size() == nums.length) {
            result.add(arr);
            return;
        }
        for (int i = 0; i < taken.size(); i++) {
            if (!taken.get(i)) {
                taken.set(i, true);
                arr.add(nums[i]);
                List<Integer> ar = new ArrayList<>(arr);
                recursion(ar, nums, new ArrayList<>(taken));
                taken.set(i, false);
                arr.remove(arr.size() - 1);
            }
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        List<Integer> ar = new ArrayList<>();
        ArrayList<Boolean> taken = new ArrayList<>(Collections.nCopies(nums.length, false));
        recursion(ar, nums, taken);
        return result;
    }
}
