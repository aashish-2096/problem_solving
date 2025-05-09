import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Dijkstra {
    static class SimplePair{
        int key;
        int value;

        SimplePair(int key, int value) {
            this.key = key;
            this.value = value;
        }
        
        int getKey(){
            return this.key;
        }
    }
    public ArrayList<ArrayList<SimplePair>> convertToAdjList(int[][] a, int V) {
        ArrayList<ArrayList<SimplePair>> adjListArray = 
        new ArrayList<ArrayList<SimplePair>>(V);
        for (int i = 0; i < V; i++) {
            adjListArray.add(new ArrayList<SimplePair>());
        }
        int i, j;
        for (i = 0; i < a.length; i++) {
            adjListArray.get(a[i][0]).add(new SimplePair(a[i][1], a[i][2]));
        }
        return adjListArray;
    }
    public int[] dijkstra(int V, int[][] edges, int src) {
        ArrayList<ArrayList<SimplePair>> adjList =  convertToAdjList(edges, V);
        PriorityQueue<SimplePair> pq = new  PriorityQueue<>(Comparator.comparingInt(SimplePair::getKey));
        int [] minPath = new int [V];
        Arrays.fill(minPath, Integer.MAX_VALUE);
        pq.add(new SimplePair(0, src));
        minPath[src] = 0;
        while(!pq.isEmpty()){
            SimplePair pr = pq.poll();        
            int dist = pr.key;
            int node = pr.value;
            for(SimplePair element : adjList.get(node)){
                int weight = element.value + dist;
                if(weight < minPath[element.key]){
                    minPath[element.key] = weight;
                    pq.add(new SimplePair(weight, element.key));
                }
            }
        }
        return minPath;
    }
}
