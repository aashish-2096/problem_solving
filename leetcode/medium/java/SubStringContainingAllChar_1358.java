import java.util.Arrays;

public class SubStringContainingAllChar_1358 {
    public boolean allNonZero(int[] ar) {
        return ar[0] >= 0 && ar[1] >= 0 && ar[2] >= 0;
    }

    public int getMin(int[] ar) {
        if (ar[0] < ar[1] && ar[0] < ar[2]) {
            return ar[0];
        } else if (ar[1] < ar[0] && ar[1] < ar[2]) {
            return ar[1];
        } else {
            return ar[2];
        }
    }

    public int numberOfSubstrings(String s) {
        int[] ar = new int[3];
        Arrays.fill(ar, -1);
        int numberOfSubStrings = 0;
        for (int i = 0; i < s.length(); i++) {
            int ind = s.charAt(i) - 'a';
            ar[ind] = i;
            if (allNonZero(ar)) {
                int minWindow = getMin(ar);
                numberOfSubStrings += (1 + minWindow);
            }
        }
        return numberOfSubStrings;
    }
}
