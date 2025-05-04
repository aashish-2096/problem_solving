import java.util.ArrayList;
import java.util.List;

public class CycleDetectionUndirectedGraph {
     public ArrayList<ArrayList<Integer>> convertToAdjList(int [][]a, int V) {
        ArrayList<ArrayList<Integer>> adjListArray 
        = new ArrayList<ArrayList<Integer>>(V);
        for (int i = 0; i < V; i++) {
            adjListArray.add(new ArrayList<Integer>());
        }
        int i, j;
        for (i = 0; i < a.length; i++) {
            adjListArray.get(a[i][0]).add(a[i][1]);
            adjListArray.get(a[i][1]).add(a[i][0]);
        }
        return adjListArray;
    }
     public boolean dfsTraversal(int current, ArrayList<ArrayList<Integer>> adj, 
    boolean [] visited, int parent){
       if(visited[current]){
           return true;
       }
        visited[current] = true;
        List<Integer> curr = adj.get(current);
        for (int element : curr) {
            if(element != parent){
               if(dfsTraversal(element, adj, visited, current)){
                return true;   
               }
            }
        }
        return false;
    }
    
    public boolean isCycle(int V, int[][] edges) {
        boolean [] visited = new boolean[V];
        ArrayList<ArrayList<Integer>> adjList = convertToAdjList(edges,V);
        for(int i = 0;i<V;i++) {
            if(!visited[i]) {
                if(dfsTraversal(i,adjList, visited, -1)){
                    return true;
                }
            }
        }
        return false;
    }
}
