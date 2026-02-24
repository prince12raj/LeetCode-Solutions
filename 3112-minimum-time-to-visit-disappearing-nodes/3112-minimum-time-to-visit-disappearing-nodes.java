class Solution {
    static class Pair {
        int node;
        int time;
        Pair(int node, int time) {
            this.node = node;
            this.time = time;
        }
    }
    public int[] minimumTime(int n, int[][] edges, int[] disappear) {
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] it : edges) {
            int u = it[0];
            int v = it[1];
            int w = it[2];
            adj.get(u).add(new int[]{v, w});
            adj.get(v).add(new int[]{u, w});
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.time - b.time);
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        if (disappear[0] == 0) {
            return new int[n]; 
        }
        dist[0] = 0;
        pq.add(new Pair(0, 0));
        while (!pq.isEmpty()) {
            Pair curr = pq.poll();
            int node = curr.node;
            int currTime = curr.time;
            if (currTime > dist[node]) continue;
            for (int[] edge : adj.get(node)) {
                int nbr = edge[0];
                int weight = edge[1];
                int newTime = currTime + weight;
                if (newTime < dist[nbr] && newTime < disappear[nbr]) {
                    dist[nbr] = newTime;
                    pq.add(new Pair(nbr, newTime));
                }
            }
        }
        for (int i = 0; i < n; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                dist[i] = -1;
            }
        }

        return dist;
    }
}