package graphs;

public class UnionFind_547 {
    class UnionFind {
        int[] rank, parent;
        int n;

        public UnionFind(int n) {
            this.rank = new int[n];
            this.parent = new int[n];
            this.n = n;
            for (int i = 0; i < n; i++) {
                this.parent[i] = i;
            }
        }

        public int find(int i) {
            int root = this.parent[i];
            if (this.parent[root] != root) {
                this.parent[i] = find(root);
                return this.parent[i];
            }
            return root;
        }

        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX == rootY) {
                return;
            }
            if (rank[rootX] < rank[rootY]) {
                parent[rootX] = rootY;
            } else if (rank[rootY] < rank[rootX]) {
                parent[rootY] = rootX;
            } else {
                parent[rootY] = rootX;
                rank[rootX] = rank[rootX] + 1;
            }
        }

        public int getUniqueRanks() {
            int count = 0;
            for (int i = 0; i < n; i++) {
                if (parent[i] == i) {
                    count++;
                }
            }
            return count;
        }
    }

    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        UnionFind uf = new UnionFind(n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j && isConnected[i][j] == 1) {
                    uf.union(i, j);
                }
            }
        }
        return uf.getUniqueRanks();
    }
}
