package leetcode.easy.java;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class FruitsIntoBasket_II_3477 {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        Deque<Integer> st = new ArrayDeque<>();
        List<Integer> temp = new ArrayList<>();
        int len = fruits.length;
        for (int i = len - 1; i >= 0; i--) {
            st.push(baskets[i]);
        }
        int taken = 0;
        for (int i = 0; i < len; i++) {
            int num = fruits[i];
            while (!st.isEmpty() && st.peek() < num) {
                int val = st.pop();
                temp.add(val);
            }
            if (!st.isEmpty() && st.peek() >= num) {
                st.pop();
                taken += 1;
            }
            int sz = temp.size();
            while (sz > 0) {
                st.push(temp.get(sz - 1));
                sz--;
            }
            temp.clear();
        }
        return len - taken;
    }
}
