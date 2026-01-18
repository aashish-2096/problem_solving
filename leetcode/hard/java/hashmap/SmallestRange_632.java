package leetcode.hard.java.hashmap;

import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

public class SmallestRange_632 {
    class Node {
        int nIndex;
        int kIndex;
        int value;

        Node(int nIndex, int kIndex, int value) {
            this.nIndex = nIndex;
            this.kIndex = kIndex;
            this.value = value;
        }
    }

    int minA = Integer.MAX_VALUE, maxB = Integer.MAX_VALUE;
    int minDiff = Integer.MAX_VALUE;

    private void checkAndUpdate(int min, int max) {
        int diff = max - min;
        if (diff < minDiff) {
            minDiff = diff;
            minA = min;
            maxB = max;
        }
    }

    public int[] smallestRange(List<List<Integer>> nums) {
        Set<Integer> rangeList = new HashSet<>();
        PriorityQueue<Node> minPq = new PriorityQueue<>(
                (a, b) -> a.value - b.value);
        PriorityQueue<Node> maxPq = new PriorityQueue<>(
                (a, b) -> Integer.compare(b.value, a.value));
        int k = nums.size();
        for (int i = 0; i < k; i++) {
            Node curr = new Node(0, i, nums.get(i).get(0));
            minPq.add(curr);
            maxPq.add(curr);
            rangeList.add(i);
        }
        int aMin = minPq.peek().value;
        int bMin = maxPq.peek().value;
        checkAndUpdate(aMin, bMin);
        while (rangeList.size() <= k) {
            Node node = minPq.poll();
            int index = node.nIndex;
            int kIndex = node.kIndex;
            if ((index + 1) == nums.get(kIndex).size()) {
                break;
            }
            int val = nums.get(kIndex).get(index + 1);
            Node curr2 = new Node(index + 1, kIndex, val);
            minPq.add(curr2);
            maxPq.add(curr2);
            aMin = minPq.peek().value;
            bMin = maxPq.peek().value;
            checkAndUpdate(aMin, bMin);
        }
        return new int[] { minA, maxB };
    }
}
