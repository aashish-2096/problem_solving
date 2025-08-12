import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class BitwiseOrSubArray_898 {
    Set<Integer> result = new HashSet<>();

    public int subarrayBitwiseORs(int[] arr) {
        Set<Integer> hashSet = new HashSet<>();
        int size = arr.length;
        // int[][] dp = new int[size + 1][size + 1];
        // for (int i = 0; i <= size; i++) {
        //     Arrays.fill(dp[i], 0);
        // }
        // for (int i = size - 1; i >= 0; i--) {
        //     int value = 0;
        //     for (int j = i; j >= 0; j--) {
        //         value |= arr[j];
        //         hashSet.add(value);
        //     }
        // }
        Set<Integer> prev = new HashSet<>();
        Set<Integer> currList = new HashSet<>();
        for (int i = 0; i < size; i++) {
            currList = new HashSet<>();
            if (!prev.isEmpty()) {
                for (Integer nm : new ArrayList<>(prev)) {
                    int mod = nm | arr[i];
                    currList.add(mod);
                }
            }
            currList.add(arr[i]);
            hashSet.addAll(currList);
            prev = currList;
        }
        return hashSet.size();
    }
}
