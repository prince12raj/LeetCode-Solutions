class Solution {
    int mod = 1_000_000_007;
    int[][] dp;
    int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
    int n, m;
    public int countPaths(int[][] grid) {
        n = grid.length;
        m = grid[0].length;
        dp = new int[n][m];
        int ans = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                ans = (ans + dfs(grid, i, j))%mod;
            }
        }
        return ans;
    }
    private int dfs(int[][] grid, int r, int c) {
        if(dp[r][c] != 0) return dp[r][c];
        long count = 1; 
        for(int[] d : dir) {
            int nr = r + d[0];
            int nc = c + d[1];
            if(nr >= 0 && nc >= 0 && nr < n && nc < m&& grid[nr][nc] > grid[r][c]) {
                count += dfs(grid, nr, nc);
            }
        }
        dp[r][c] = (int)(count % mod);
        return dp[r][c];
    }
}
