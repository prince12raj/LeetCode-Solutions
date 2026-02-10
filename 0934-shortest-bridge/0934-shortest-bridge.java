class Solution {
    int[][] move = {{1,0},{-1,0},{0,1},{0,-1}};
    int n;
    Queue<int[]> q = new LinkedList<>();
    public int shortestBridge(int[][] grid) {
        n = grid.length;
        boolean found = false;
        for (int i = 0; i < n && !found; i++) {
            for (int j = 0; j < n && !found; j++) {
                if (grid[i][j] == 1) {
                    dfs(grid, i, j);
                    found = true;
                }
            }
        }
        int steps = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                int[] cur = q.poll();
                for (int[] d : move) {
                    int x = cur[0] + d[0];
                    int y = cur[1] + d[1];
                    if (x < 0 || y < 0 || x >= n || y >= n) continue;
                    if (grid[x][y] == 1) {
                        return steps;
                    }
                    if (grid[x][y] == 0) {
                        grid[x][y] = -1;
                        q.offer(new int[]{x, y});
                    }
                }
            }
            steps++;
        }
        return -1;
    }
    private void dfs(int[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= n || j >= n || grid[i][j] != 1) return;
        grid[i][j] = -1;
        q.offer(new int[]{i, j});
        for (int[] d : move) {
            dfs(grid, i + d[0], j + d[1]);
        }
    }
}
