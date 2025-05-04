import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class TopoSort {
    public static ArrayList<ArrayList<Integer>> convertToAdjList(int[][] a, int V) {
        ArrayList<ArrayList<Integer>> adjListArray = new ArrayList<ArrayList<Integer>>(V);
        for (int i = 0; i < V; i++) {
            adjListArray.add(new ArrayList<Integer>());
        }
        int i, j;
        for (i = 0; i < a.length; i++) {
            adjListArray.get(a[i][0]).add(a[i][1]);
        }
        return adjListArray;
    }
    
    public static void dfsTraversal(int current, ArrayList<ArrayList<Integer>> adj,
            boolean[] visited, Stack<Integer>callStack) {
        if (visited[current])
            return;
        visited[current] = true;
        List<Integer> curr = adj.get(current);
        for (int element : curr) {
            dfsTraversal(element, adj, visited, callStack);
        }
        callStack.push(current);
    }
    
    public static ArrayList<Integer> topoSort(int V, int[][] edges) {
        List<Integer> path = new ArrayList<>();
       if (V > 0) {
            ArrayList<ArrayList<Integer>> adjList = convertToAdjList(edges, V);
            boolean[] visited = new boolean[V];
            Stack<Integer>callStack = new Stack<>();
            for (int i = 0; i < V; i++) {
                if (!visited[i]) {
                    dfsTraversal(i, adjList, visited, callStack);
                }
            }

            while(!callStack.isEmpty()){
                int val = callStack.pop();
                path.add(val);
            }
       }
    return new ArrayList<>(path);
    }
}
