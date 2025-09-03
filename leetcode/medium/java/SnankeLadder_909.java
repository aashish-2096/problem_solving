import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class SnankeLadder_909 {
    public class SimplePair {
        int x;
        int y;

        SimplePair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        int getX() {
            return this.x;
        }

        int getY() {
            return this.y;
        }
    }

    private List<Integer> getPossibleRanges(int current, int n) {
        List<Integer> ranges = new ArrayList<>();
        for (int i = 1; i <= 6; i++) {
            int val = current + i;
            if (val <= n * n) {
                ranges.add(val);
            }
        }
        return ranges;
    }

    public int snakesAndLadders(int[][] board) {
        Map<Integer, SimplePair> mp = new HashMap<>();
        int n = board.length;
        int row = n, col = n;
        int target = n * n;
        int i = n - 1, j = 0;
        boolean right = true, left = false;
        int start = 1;
        boolean leftToRight = true;
        for (int r = n - 1; r >= 0; r--) {
            if (leftToRight) {
                for (int c = 0; c < n; c++) {
                    mp.put(start++, new SimplePair(r, c));
                }
            } else {
                for (int c = n - 1; c >= 0; c--) {
                    mp.put(start++, new SimplePair(r, c));
                }
            }
            leftToRight = !leftToRight;
        }
        Queue<Integer> qu = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        qu.add(1);
        visited.add(1);
        int length = 0;
        while (!qu.isEmpty()) {
            int size = qu.size();
            for (int iQ = 0; iQ < size; iQ++) {
                int current = qu.poll();
                if (current == target) {
                    return length;
                }
                SimplePair pr = mp.getOrDefault(current, null);
                if (pr != null) {
                    List<Integer> availableOptions = getPossibleRanges(current, n);
                    for (Integer num : availableOptions) {
                        SimplePair tg = mp.getOrDefault(num, null);
                        int x = tg.getX();
                        int y = tg.getY();
                        int next = num;
                        if (x < n && y < n && board[x][y] != -1) {
                            next = board[x][y];
                        }
                        if (!visited.contains(next)) {
                            qu.add(next);
                            visited.add(next);
                        }
                    }
                }
            }
            length++;
        }
        return -1;
    }
}
