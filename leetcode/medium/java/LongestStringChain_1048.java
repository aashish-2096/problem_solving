import java.util.Arrays;
import java.util.Comparator;

public class LongestStringChain_1048 {
    class Solution {
    boolean checkForCharDiff(String s1, String s2) {
        if (s2.length() - s1.length() > 1) {
            return false;
        }
        if (s1.length() == s2.length())
            return false;
        int matchCount = 0;
        int lL = s1.length(), lR = s2.length();
        while (lL > 0 && lR > 0) {
            if (s1.charAt(lL - 1) == s2.charAt(lR - 1)) {
                lL--;
                lR--;
                matchCount++;
            } else {
                lR--;
            }
        }
        return matchCount == s1.length();
    }

    public int longestStrChain(String[] nums) {
        Arrays.sort(nums, Comparator.comparingInt(String::length));
        int size = nums.length;
        int[] dp2 = new int[size + 1];
        int maxLength = 0;
        Arrays.fill(dp2, 1);
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < i; j++) {
                boolean status = checkForCharDiff(nums[j], nums[i]);
                if (status && dp2[i] < 1 + dp2[j]) {
                    dp2[i] = 1 + dp2[j];
                }
            }
            if (maxLength < dp2[i]) {
                maxLength = dp2[i];
            }
        }
        return maxLength;
    }
}
}
