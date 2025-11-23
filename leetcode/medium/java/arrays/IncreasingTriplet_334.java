package arrays;

public class IncreasingTriplet_334 {
    public boolean increasingTriplet(int[] nums) {
        int firstNum = Integer.MAX_VALUE, secondNum = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= firstNum) {
                firstNum = nums[i];
            } else if (nums[i] <= secondNum) {
                secondNum = nums[i];
            } else {
                return true;
            }
        }
        return false;
    }
}
