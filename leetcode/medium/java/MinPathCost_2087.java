public class MinPathCost_2087 {
    public int minCost(int[] startPos, int[] homePos, int[] rowCosts, int[] colCosts) {
        int cost = 0;
        int x = startPos[0], y = startPos[1];
        int dx = homePos[0], dy = homePos[1];

        while (x != dx) {
            x += x < dx ? 1 : -1;
            cost += rowCosts[x];
        }

        while (y != dy) {
            y += y < dy ? 1 : -1;
            cost += colCosts[y];
        }

        return cost;
    }
}
