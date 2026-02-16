class Solution {
    public boolean possibleBipartition(int n, int[][] dislikes) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i <= n; i++){
            adj.add(new ArrayList<>());
        }
        for(int[] d : dislikes){
            adj.get(d[0]).add(d[1]);
            adj.get(d[1]).add(d[0]);
        }
        int[] color = new int[n + 1];
        Arrays.fill(color, -1);
        for(int i = 1; i <= n; i++){
            if(color[i] == -1){
                if(!dfs(i, 0, adj, color)){
                    return false;
                }
            }
        } 
        return true;
    }
    private boolean dfs(int src, int c, List<List<Integer>> adj, int[] color){
        color[src] = c;
        for(int it : adj.get(src)){
            if(color[it] == -1){
                if(!dfs(it, 1 - c, adj, color)){
                    return false;
                }
            }
            else if(color[it] == c){
                return false;
            }
        }
        
        return true;
    }
}
