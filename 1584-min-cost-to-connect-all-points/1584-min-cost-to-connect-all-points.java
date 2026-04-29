class Solution {
    class DSU {
        int[] parent;
        int[] size;
        
        DSU(int n) {
            parent = new int[n];
            size = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        } 
        int find(int i) {
            if (parent[i] == i) return i;
            return parent[i] = find(parent[i]);
        }
        boolean union(int i, int j) {
            int pi = find(i);
            int pj = find(j);
            if (pi == pj) return false;
            if (size[pi] < size[pj]) {
                parent[pi] = pj;
                size[pj] += size[pi];
            } else {
                parent[pj] = pi;
                size[pi] += size[pj];
            }
            return true;
        }
    }
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        List<int[]> edges = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int dist = Math.abs(points[i][0] - points[j][0]) + 
                           Math.abs(points[i][1] - points[j][1]);
                edges.add(new int[]{dist, i, j});
            }
        }
        Collections.sort(edges, (a, b) -> a[0] - b[0]);
        
        DSU dsu = new DSU(n);
        int mstCost = 0;
        int edgesUsed = 0;
        
        for (int[] edge : edges) {
            if (dsu.union(edge[1], edge[2])) {
                mstCost += edge[0];
                edgesUsed++;
                if (edgesUsed == n - 1) break;
            }
        }
        
        return mstCost;
    }
}