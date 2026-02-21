package leetcode.hard.LinkedIn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LargestColorValue_1857 {
    public int dfs(int node, Map<Integer, List<Integer>> adjList, boolean[] visited,
            int[][] count, boolean[] recurStack, String colors) {
        if (recurStack[node]) {
            return Integer.MAX_VALUE;
        }
        if (visited[node]) {
            return count[node][colors.charAt(node) - 'a'];
        }
        visited[node] = true;
        if (adjList.containsKey(node)) {
            recurStack[node] = true;
            for (int i : adjList.get(node)) {
                if (dfs(i, adjList, visited, count, recurStack, colors) == Integer.MAX_VALUE) {
                    return Integer.MAX_VALUE;
                }
                for (int j = 0; j < 26; j++) {
                    count[node][j] = Math.max(count[node][j], count[i][j]);
                }
            }
            recurStack[node] = false;
        }
        count[node][colors.charAt(node) - 'a'] += 1;
        return count[node][colors.charAt(node) - 'a'];
    }

    public int largestPathValue(String colors, int[][] edges) {
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        int len = colors.length();
        for (int i = 0; i < edges.length; i++) {
            int from = edges[i][0];
            int to = edges[i][1];
            if (!adjList.containsKey(from)) {
                adjList.put(from, new ArrayList<>());
            }
            adjList.get(from).add(to);
        }
        boolean[] visited = new boolean[len];
        boolean[] recurStack = new boolean[len];
        int[][] count = new int[len][26];
        int maxVal = 0;
        for (int i = 0; i < len; i++) {
            int res = dfs(i, adjList, visited, count, recurStack, colors);
            if (res == Integer.MAX_VALUE) {
                return -1;
            }
            maxVal = Math.max(maxVal, res);
        }
        return maxVal == Integer.MAX_VALUE ? -1 : maxVal;
    }
}
