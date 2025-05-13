import java.util.ArrayList;
import java.util.List;

public class EventualSafeState_802 {
    public static boolean dfsTraversal(int current, int[][] adj, boolean[] visited, boolean[] isSafe) {
        if (visited[current])
            return isSafe[current];
        visited[current] = true;
        int[] curr = adj[current];
        boolean nodeStatus = true;
        for (int element : curr) {
            boolean status = dfsTraversal(element, adj, visited, isSafe);
            nodeStatus = status && nodeStatus;
        }
        isSafe[current] = nodeStatus;
        return nodeStatus;
    }

    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> path = new ArrayList<>();
        int V = graph.length;
        if (V > 0) {
            boolean[] visited = new boolean[V];
            boolean[] isSafe = new boolean[V];
            for (int i = 0; i < V; i++) {
                if (!visited[i]) {
                    dfsTraversal(i, graph, visited, isSafe);
                }
            }
            for (int i = 0; i < V; i++) {
                if (isSafe[i])
                    path.add(i);
            }
        }
        return path;
    }
}
