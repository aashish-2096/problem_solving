import java.util.ArrayList;
import java.util.List;

public class DiagonalTraverse_498 {
    public int[] findDiagonalOrder(int[][] mat) {
        List<Integer> arr = new ArrayList<>();
        int row = mat.length;
        int col = mat[0].length;
        int i = 0, j = 0;
        boolean left = false, right = false;
        while (i < row && j < col && i >= 0 && j >= 0) {
            if (i == 0 && j == 0) {
                arr.add(mat[i][j]);
                left = true;
                j = j + 1;
                if (col == 1) {
                    right = true;
                    right = false;
                    i = i + 1;
                    j = 0;
                }
            }
            if (left) {
                while (j >= 0 && i >= 0 && i < row && j < col) {
                    arr.add(mat[i][j]);
                    j = j - 1;
                    i = i + 1;
                }
                if (i >= row) {
                    j = j + 2;
                    i = row - 1;
                } else if (j < 0) {
                    j = 0;
                }
                right = true;
                left = false;
            } else if (right) {
                while (j < col && i >= 0 && i < row && j >= 0) {
                    arr.add(mat[i][j]);
                    j = j + 1;
                    i = i - 1;
                }
                if (j >= col) {
                    j = col - 1;
                    i = i + 2;
                } else if (i < 0) {
                    i = 0;
                }
                right = false;
                left = true;
            }
            if (i == row - 1 && j == col - 1) {
                arr.add(mat[i][j]);
                break;
            }
        }

        return arr.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }
}
