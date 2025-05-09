import java.util.Arrays;

public class BellmanFord {
    public int[] bellmanFord(int V, int[][] edges, int source) {
       int [] minPath = new int[V];
       Arrays.fill(minPath, (int) 1e8);
       minPath[source] = 0;
       for(int i = 0;i<V-1;i++) {
           for(int[] edge: edges){
               int src = edge[0];
               int dest = edge[1];
               int weight = edge[2];
            if(minPath[src] != (int)1e8 && minPath[src] + weight < minPath[dest]) {
                minPath[dest] = minPath[src] + weight;
            }   
           }
       }
       for(int[] edge: edges){
           int src = edge[0];
           int dest = edge[1];
           int weight = edge[2];
        if(minPath[src] != (int)1e8 && minPath[src] + weight < minPath[dest]) {
            return new int [] {-1};
        }   
       }
       return minPath;
    }
}
