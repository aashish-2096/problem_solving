package leetcode.hard.java;

import java.util.Collections;
import java.util.PriorityQueue;

public class MedianOfDataStream_295 {
    int total = 0;
    PriorityQueue<Integer> greater = new PriorityQueue<Integer>();
    PriorityQueue<Integer> smaller = new PriorityQueue<Integer>(Collections.reverseOrder());

    public MedianOfDataStream_295() {
        this.total = 0;
        this.greater = new PriorityQueue<Integer>();
        this.smaller = new PriorityQueue<Integer>(Collections.reverseOrder());
    }

    public void addNum(int num) {
        this.total += 1;
        this.smaller.add(num);
        this.greater.add(this.smaller.poll());
        while (this.greater.size() > this.smaller.size()) {
            int value = this.greater.poll();
            this.smaller.add(value);
        }
    }

    public double findMedian() {
        if (this.total % 2 == 0) {
            int res = this.smaller.peek() + this.greater.peek();
            return (double) res / 2;
        }
        return (double) this.smaller.peek();
    }
}
