package leetcode.hard.java;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class IPO_502 {
    public class Entity {
        private int index;
        private int capital;
        private int profit;

        public Entity(int index, int capital, int profit) {
            this.index = index;
            this.profit = profit;
            this.capital = capital;
        }

        public int getCapital() {
            return this.capital;
        }

        public int getIndex() {
            return this.index;
        }

        public int getProfit() {
            return this.profit;
        }
    }

    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        PriorityQueue<Entity> capitalMap = new PriorityQueue<>((a, b) -> Integer.compare(b.getProfit(), a.getProfit()));
        for (int i = 0; i < profits.length; i++) {
            capitalMap.add(new Entity(i, capital[i], profits[i]));
        }
        List<Entity> notConsidered = new ArrayList<>();
        while (k > 0 && !capitalMap.isEmpty()) {
            Entity current = capitalMap.poll();
            if (current.getCapital() <= w) {
                w += current.getProfit();
                for (Entity e : notConsidered) {
                    capitalMap.add(e);
                }
                notConsidered.clear();
                k--;
            } else {
                notConsidered.add(current);
            }
        }
        return w;
    }
}
