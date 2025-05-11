import java.util.ArrayList;
import java.util.List;

public class CycleDetectionDAG {
    public ArrayList<ArrayList<Integer>> convertToAdjList(int [][]a, int V) {
        ArrayList<ArrayList<Integer>> adjListArray 
        = new ArrayList<ArrayList<Integer>>(V);
        for (int i = 0; i < V; i++) {
            adjListArray.add(new ArrayList<Integer>());
        }
        int i, j;
        for (i = 0; i < a.length; i++) {
            adjListArray.get(a[i][0]).add(a[i][1]);
        }
        return adjListArray;
    }
    public boolean dfsTraversal(int current, ArrayList<ArrayList<Integer>> adj,  
    boolean [] visited, boolean [] recStack) {
        if (recStack[current]) return true;
        if (visited[current]) return false;
        visited[current] = true;
        recStack[current] = true;
        List<Integer> curr = adj.get(current);
        for (int element : curr) {
            if(dfsTraversal(element, adj, visited, recStack)){
             return true;   
            }
        }
        recStack[current] = false;
        return false;
    }
    
    public boolean isCyclic(int V, int[][] edges) {
        if(V<=0) return false;
        ArrayList<ArrayList<Integer>> adjList = convertToAdjList(edges,V);
        boolean [] visited = new boolean[V];
        boolean[] recStack = new boolean[V];
        for(int i = 0;i<V;i++) {
            if(!visited[i]) {
                if(dfsTraversal(i,adjList, visited, recStack)){
                    return true;
                }
            }
        }
        return false;
        
    }
}
