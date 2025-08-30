import java.util.Collections;
import java.util.PriorityQueue;

public class SortMatrixByDiag_3446 {
    private void sortWithStartIndex(int x, int y, int[][] grid, int n) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        if (y > 0) {
            pq = new PriorityQueue<>();
        }
        int col = y;
        int row = x;
        while (row < n && col < n) {
            pq.add(grid[row][col]);
            row++;
            col++;
        }
        col = y;
        row = x;
        while (row < n && col < n && !pq.isEmpty()) {
            int val = pq.poll();
            grid[row][col] = val;
            row++;
            col++;
        }
    }

    public int[][] sortMatrix(int[][] grid) {
        int n = grid.length;
        // bottom left 
        for (int i = 0; i < n; i++) {
            sortWithStartIndex(i, 0, grid, n);
        }
        for (int j = 1; j < n; j++) {
            sortWithStartIndex(0, j, grid, n);
        }
        // top left 
        return grid;
    }
}
