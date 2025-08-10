package leetcode.medium.java;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ReorderedPowerOfTwo_869 {
    public boolean reorderedPowerOf2(int n) {
        Map<String, Integer> arrString = new HashMap<>();
        for (int i = 0; i < 32; i++) {
            int val = 1 << i;
            char[] ar = String.valueOf(val).toCharArray();
            Arrays.sort(ar);
            String st = new String(ar);
            arrString.put(st, val);
        }
        char[] ar = String.valueOf(n).toCharArray();
        Arrays.sort(ar);
        String target = new String(ar);
        return arrString.containsKey(target);
    }
}
