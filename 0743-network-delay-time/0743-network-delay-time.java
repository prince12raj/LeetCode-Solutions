class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {

        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] t : times) {
            adj.get(t[0]).add(new int[]{t[1], t[2]});
        }
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        PriorityQueue<int[]> pq = new PriorityQueue<>((x, y) -> x[0] - y[0]);
        dist[k] = 0;
        pq.offer(new int[]{0, k});
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int d = cur[0];
            int s = cur[1];
            if (d > dist[s]) continue;
            for (int[] it : adj.get(s)) {
                int nx = it[0];
                int nd = it[1];
                if (dist[s] + nd < dist[nx]) {
                    dist[nx] = dist[s] + nd;
                    pq.offer(new int[]{dist[nx], nx});
                }
            }
        }
        int max =0;
        for(int i = 1; i <= n ; i++){
            if(dist[i] == Integer.MAX_VALUE){
                return -1;
            }
            max =Math.max(max ,dist[i]);
        }
        return max;
    }
}