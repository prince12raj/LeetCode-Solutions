class Solution {
    class DSU{
        int parent [];
        int size [];
        DSU(int n){
            parent = new int [n];
            size = new int [n];
            for(int i =0 ; i < n ; i++){
                parent[i] = i;
                size[i]= 1;
            }
        }
        int find(int x){
            if(parent[x] == x) return x;
            return parent[x] = find(parent[x]);
        }
        boolean union(int x, int y){
            int px = find(x);
            int py = find(y);
            if(px == py) return false ;
            if(size[px] < size[py]){
                parent[px] = py;
                size[py] += size[px];
            }else{
                parent[py] = px;
                size[px] += size[py];
            }
            return true;
        }
    }
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        int m =  points[0].length;
        ArrayList<int[]> adj = new ArrayList<>();
        for(int i =0; i < n ; i++){
            for(int j = i+1 ; j < n ; j++){
                int dist = Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);
                adj.add(new int[]{dist, i ,j});
            }
        }
        Collections.sort(adj ,(a,b) -> a[0]-b[0]);
        DSU dsu = new DSU(n);
        int usedadge =0;
        int mstcost =0;
        for(int e[] : adj){
            if(dsu.union(e[1], e[2])){
                mstcost += e[0];
                usedadge++;
                if(usedadge == n-1) break;
            }
        }
        return mstcost;
    }
}