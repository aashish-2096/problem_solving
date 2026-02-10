package leetcode.hard.LinkedIn;

import java.util.HashMap;
import java.util.Map;

public class MaxPointOnLine_149 {
    public int maxPoints(int[][] points) {
        int n = points.length;
        if (n == 1)
            return 1;
        int maxCount = 2;
        for (int i = 0; i < n; i++) {
            Map<Double, Integer> slopeMap = new HashMap<>();
            for (int j = i + 1; j < n; j++) {
                double slope = getSlope(i, j, points);
                slopeMap.put(slope, slopeMap.getOrDefault(slope, 0) + 1);
                maxCount = Math.max(maxCount, slopeMap.get(slope) + 1);
            }
        }
        return maxCount;
    }

    private double getSlope(int i, int j, int[][] points) {
        int x1 = points[i][0], y1 = points[i][1];
        int x2 = points[j][0], y2 = points[j][1];
        if (x2 == x1)
            return Double.MAX_VALUE;
        if (y2 - y1 == 0)
            return 0;
        return ((double) (y2 - y1) / (double) (x2 - x1));
    }
}
