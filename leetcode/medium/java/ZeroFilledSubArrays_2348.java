import java.util.HashMap;
import java.util.Map;

public class ZeroFilledSubArrays_2348 {
    private long twoPointers(int[] nums) {
        Map<Integer, Integer> zeroCount = new HashMap<>();
        int left = -1, right = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                if (left != -1) {
                    int window = i - left;
                    zeroCount.put(window,
                            zeroCount.getOrDefault(window, 0) + 1);
                }
                left = -1;
                right = -1;
                continue;
            } else {
                if (left != -1) {
                    right++;
                } else {
                    left = i;
                    right = i;
                }
            }
        }
        if (left != -1) {
            int window = right - left + 1;
            zeroCount.put(window,
                    zeroCount.getOrDefault(window, 0) + 1);
        }
        long zeroFilled = 0;
        for (Map.Entry et : zeroCount.entrySet()) {
            int key = (int) et.getKey();
            int count = (int) et.getValue();
            long temp = 0;
            while (key > 0) {
                temp += key;
                key--;
            }
            zeroFilled += (temp * count);
        }
        return zeroFilled;
    }

    public long zeroFilledSubarray(int[] nums) {
        long count = 0;
        int window = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                window += 1;
                count += window;
            } else {
                window = 0;
            }
        }
        return count;

    }
}
