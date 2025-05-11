import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MinTimeToReachLastRoom_II_3342 {
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

    static class Node {
        int x;
        int y;
        int steps;

        public Node(int x, int y, int steps) {
            this.x = x;
            this.y = y;
            this.steps = steps;
        }

        public int getX() {
            return this.x;
        }

        public int getY() {
            return this.y;
        }

        public int getSteps() {
            return this.steps;
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
        PriorityQueue<SimplePair<Integer, Node>> pr = new PriorityQueue<>(
                Comparator.comparingInt(pair -> pair.getKey()));
        pr.add(new SimplePair(0, new Node(0, 0, 0)));
        int[] rowF = { -1, 0, 0, 1 };
        int[] colF = { 0, -1, 1, 0 };
        while (!pr.isEmpty()) {
            SimplePair<Integer, Node> item = pr.poll();
            int currTime = item.getKey();
            int index_X = item.getValue().getX();
            int index_Y = item.getValue().getY();
            int steps = item.getValue().getSteps();
            if (visited[index_X][index_Y])
                continue;
            visited[index_X][index_Y] = true;
            path[index_X][index_Y] = Math.min(currTime, path[index_X][index_Y]);
            steps += 1;
            for (int i = 0; i < 4; i++) {
                int ind_x = index_X + rowF[i];
                int ind_y = index_Y + colF[i];
                if (isSafe(move, ind_x, ind_y, visited)) {
                    int time = move[ind_x][ind_y];
                    int timeVal = steps % 2 == 0 ? 2 : 1;
                    if (time <= currTime) {
                        pr.add(new SimplePair<>(currTime + timeVal, new Node(ind_x, ind_y, steps)));
                    } else {
                        pr.add(new SimplePair<>((time + timeVal), new Node(ind_x, ind_y, steps)));
                    }
                }
            }
        }
        return path[row - 1][col - 1];
    }
}
