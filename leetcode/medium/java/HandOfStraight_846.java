import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class HandOfStraight_846 {
    public boolean isNStraightHand(int[] nums, int k) {
        int size = nums.length;
        if (size % k != 0)
            return false;
        if(k == 1) return true;
        Map<Integer, Integer> mp = new TreeMap<>();
        for (int i = 0; i < size; i++) {
            mp.computeIfAbsent(nums[i], p -> 0);
            mp.computeIfPresent(nums[i], (p, v) -> v + 1);
        }
        boolean status = true;
        while (!mp.isEmpty() && status) {
            Iterator<Map.Entry<Integer, Integer>> itr = mp.entrySet().iterator();
            int prev = -1;
            if (mp.size() == 1) {
                status = false;
                break;
            }
            int count = 0;
            while (itr.hasNext() && count < k) {
                Map.Entry<Integer, Integer> num = itr.next();
                if (prev == -1) {
                    prev = num.getKey();
                } else if (prev + 1 != num.getKey()) {
                    status = false;
                    break;
                }
                count++;
                prev = num.getKey();
                Integer value = num.getValue() - 1;
                num.setValue(value);
                if (num.getValue() == 0) {
                    itr.remove();
                }
            }
        }
        return status;
    }
}
