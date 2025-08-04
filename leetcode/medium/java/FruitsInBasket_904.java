package leetcode.medium.java;

import java.util.HashMap;
import java.util.Map;

public class FruitsInBasket_904 {
    public int totalFruit(int[] fruits) {
        int left = 0;
        int maxFruitsCount = 0;
        Map<Integer, Integer> mp = new HashMap<>();
        for (int i = 0; i < fruits.length; i++) {
            mp.put(fruits[i], mp.getOrDefault(fruits[i], 0) + 1);
            while (mp.size() > 2) {
                int key = fruits[left];
                if (mp.containsKey(key)) {
                    mp.put(key, mp.get(key) - 1);
                    if (mp.containsKey(key) && mp.get(key) == 0) {
                        mp.remove(key);
                    }
                }
                left++;
            }
            int width = i - left + 1;
            maxFruitsCount = Math.max(width, maxFruitsCount);
        }
        return maxFruitsCount;
    }
}
