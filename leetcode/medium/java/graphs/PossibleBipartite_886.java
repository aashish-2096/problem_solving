package graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PossibleBipartite_886 {
    public ArrayList<ArrayList<Integer>> convertToAdjList(int[][] a, int V) {
        ArrayList<ArrayList<Integer>> adjListArray = new ArrayList<ArrayList<Integer>>(V);
        for (int i = 0; i < V; i++) {
            adjListArray.add(new ArrayList<Integer>());
        }
        for (int i = 0; i < a.length; i++) {
            adjListArray.get(a[i][0]).add(a[i][1]);
            adjListArray.get(a[i][1]).add(a[i][0]);
        }
        return adjListArray;
    }

    public boolean dfs(int index, int nodeColor, ArrayList<ArrayList<Integer>> adjList, int[] color) {
        color[index] = nodeColor;
        List<Integer> nextNodes = adjList.get(index);
        for (int i : nextNodes) {
            if (color[i] == nodeColor) {
                return false;
            } else if (color[i] == -1) {
                if (!dfs(i, 1 - nodeColor, adjList, color)) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean possibleBipartition(int n, int[][] dislikes) {
        ArrayList<ArrayList<Integer>> adjList = convertToAdjList(dislikes, n + 1);
        if (adjList.isEmpty())
            return true;
        int[] colors = new int[n + 1];
        Arrays.fill(colors, -1);
        for (int i = 0; i <= n; i++) {
            if (colors[i] == -1) {
                if (!dfs(i, 0, adjList, colors)) {
                    return false;
                }
            }
        }
        return true;

    }
}
