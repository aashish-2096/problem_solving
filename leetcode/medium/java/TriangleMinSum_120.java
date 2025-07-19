import java.util.ArrayList;
import java.util.List;

public class TriangleMinSum_120 {
    int minSum(int i, int j, List<List<Integer>> triangle, List<List<Integer>> dp) {
        int row = triangle.size();
        if (i >= row) {
            return Integer.MAX_VALUE;
        }
        int col = triangle.get(i).size();
        if (j >= col) {
            return Integer.MAX_VALUE;
        }
        if (i == row - 1) {
            return triangle.get(i).get(j);
        }
        if (dp.get(i).get(j) != -1) {
            return dp.get(i).get(j);
        }
        int down = minSum(i + 1, j, triangle, dp);
        int next = minSum(i + 1, j + 1, triangle, dp);
        int value = Math.min(down, next) + triangle.get(i).get(j);
        dp.get(i).set(j, value);
        return value;
    }

    public int minimumTotal(List<List<Integer>> triangle) {
        int row = triangle.size();
        List<List<Integer>> dp = new ArrayList<>();
        for (int i = 0; i < row; i++) {
            List<Integer> rowC = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                rowC.add(-1);
            }
            dp.add(rowC);
        }
        return minSum(0, 0, triangle, dp);
    }
}
