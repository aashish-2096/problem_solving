import java.util.ArrayList;

public class NumberOfProvince_547 {
    class Solution {
    public ArrayList<ArrayList<Integer>> convertToAdjList(int[][] a) {
        int V = a.length;
        ArrayList<ArrayList<Integer>> adjListArray = new ArrayList<ArrayList<Integer>>(V);
        for (int i = 0; i < V; i++) {
            adjListArray.add(new ArrayList<Integer>());
        }
        int i, j;
        for (i = 0; i < V; i++) {
            for (j = 0; j < V; j++) {
                if (a[i][j] != 0 && i != j) {
                    adjListArray.get(i).add(j);
                }
            }
        }
        return adjListArray;
    }

    public void dfs(int index, boolean[] visited, ArrayList<ArrayList<Integer>> adjList) {
        if (visited[index]) {
            return;
        }
        visited[index] = true;
        ArrayList<Integer> neighbor = adjList.get(index);
        for (int i : neighbor) {
            dfs(i, visited, adjList);
        }
    }

    public int findCircleNum(int[][] isConnected) {
        int V = isConnected.length;
        boolean[] visited = new boolean[V];
        ArrayList<ArrayList<Integer>> adjList = convertToAdjList(isConnected);
        int components = 0;
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                components += 1;
                dfs(i, visited, adjList);
            }
        }
        return components;
    }
}
}
