package leetcode.hard.java;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.PriorityQueue;

public class SlidingWindowMax_239 {
    static class SimplePair {
        int key;
        int value;

        SimplePair(int key, int value) {
            this.key = key;
            this.value = value;
        }

        int getKey() {
            return this.key;
        }

        int getValue() {
            return this.value;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o)
                return true;
            if (!(o instanceof SimplePair))
                return false;
            SimplePair p = (SimplePair) o;
            return key == p.key && value == p.value;
        }

        @Override
        public int hashCode() {
            return Objects.hash(key, value);
        }
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (k == 1) {
            return nums;
        }
        int size = nums.length;
        List<Integer> res = new ArrayList<>();
        int start = 0;
        PriorityQueue<SimplePair> pq = new PriorityQueue<>(Comparator.comparingInt(SimplePair::getKey).reversed());
        for (int i = 0; i < k; i++) {
            pq.add(new SimplePair(nums[i], i));
        }
        SimplePair pr = pq.peek();
        res.add(pr.getKey());
        for (int i = k; i < size; i++) {
            pq.add(new SimplePair(nums[i], i));
            SimplePair pr2 = pq.peek();
            if (pr2.getValue() <= i - k) {
                while (pr2.getValue() <= i - k) {
                    pq.poll();
                    pr2 = pq.peek();
                }
            }
            res.add(pr2.getKey());
        }
        int[] arr = res.stream().mapToInt(i -> i).toArray();
        return arr;
    }
}
