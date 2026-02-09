class Solution {
    int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
    public int shortestBridge(int[][] grid) {
        int n = grid.length;
        Queue<int[]> q = new LinkedList<>();
        boolean found = false;
        for (int i = 0; i < n && !found; i++) {
            for (int j = 0; j < n && !found; j++) {
                if (grid[i][j] == 1) {
                    bfsIsland(grid, i, j, q);
                    found = true;
                }
            }
        }
        int steps = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                int[] cur = q.poll();
                for (int[] d : dirs) {
                    int x = cur[0] + d[0];
                    int y = cur[1] + d[1];

                    if (x >= 0 && y >= 0 && x < n && y < n) {
                        if (grid[x][y] == 1) {
                            return steps; 
                        }
                        if (grid[x][y] == 0) {
                            grid[x][y] = -1;
                            q.offer(new int[]{x, y});
                        }
                    }
                }
            }
            steps++;
        }
        return -1;
    }
    private void bfsIsland(int[][] grid, int i, int j, Queue<int[]> q) {
        Queue<int[]> temp = new LinkedList<>();
        temp.offer(new int[]{i, j});
        grid[i][j] = -1;
        while (!temp.isEmpty()) {
            int[] cur = temp.poll();
            q.offer(cur); 
            for (int[] d : dirs) {
                int x = cur[0] + d[0];
                int y = cur[1] + d[1];
                if (x >= 0 && y >= 0 && x < grid.length && y < grid.length
                        && grid[x][y] == 1) {
                    grid[x][y] = -1;
                    temp.offer(new int[]{x, y});
                }
            }
        }
    }
}
