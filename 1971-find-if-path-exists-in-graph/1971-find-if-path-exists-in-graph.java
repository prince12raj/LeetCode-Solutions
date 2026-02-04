class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] e : edges) {
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]); 
        }
        boolean[] vis = new boolean[n];
        return dfs(source, destination, adj, vis);
    }
    boolean dfs(int s, int d, ArrayList<ArrayList<Integer>> adj, boolean[] vis) {
        if (s == d) return true;
        vis[s] = true;
        for (int i : adj.get(s)) {
            if (!vis[i]) {
                if (dfs(i, d, adj, vis)) {
                    return true;
                }
            }
        }
        return false;
    }
}
