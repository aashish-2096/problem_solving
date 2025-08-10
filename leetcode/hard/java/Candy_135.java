package leetcode.hard.java;

import java.util.Arrays;

public class Candy_135 {
    public int candy(int[] ratings) {
        int size = ratings.length;
        int[] cost = new int[size];
        Arrays.fill(cost, 1);
        for (int i = 0; i < size - 1; i++) {
            if (ratings[i] > ratings[i + 1]) {
                if (cost[i] <= cost[i + 1])
                    cost[i] = cost[i + 1] + 1;
            } else if (ratings[i] < ratings[i + 1]) {
                if (cost[i] >= cost[i + 1]) {
                    cost[i + 1] = cost[i] + 1;
                }
            }
        }
        for (int i = size - 1; i > 0; i--) {
            if (ratings[i] > ratings[i - 1]) {
                if (cost[i] <= cost[i - 1]) {
                    cost[i] = cost[i - 1] + 1;
                }
            } else if (ratings[i] < ratings[i - 1]) {
                if (cost[i] >= cost[i - 1]) {
                    cost[i - 1] = cost[i] + 1;
                }
            }
        }
        int sum = 0;
        for (int i : cost) {
            sum += i;
        }
        return sum;

    }
}
