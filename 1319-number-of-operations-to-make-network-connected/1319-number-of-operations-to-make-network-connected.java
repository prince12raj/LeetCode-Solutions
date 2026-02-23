class Solution {
    private class DSU{
        int [] parent ;
        int [] size ;
        int component;
        DSU(int n){
            parent = new int[n];
            size = new int[n];
            component = n;
                for(int i = 0; i < n ; i++){
                parent[i] =i;
                size[i] =1;
            }
        }
        int find(int x){
            if(parent[x] == x){
                return x;
            }
            return parent[x] = find(parent[x]);
        }
        boolean union(int x ,int y){
            int px = find(x);
            int py = find(y);
            if(px == py) return false;
            if(size[px] < size[py]){
                parent[px] = py;
                size[py] += size[px];
            }
            else{
                parent[py] =px;
                size[px] +=size[py];
            }
            component--;
            return true;
        }
    }
    public int makeConnected(int n, int[][] connections) {
        if(connections.length < n-1){
            return -1;
        }
        DSU dsu = new DSU(n);
        for(int edge[] : connections){
            int u = edge[0];
            int v = edge[1];
            dsu.union(u ,v);
        }
        return dsu.component-1;
    }
}