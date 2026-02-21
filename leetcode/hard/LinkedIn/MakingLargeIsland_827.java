package leetcode.hard.LinkedIn;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MakingLargeIsland_827 {
    public int largestIsland(int[][] grid) {
        Map<Integer, Integer> islandMap = new HashMap<>();
        int islandId = 2;
        int row = grid.length;
        int col = grid[0].length;
        boolean hasZero = false;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1) {
                    islandMap.put(islandId, markIsland(islandId, i, j, grid));
                    islandId++;
                }
                if (grid[i][j] == 0) {
                    hasZero = true;
                }
            }
        }
        if (islandMap.isEmpty()) {
            return 1;
        }
        if (islandMap.size() == 1) {
            --islandId;
            return !hasZero ? islandMap.get(islandId) : islandMap.get(islandId) + 1;
        }
        int maxValue = 1;
        for (int currRow = 0; currRow < row; currRow++) {
            for (int currCol = 0; currCol < col; currCol++) {
                if (grid[currRow][currCol] == 0) {
                    int currentSize = 1;
                    Set<Integer> neighboringIslands = new HashSet<>();
                    // up
                    if (currRow - 1 >= 0 && grid[currRow - 1][currCol] > 1) {
                        neighboringIslands.add(grid[currRow - 1][currCol]);
                    }
                    // down
                    if (currRow + 1 < row && grid[currRow + 1][currCol] > 1) {
                        neighboringIslands.add(grid[currRow + 1][currCol]);
                    }
                    // left 
                    if (currCol - 1 >= 0 && grid[currRow][currCol - 1] > 1) {
                        neighboringIslands.add(grid[currRow][currCol - 1]);
                    }
                    // right
                    if (currCol + 1 < col && grid[currRow][currCol + 1] > 1) {
                        neighboringIslands.add(grid[currRow][currCol + 1]);
                    }
                    for (int i : neighboringIslands) {
                        currentSize += islandMap.get(i);
                    }
                    maxValue = Math.max(maxValue, currentSize);
                }
            }
        }
        return maxValue;
    }

    public int markIsland(int code, int x, int y, int[][] grid) {
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] != 1)
            return 0;
        grid[x][y] = code;
        return 1 + markIsland(code, x + 1, y, grid)
                + markIsland(code, x - 1, y, grid)
                + markIsland(code, x, y + 1, grid)
                + markIsland(code, x, y - 1, grid);
    }
}
