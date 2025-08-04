public class MaxXorSubSeq_2044 {
    int count = 0;
    public void recur(int[] nums, int index, int xor, int target) {
        if (index >= nums.length) {
            if (xor == target) {
                count += 1;
            }
            return;
        }
        int valueTake = xor | nums[index];
        recur(nums, index + 1, valueTake, target);
        recur(nums, index + 1, xor, target);
    }

    public int countMaxOrSubsets(int[] nums) {
        int maxXoR = 0;
        for (int i = 0; i < nums.length; i++) {
            maxXoR = maxXoR | nums[i];
        }
        recur(nums, 0, 0, maxXoR);
        return this.count;

    }
}
