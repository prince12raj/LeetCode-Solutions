class DSU{
    int parent[];
    int size[];
    int component;
    DSU(int n){
        parent = new int[n];
        size = new int [n];
        component = n;

        for(int i = 0 ; i < n ; i ++){
            parent[i] =i;
            size[i] = i;
        }
    }
    int find(int x){
        if(parent[x] == x)return x;
        return parent[x]= find(parent[x]);
    }
    boolean union (int u , int v){
        int px= find(u);
        int py = find(v);
        if(px == py) return false;
        if(size[px]<size[py]){
            parent[px] = py;
            size[py] += size[px];
        }else{
            parent[py] = px;
            size[px] += size[py];
        }
        component--;
        return true;
    }
}
class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        DSU dsu = new DSU(n);
        for(int i = 0; i < n ; i++){
            for(int j=0; j<n ; j++){
                if(isConnected[i][j] == 1){
                    dsu.union(i, j);
                }
            }
        }
        return dsu.component;
    }
}