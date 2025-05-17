import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class SurroundedRegions_130 {
    static class SimplePair<K, V> {
        private K key;
        private V value;
    
        public SimplePair(K key, V value) {
            this.key = key;
            this.value = value;
        }
    
        public K getKey() {
            return key;
        }
    
        public V getValue() {
            return value;
        }
    }
    int[] rowF = { -1, 0, 0, 1 };
    int[] colF = { 0, -1, 1, 0 };
    public boolean isSafe(char[][] board, boolean[][] visited, int r, int c) {
        int row = board.length;
        int col = board[0].length;
        if (r > 0 && r < row - 1 && c > 0 && c < col - 1 && !visited[r][c] && board[r][c] == 'O') {
            return true;
        }
        return false;
    }

    public boolean isValid(char[][] board, int r, int c, Set<String> paths) {
        int row = board.length;
        int col = board[0].length;
        if (r >= 0 && r < row  && c >= 0 && c < col && (board[r][c] == 'X'
                || (board[r][c] == 'O' && paths.contains(r + "-" + c)))) {
            return true;
        }
        return false;
    }

    public Set<String> getPath(char[][] board, boolean[][] visited, int x, int y) {
        Set<String> hashSet = new HashSet<>();
        Queue<SimplePair<Integer, Integer>> path = new LinkedList();
        path.add(new SimplePair(x, y));
        while (!path.isEmpty()) {
            SimplePair<Integer, Integer> pr = path.poll();
            int index_X = pr.getKey();
            int index_Y = pr.getValue();
            if (visited[index_X][index_Y]) {
                continue;
            }
            visited[index_X][index_Y] = true;
            hashSet.add(String.join("-", String.valueOf(index_X), String.valueOf(index_Y)));
            for (int i = 0; i < 4; i++) {
                int ind_x = index_X + rowF[i];
                int ind_y = index_Y + colF[i];
                if (isSafe(board, visited, ind_x, ind_y)) {
                    path.add(new SimplePair(ind_x, ind_y));
                }
            }
        }
        return hashSet;
    }

    public void solve(char[][] board) {
        int row = board.length;
        int col = board[0].length;
        boolean[][] visited = new boolean[row][col];
        ArrayList<SimplePair<Integer, Integer>> zeroes = new ArrayList<>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == 'O') {
                    zeroes.add(new SimplePair(i, j));
                }
            }
        }
        ArrayList<Set<String>> path = new ArrayList<>();
        for (int i = 0; i < zeroes.size(); i++) {
            int x = zeroes.get(i).getKey();
            int y = zeroes.get(i).getValue();
            if (!visited[x][y]) {
                Set<String> pathTraversed = getPath(board, visited, x, y);
                checkAndUpdate(pathTraversed, board);
            }
        }
    }

    private void checkAndUpdate(Set<String> path, char[][] board) {
        int count = 0;
        for (String s : path) {
            String[] arr = s.split("-");
            int x = Integer.valueOf(arr[0]);
            int y = Integer.valueOf(arr[1]);
            boolean status = true;
            for (int i = 0; i < 4; i++) {
                int ind_x = x + rowF[i];
                int ind_y = y + colF[i];
                status = status && isValid(board, ind_x, ind_y, path);
            }
            if (status) {
                count += 1;
            }
        }
        if (count == path.size()) {
            for (String s : path) {
                String[] arr = s.split("-");
                int x = Integer.valueOf(arr[0]);
                int y = Integer.valueOf(arr[1]);
                board[x][y] = 'X';
            }
        }
    }
}

