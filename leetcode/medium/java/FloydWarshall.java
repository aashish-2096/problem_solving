public class FloydWarshall {
    public void floydWarshall(int[][] dist) {
        int size = dist.length;
         for(int i = 0;i<size;i++){
             dist[i][i] = 0;
         }
        for(int k = 0;k<size;k++){
            for(int i = 0;i<size;i++){
                for(int j = 0;j<size;j++){
                    if(dist[i][k] != 1e8 && dist[k][j] != 1e8){
                         dist[i][j] = Math.min(dist[i][j], (int)(dist[i][k] + dist[k][j]));
                     }
                }
            }
        }
     }
}