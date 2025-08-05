package leetcode.hard.java;

import java.util.HashMap;
import java.util.Map;

public class MaxHarvestedFruits_KSteps_2106 {
    public int maxTotalFruits(int[][] fruits, int startPos, int k) {
        Map<Integer, Integer> mp = new HashMap<>();
        int maxiMulValue = 0;
        for (int i = 0; i < fruits.length; i++) {
            mp.put(fruits[i][0], fruits[i][1]);
            maxiMulValue = Math.max(maxiMulValue, fruits[i][0]);
        }
        int totalFruit = 0;
        int lowIndex = Math.max(0, startPos - k);
        int highIndex = Math.min(maxiMulValue, startPos + k);
        int left = lowIndex;
        int windowSum = 0;
        for (int i = lowIndex; i <= highIndex; i++) {
            windowSum += mp.getOrDefault(i, 0);
            while (true) {
                int leftSteps = Math.abs(startPos - left) + i - left;
                int rightSteps = Math.abs(i - startPos) + i - left;
                int minSteps = Math.min(leftSteps, rightSteps);
                if (minSteps <= k)
                    break;
                windowSum -= mp.getOrDefault(left, 0);
                left++;
            }
            totalFruit = Math.max(totalFruit, windowSum);
        }
        return totalFruit;
    }
}
