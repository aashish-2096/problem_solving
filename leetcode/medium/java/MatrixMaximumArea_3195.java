public class MatrixMaximumArea_3195 {
    public int minimumArea(int[][] grid) {
        int xLeft = Integer.MAX_VALUE, xRight = Integer.MIN_VALUE, yLeft = Integer.MAX_VALUE,
                yRight = Integer.MIN_VALUE;
        int row = grid.length;
        int col = grid[0].length;
        int width = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1) {
                    xLeft = Math.min(xLeft, i);
                    xRight = Math.max(xRight, i);
                    yLeft = Math.min(yLeft, j);
                    yRight = Math.max(yRight, j);
                }
            }
        }
        int x = xRight - xLeft + 1;
        int y = yRight - yLeft + 1;
        width = x * y;
        return width;
    }
}
