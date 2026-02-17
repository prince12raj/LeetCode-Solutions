class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<int[]>> adj = new ArrayList<>();
        for(int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }
        for(int[] t : times) {
            adj.get(t[0]).add(new int[]{t[1], t[2]});
        }
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>( (a, b) -> a[0] - b[0]);
        pq.offer(new int[]{0, k});
        while(!pq.isEmpty()) {
            int[] curr = pq.poll();
            int d = curr[0];
            int node = curr[1];
            if(d > dist[node]) continue;
            for(int[] uv : adj.get(node)) {
                int nextNode = uv[0];
                int weight = uv[1];   
                if(dist[node] + weight < dist[nextNode]) {
                    dist[nextNode] = dist[node] + weight;
                    pq.offer(new int[]{dist[nextNode], nextNode});
                }
            }
        }
        int maxTime = 0;
        for(int i = 1; i <= n; i++) {
            if(dist[i] == Integer.MAX_VALUE)
                return -1;
            maxTime = Math.max(maxTime, dist[i]);
        }
        return maxTime;
    }
}
