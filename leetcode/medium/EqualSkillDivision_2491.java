package leetcode.medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class EqualSkillDivision_2491 {
    public long dividePlayers(int[] skill) {
        int size = skill.length;
        if (size % 2 != 0)
            return -1;
        if (size == 2)
            return (long) skill[0] * skill[1];
        Map<Integer, Integer> mp = new HashMap<>();
        for (int i = 0; i < size; i++) {
            mp.computeIfAbsent(skill[i], p -> 0);
            mp.computeIfPresent(skill[i], (p, v) -> v + 1);
        }
        int sum = 0;
        for (int number : skill) {
            sum += number;
        }
        System.out.println("Sum" + sum);
        System.out.println("Size" + size);
        if (sum % (size / 2) != 0)
            return -1;
        int targetSum = 2 * sum / (size);
        long resultantSum = 0;
        Arrays.sort(skill);
        for (int i = 0; i <= size / 2; i++) {
            int a = skill[i];
            int target = targetSum - a;
            if (mp.containsKey(target)) {
                resultantSum += (a * (target));
                mp.computeIfPresent(a, (p, v) -> v - 1);
                mp.computeIfPresent(target, (p, v) -> v - 1);
                if (mp.containsKey(a) && mp.get(a) == 0) {
                    mp.remove(a);
                }
                if (target != a && mp.get(target) == 0) {
                    mp.remove(target);
                }
            }
        }
        return mp.isEmpty() ? resultantSum : -1;
    }
}
