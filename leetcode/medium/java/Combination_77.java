import java.util.ArrayList;
import java.util.List;

public class Combination_77 {
    List<List<Integer>> result = new ArrayList<>();
    public void recursion(List<Integer> arr, int index, int[] nums, int k) {
        if (arr.size() == k) {
            result.add(arr);
            return;
        }
        if(index >= nums.length) return;
        recursion(arr, index + 1, nums, k);
        List<Integer> arrTemp = new ArrayList<>(arr);
        arrTemp.add(nums[index]);
        recursion(arrTemp, index + 1, nums, k);
    }

    public List<List<Integer>> combine(int n, int k) {
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = i+1;
        }
        List<Integer> ar = new ArrayList<>();
        recursion(ar, 0, nums, k);
        return result;
    }
}
