package recursion_dp;

public class WordSearch_79 {
    boolean indexValid(int x, int y, char[][] board) {
        return x >= 0 && x < board.length && y >= 0 && y < board[0].length;
    }

    boolean status(int x, int y, int idx, char[][] board, String word, boolean[][] visited) {
        if (idx == word.length()) {
            return true;
        }
        if (!indexValid(x, y, board) || idx > word.length() || visited[x][y] || board[x][y] != word.charAt(idx)) {
            return false;
        }
        visited[x][y] = true;
        boolean front = status(x + 1, y, idx + 1, board, word, visited);
        boolean back = status(x - 1, y, idx + 1, board, word, visited);
        boolean low = status(x, y + 1, idx + 1, board, word, visited);
        boolean high = status(x, y - 1, idx + 1, board, word, visited);
        boolean status = front || back || low || high;
        visited[x][y] = false;
        return status;
    }

    public boolean exist(char[][] board, String word) {
        char firstChar = word.charAt(0);
        int row = board.length;
        int col = board[0].length;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] - firstChar == 0) {
                    boolean[][] visited = new boolean[row][col];
                    boolean res = status(i, j, 0, board, word, visited);
                    if (res)
                        return res;
                }
            }
        }
        return false;
    }
}
