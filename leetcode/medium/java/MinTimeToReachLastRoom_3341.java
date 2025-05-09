import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MinTimeToReachLastRoom_3341 {
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

    public boolean isSafe(int[][] move, int r, int c, boolean[][] visited) {
        int row = move.length;
        int col = move[0].length;
        if (r >= 0 && r < row && c >= 0 && c < col && !visited[r][c]) {
            return true;
        }
        return false;
    }

    public int minTimeToReach(int[][] move) {
        int row = move.length;
        int col = move[0].length;
        int[][] path = new int[row][col];
        boolean[][] visited = new boolean[row][col];
        for (int i = 0; i < row; i++) {
            Arrays.fill(path[i], Integer.MAX_VALUE);
        }
        PriorityQueue<SimplePair<Integer, SimplePair<Integer, Integer>>> pr =
    new PriorityQueue<>(Comparator.comparingInt(pair -> pair.getKey()));
        int maxCurrTime = 0;
        pr.add(new SimplePair(0, new SimplePair(0, 0)));
        int[] rowF = { -1, 0, 0, 1 };
        int[] colF = { 0, -1, 1, 0 };
        while (!pr.isEmpty()) {
            SimplePair<Integer, SimplePair<Integer, Integer>> item = pr.poll();
            int currTime = item.getKey();
            int index_X = item.getValue().getKey();
            int index_Y = item.getValue().getValue();
            if (visited[index_X][index_Y]) continue;
            visited[index_X][index_Y] = true;
            path[index_X][index_Y] = Math.min(currTime, path[index_X][index_Y]);
            for (int i = 0; i < 4; i++) {
                int ind_x = index_X + rowF[i];
                int ind_y = index_Y + colF[i];
                int minPath = Integer.MAX_VALUE;
                int min_x = -1, min_y = -1;
                if (isSafe(move, ind_x, ind_y, visited)) {
                    int time = move[ind_x][ind_y];
                    if (time <= currTime) {
                        pr.add(new SimplePair<>(currTime + 1, new SimplePair<>(ind_x, ind_y)));
                    } else {
                        pr.add(new SimplePair<>((time + 1), new SimplePair<>(ind_x, ind_y)));
                    }
                }
            }
        }
        return path[row - 1][col - 1];
    }
}
