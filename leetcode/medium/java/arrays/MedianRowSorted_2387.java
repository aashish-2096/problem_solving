package arrays;

import java.util.Map;
import java.util.TreeMap;

public class MedianRowSorted_2387 {
    public int matrixMedian(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int size = row * col;
        int medianIndex = (size / 2);
        Map<Integer, Integer> sortedList = new TreeMap<>();
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                sortedList.put(grid[i][j], sortedList.getOrDefault(grid[i][j], 0) + 1);
            }
        }
        int count = 0, result = -1;
        for (Map.Entry<Integer, Integer> et : sortedList.entrySet()) {
            count += et.getValue();
            if (count > medianIndex) {
                result = et.getKey();
                break;
            }

        }
        return result;
    }
}
