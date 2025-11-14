package leetcode.easy.java;

import java.util.HashMap;
import java.util.Map;

public class TwoSum_DS__170 {
    Map<Integer, Integer> numbers;

    public TwoSum_DS__170() {
        numbers = new HashMap<>();
    }

    public void add(int number) {
        numbers.merge(number, 1, Integer::sum);
    }

    public boolean find(int value) {
        for (Integer number : numbers.keySet()) {
            int base = (int) number;
            int num = value - base;
            int left = numbers.getOrDefault(num, -1);
            int right = numbers.getOrDefault(base, -1);
            if (base == num && left > 1) {
                return true;
            }
            if (left > 0 && right > 0 && base != num) {
                return true;
            }
        }
        return false;
    }
}
