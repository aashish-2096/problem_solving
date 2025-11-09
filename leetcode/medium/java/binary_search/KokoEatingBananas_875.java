package binary_search;

import java.util.Arrays;

public class KokoEatingBananas_875 {
    private int findIndexGreaterThan(int[] piles, long value) {
        int low = 0;
        int high = piles.length;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (piles[mid] > value) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    public long calculateSteps(int index, int[] piles, long value) {
        long hours = 0;
        for (int pile : piles) {
            hours += (pile + value - 1) / value;
        }
        return hours;
    }

    public int minEatingSpeed(int[] piles, int h) {
        Arrays.sort(piles);
        int len = piles.length;
        long low = 1, high = piles[len - 1];
        if (h == len)
            return (int) high;
        int rate = -1;
        while (low <= high) {
            long mid = low + (high - low) / 2;
            int index = findIndexGreaterThan(piles, mid);
            long hours = calculateSteps(index, piles, mid);
            if (hours <= h) {
                rate = (int)mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return (int) rate;
    }
}
