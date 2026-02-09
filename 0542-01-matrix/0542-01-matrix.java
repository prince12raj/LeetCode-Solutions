class Solution {
    int n, m;
    int[][] level;
    boolean[][] vis;
    int[][] mat;
    Queue<int[]> q;
    int[][] move = {{1,0}, {-1,0}, {0,1}, {0,-1}};
    public int[][] updateMatrix(int[][] mat) {
        this.mat = mat;
        n = mat.length;
        m = mat[0].length;
        level = new int[n][m];
        vis = new boolean[n][m];
        q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 0) {
                    q.offer(new int[]{i, j});
                    vis[i][j] = true;
                    level[i][j] = 0;
                }
            }
        }
        bfs(); 
        return level;
    }
    private void bfs() {
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            for (int[] d : move) {
                int nx = x + d[0];
                int ny = y + d[1];
                if (nx >= 0 && ny >= 0 && nx < n && ny < m && !vis[nx][ny]) {
                    vis[nx][ny] = true;
                    level[nx][ny] = level[x][y] + 1;
                    q.offer(new int[]{nx, ny});
                }
            }
        }
    }
}
