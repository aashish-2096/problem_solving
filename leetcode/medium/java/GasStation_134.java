package leetcode.medium.java;

public class GasStation_134 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int size = gas.length;
        int index = 0;
        int total = 0, curr = 0;
        for (int i = 0; i < size; i++) {
            int diff = gas[i] - cost[i];
            total += diff;
            curr += diff;
            if (curr < 0) {
                curr = 0;
                index = i + 1;
            }
        }
        return total >= 0 ? index : -1;
    }
}
