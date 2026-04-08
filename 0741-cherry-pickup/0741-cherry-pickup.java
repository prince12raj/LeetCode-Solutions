class Solution {
    int n;
    int[][] grid;
    Integer[][][] dp;
    public int cherryPickup(int[][] grid) {
        this.grid = grid;
        this.n = grid.length;
        dp = new Integer[n][n][n];
        int res = fxn(0, 0, 0);
        return Math.max(0, res);
    }

    int fxn(int r1, int c1, int r2) {
        int c2 = r1 + c1 - r2;
        if (r1 >= n || c1 >= n || r2 >= n || c2 >= n || grid[r1][c1] == -1 || grid[r2][c2] == -1) {
            return -1000000;
        }
        if (r1 == n - 1 && c1 == n - 1) {
            return grid[r1][c1];
        }
        if (dp[r1][c1][r2] != null) {
            return dp[r1][c1][r2];
        }
        int ans = 0;
        ans = grid[r1][c1];
        if (r1 != r2 && c1 != c2) {
            ans += grid[r2][c2];
        }
        int v1 = fxn(r1 + 1, c1, r2 + 1);
        int v2 = fxn(r1, c1 + 1, r2);
        int v3 = fxn(r1 + 1, c1, r2);
        int v4 = fxn(r1, c1 + 1, r2 + 1);
        ans  += Math.max(Math.max(v1, v2), Math.max(v3, v4));
        return dp[r1][c1][r2] = ans;
    }
}