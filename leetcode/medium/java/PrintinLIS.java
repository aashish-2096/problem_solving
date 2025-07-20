import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PrintinLIS {
    public int printLIS(int[] nums) {
        int size = nums.length;
        int[] dp2 = new int[size + 1];
        Arrays.fill(dp2, 1);
        int maxLength = 0;
        int lastInd = -1;
        int[] path = new int[size + 1];
        List<Integer> lcsPrint = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            path[i] = i;
            for (int j = 0; j <= i; j++) {
                if (nums[i] > nums[j] && dp2[i] < 1 + dp2[j]) {
                    path[i] = j;
                    dp2[i] = 1 + dp2[j];
                }
            }
            if (maxLength < dp2[i]) {
                maxLength = dp2[i];
                lastInd = i;
            }
        }
        lcsPrint.add(nums[lastInd]);
        while (path[lastInd] != lastInd) {
            lastInd = path[lastInd];
            lcsPrint.add(nums[lastInd]);
        }
        Collections.reverse(lcsPrint);
        for (int i : lcsPrint) {
            System.out.print(i+":");
        }
        return maxLength;
    }
}
