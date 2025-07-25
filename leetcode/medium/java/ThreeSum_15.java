import java.util.*;
import java.util.stream.Collectors;
public class ThreeSum_15 {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        Set<List<Integer>> set = new HashSet<>();
        int size = nums.length;
        for (int i = 0; i < size; i++) {
            int left = i + 1;
            int right = size - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    List<Integer> res = Arrays.asList(nums[i], nums[left], nums[right]);
                    set.add(res);
                    left++;
                    right--;
                } else if (sum > 0) {
                    right--;
                } else if (sum < 0) {
                    left++;
                }
            }
        }
        return set.stream().collect(Collectors.toList());
    }
}
