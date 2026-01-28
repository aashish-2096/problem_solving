package arrays;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Cinema_SearAllocation_1386 {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        int count = 0;
        Map<Integer, Set<Integer>> mp = new HashMap<>();
        for (int i = 0; i < reservedSeats.length; i++) {
            int a = reservedSeats[i][0];
            int b = reservedSeats[i][1];
            if (!mp.containsKey(a)) {
                mp.put(a, new HashSet<>());
            }
            mp.get(a).add(b);
        }
        int remaining = n - mp.size();
        for (int i : mp.keySet()) {
            boolean first = isVacant(i, 2, mp) && isVacant(i, 3, mp) && isVacant(i, 4, mp) && isVacant(i, 5, mp);
            boolean second = isVacant(i, 6, mp) && isVacant(i, 7, mp) && isVacant(i, 8, mp) && isVacant(i, 9, mp);
            boolean foundSome = first || second;
            if (first) {
                count += 1;
            }
            if (second) {
                count += 1;
            }
            if (!foundSome) {
                boolean third = isVacant(i, 4, mp) && isVacant(i, 5, mp) && isVacant(i, 6, mp) && isVacant(i, 7, mp);
                if (third)
                    count += 1;
            }
        }
        if (remaining > 0) {
            count += (remaining * 2);
        }
        return count;
    }

    private boolean isVacant(int a, int b, Map<Integer, Set<Integer>> mp) {
        if (mp.containsKey(a) && mp.get(a).contains(b))
            return false;
        return true;
    }
}
