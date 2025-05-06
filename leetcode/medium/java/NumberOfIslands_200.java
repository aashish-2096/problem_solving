public class NumberOfIslands_200 {
    class Solution {
        public boolean check(int row, int col, char[][] grid, boolean[][] visited) {
            int rowG = grid.length;
            int colG = grid[0].length;
            if (row >= 0 && row < rowG && col >= 0 && col < colG && !visited[row][col] && grid[row][col] == '1') {
                return true;
            }
            return false;
        }
    
        public void dfs(int row, int col, char[][] grid, boolean[][] visited) {
            visited[row][col] = true;
            int[] rowF = { -1, 0, 0, 1 };
            int[] colF = { 0, -1, 1, 0 };
            for (int i = 0; i < 4; i++) {
                int r = row + rowF[i];
                int c = col + colF[i];
                if (check(r, c, grid, visited)) {
                    dfs(r, c, grid, visited);
                }
            }
        }
    
        public int numIslands(char[][] grid) {
            int row = grid.length;
            int col = grid[0].length;
            int count = 0;
            boolean[][] visited = new boolean[row][col];
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (grid[i][j] == '1' && !visited[i][j]) {
                        dfs(i, j, grid, visited);
                        count++;
                    }
                }
            }
            return count;
        }
    }
}
