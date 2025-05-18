import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class MapHighestPeak_1765 {
    public boolean isValid(int row, int col, int[][] grid) {
        int rowG = grid.length;
        int colG = grid[0].length;
        if (row >= 0 && row < rowG && col >= 0 && col < colG) {
            return true;
        }
        return false;
    }

    public int[][] highestPeak(int[][] mat) {
        Queue<int[]> queues = new LinkedList<>();
        int row = mat.length;
        int col = mat[0].length;
        int[][] matrix = new int[row][col];
        boolean[][] visited = new boolean[row][col];
        for (int i = 0; i < row; i++) {
            Arrays.fill(matrix[i], Integer.MIN_VALUE);
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (mat[i][j] == 1) {
                    queues.add(new int[] { i, j });
                    matrix[i][j] = 0;
                }
            }
        }
        if (queues.size() == 0)
            return mat;
        int[] rowF = { -1, 0, 0, 1 };
        int[] colF = { 0, -1, 1, 0 };
        while (!queues.isEmpty()) {
            int[] arr = queues.poll();
            int rowR = arr[0];
            int colR = arr[1];
            for (int i = 0; i < 4; i++) {
                int nx = rowR + rowF[i];
                int ny = colR + colF[i];
                if (isValid(nx, ny, mat) && matrix[nx][ny] == Integer.MIN_VALUE) {
                    matrix[nx][ny] = matrix[rowR][colR] + 1;
                    queues.offer(new int[] { nx, ny });
                }
            }
        }
        return matrix;
    }
}
