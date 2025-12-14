package leetcode.easy.java;

public class SmallesrCharGreaterThan_744 {
    public char nextGreatestLetter(char[] letters, char target) {
        int len = letters.length;
        int mid;
        int low = 0, high = len-1;
        if (len > 2) {
            while (low <= high) {
                mid = low + (high - low) / 2;
                if (letters[mid] <= target) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return low == len ? letters[0]: letters[low];
    }
}
