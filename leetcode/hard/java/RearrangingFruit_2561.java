package leetcode.hard.java;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RearrangingFruit_2561 {
    public long minCost(int[] basket1, int[] basket2) {
        int overallMin = Integer.MAX_VALUE;
        Map<Integer, Integer> mp1 = new HashMap<>();
        for (int i = 0; i < basket1.length; i++) {
            mp1.put(basket1[i], mp1.getOrDefault(basket1[i], 0) + 1);
            mp1.put(basket2[i], mp1.getOrDefault(basket2[i], 0) - 1);
            overallMin = Math.min(overallMin, Math.min(basket2[i], basket1[i]));
        }
        List<Integer> pq1 = new ArrayList<>();
        for (Map.Entry<Integer, Integer> mp : mp1.entrySet()) {
            int key = mp.getKey();
            int value = mp.getValue();
            if (value % 2 != 0) {
                return -1;
            }
            for (int i = 0; i < Math.abs(value) / 2; i++) {
                pq1.add(key);
            }
        }
        Collections.sort(pq1);
        long result = 0;
        for (int i = 0; i < pq1.size() / 2; i++) {
            result += Math.min(pq1.get(i), 2 * overallMin);
        }
        return result;
    }
}
