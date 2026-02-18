class Solution {
    static class Node {
        int r, c, dist;
        Node(int r, int c, int dist) {
            this.r = r;
            this.c = c;
            this.dist = dist;
        }
    }
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        if (grid[0][0] == 1 || grid[n-1][n-1] == 1)return -1;
        int[][] dir = {{-1,-1},{-1,0},{-1,1},{0,-1},{0,1},{1,-1},{1,0},{1,1}};
        int[][] dist = new int[n][n];
        for (int[] row : dist)
            Arrays.fill(row, Integer.MAX_VALUE);
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> a.dist - b.dist);
        pq.offer(new Node(0, 0, 1));
        dist[0][0] = 1;
        while (!pq.isEmpty()) {
            Node curr = pq.poll();
            int r = curr.r;
            int c = curr.c;
            int d = curr.dist;
            if (r == n - 1 && c == n - 1) return d;
            for (int[] move : dir) {
                int nr = r + move[0];
                int nc = c + move[1];
                if (nr >= 0 && nc >= 0 && nr < n && nc < n && grid[nr][nc] == 0) {
                    if (d + 1 < dist[nr][nc]) {
                        dist[nr][nc] = d + 1;
                        pq.offer(new Node(nr, nc, d + 1));
                    }
                }
            }
        }
        return -1;
    }
}
