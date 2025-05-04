import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class GraphTraversal {
     public ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj) {
        List<Integer>path = new ArrayList<>();
        Queue<Integer>queue = new LinkedList<>();
        Map<Integer, Integer> visited = new HashMap<>();
        queue.add(0);
        visited.put(0,1);
        while(!queue.isEmpty()){
          int current = queue.poll();
          path.add(current);
          List<Integer> curr = adj.get(current);
          for (int element : curr) {
              if(!visited.containsKey(element)){
                    queue.add(element);
                    visited.put(element,1);
              }
            }
        }
        return new ArrayList<>(path);
    }

    public void dfsTraversal(int current, ArrayList<ArrayList<Integer>> adj, 
    List<Integer>path, Map<Integer, Integer> visited){
       if(visited.containsKey(current)){
           return;
       }
        path.add(current);
        visited.put(current,1);
        List<Integer> curr = adj.get(current);
        for (int element : curr) {
            if(!visited.containsKey(element)){
                dfsTraversal(element, adj, path, visited);
            }
        }
    }
    public ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adj) {
        List<Integer>path = new ArrayList<>();
        Map<Integer, Integer> visited = new HashMap<>();
        dfsTraversal(0, adj, path, visited);
        return new ArrayList<>(path);
        
    }
}
