import java.util.LinkedList;
import java.util.Queue;

public class RottenOranges_994 {
    class Solution {
    public boolean isValid(int row, int col, int[][] grid) {
        int rowG = grid.length;
        int colG = grid[0].length;
        if (row >= 0 && row < rowG && col >= 0 && col < colG && grid[row][col] == 1) {
            return true;
        }
        return false;
    }

    public int orangesRotting(int[][] grid) {
        Queue<int [] > queue = new LinkedList<>();
        int row = grid.length;
        int col = grid[0].length;
        int fresh = 0;
        int count = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 2) {
                    queue.add(new int []{i, j});
                } else if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }
        if (fresh == 0) {
            return 0;
        }
        int[] rowF = { -1, 0, 0, 1 };
        int[] colF = { 0, -1, 1, 0 };
        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean initiated = false;
            for (int i = 0; i < size; i++) {
                int [] arr = queue.poll();
                for (int j = 0; j < 4; j++) {
                    int r = arr[0] + rowF[j];
                    int c = arr[1] + colF[j];
                    if (isValid(r, c, grid)) {
                        grid[r][c] = 2;
                         queue.add(new int []{r, c});
                        initiated = true;
                        fresh--;
                    }
                }
            }
            if (initiated) {
                count += 1;
            }
        }
        return fresh <= 0 ? count : -1;
    }
}
}
