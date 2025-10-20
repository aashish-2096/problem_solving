package graphs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * DFS Implementation.
 */
public class ConnectedComponents_323 {
    private ArrayList<ArrayList<Integer>> getAdjList(int n, int[][] edges){
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<ArrayList<Integer>>(n);
        for(int i = 0;i<n;i++){
            adjList.add(new ArrayList<>());
        }
        for(int i = 0;i<edges.length;i++){
            int src = edges[i][0];
            int dest = edges[i][1];
            adjList.get(src).add(dest);
            adjList.get(dest).add(src);
        }
        return adjList;
    }

    private void dfs(Set<Integer> visited, ArrayList<ArrayList<Integer>> adjList, int node) {
        for (Integer path : adjList.get(node)) {
            if (!visited.contains(path)) {
                visited.add(path);
                dfs(visited, adjList, path);
            }
        }
    }

    public int countComponents(int n, int[][] edges) {
        ArrayList<ArrayList<Integer>> adjList = getAdjList(n, edges);
        int count = 0;
        Set<Integer>visited = new HashSet<>();
        for (int i = 0; i < n; i++) {
            ArrayList<Integer> adj = adjList.get(i);
            if (!visited.contains(i)) {
                count++;
                visited.add(i);
                dfs(visited, adjList, i);
            }
        }
        return count;

    }
}
