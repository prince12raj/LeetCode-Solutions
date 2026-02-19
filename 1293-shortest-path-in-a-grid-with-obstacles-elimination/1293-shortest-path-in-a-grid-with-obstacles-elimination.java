class Solution {
    static class State {
        int r, c, k, steps;
        State(int r, int c, int k, int steps) {
            this.r = r;
            this.c = c;
            this.k = k;
            this.steps = steps;
        }
    }
    public int shortestPath(int[][] grid, int k) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][][] visited = new boolean[n][m][k + 1];
        Queue<State> queue = new LinkedList<>();
        queue.offer(new State(0, 0, k, 0));
        visited[0][0][k] = true;
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};
        while (!queue.isEmpty()) {
            State curr = queue.poll();
            if (curr.r == n - 1 && curr.c == m - 1)
                return curr.steps;
            for (int i = 0; i < 4; i++) {
                int nr = curr.r + dr[i];
                int nc = curr.c + dc[i];
                if (nr >= 0 && nc >= 0 && nr < n && nc < m) {
                    int newK = curr.k - grid[nr][nc];
                    if (newK >=  0 && !visited[nr][nc][newK]) {
                        visited[nr][nc][newK] = true;
                        queue.offer(new State(nr, nc, newK, curr.steps + 1));
                    }
                }
            }
        }
        return -1;
    }
}
