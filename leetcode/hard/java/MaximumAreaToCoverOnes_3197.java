package leetcode.hard.java;

public class MaximumAreaToCoverOnes_3197 {
    int minSum = Integer.MAX_VALUE;

    public int minimumArea(int[][] grid, int x1, int y1, int x2, int y2) {
        int xLeft = Integer.MAX_VALUE, xRight = Integer.MIN_VALUE, yLeft = Integer.MAX_VALUE,
                yRight = Integer.MIN_VALUE;
        int row = grid.length;
        int col = grid[0].length;
        int width = 0;
        for (int i = x1; i <= x2; i++) {
            for (int j = y1; j <= y2; j++) {
                if (i < row && j < col && grid[i][j] == 1) {
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

    public int minimumSum(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int count = countOnes(grid);
        if (count == 3) {
            return 3;
        }

        for (int j1 = 0; j1 < col - 2; j1++) {
            for (int j2 = j1 + 1; j2 < col - 1; j2++) {
                int left = minimumArea(grid, 0, 0, row - 1, j1);
                int mid = minimumArea(grid, 0, j1 + 1, row - 1, j2);
                int right = minimumArea(grid, 0, j2 + 1, row - 1, col - 1);
                minSum = Math.min(minSum, left + mid + right);
            }
        }

        // --- CASE 2: Three horizontal strips ---
        for (int i1 = 0; i1 < row - 2; i1++) {
            for (int i2 = i1 + 1; i2 < row - 1; i2++) {
                int top = minimumArea(grid, 0, 0, i1, col - 1);
                int mid = minimumArea(grid, i1 + 1, 0, i2, col - 1);
                int bottom = minimumArea(grid, i2 + 1, 0, row - 1, col - 1);
                minSum = Math.min(minSum, top + mid + bottom);
            }
        }

        for (int i = 0; i < row - 1; i++) {
            for (int j = 0; j < col - 1; j++) {
                int vertical = minimumArea(grid, 0, 0, row, j);
                int hTop = minimumArea(grid, 0, j + 1, i, col);
                int hBottom = minimumArea(grid, i + 1, j + 1, row, col);
                int sum = hTop + vertical + hBottom;
                this.minSum = Math.min(this.minSum, sum);

                int vertical2 = minimumArea(grid, 0, 0, i, col);
                int hTop2 = minimumArea(grid, i + 1, 0, row, j);
                int hBottom2 = minimumArea(grid, i + 1, j + 1, row, col);
                int sum2 = hTop2 + vertical2 + hBottom2;
                this.minSum = Math.min(this.minSum, sum2);

                int vertical3 = minimumArea(grid, 0, 0, i, j);
                int hTop3 = minimumArea(grid, i + 1, 0, row, j);
                int hBottom3 = minimumArea(grid, 0, j + 1, row, col);
                int sum3 = hTop3 + vertical3 + hBottom3;
                this.minSum = Math.min(this.minSum, sum3);

                int vertical4 = minimumArea(grid, 0, 0, i, j);
                int hTop4 = minimumArea(grid, 0, j + 1, i, col);
                int hBottom4 = minimumArea(grid, i + 1, 0, row, col);
                int sum4 = hTop4 + vertical4 + hBottom4;
                this.minSum = Math.min(this.minSum, sum4);
            }
        }
        return this.minSum;
    }

    int countOnes(int[][] grid) {
        int count = 0;
        int row = grid.length;
        int col = grid[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1) {
                    count += 1;
                }
            }
        }
        return count;
    }
}
