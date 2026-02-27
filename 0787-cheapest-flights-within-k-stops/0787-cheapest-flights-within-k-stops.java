class Solution {
    static class Pair {
        int node;
        int cost;
        int stops;
        Pair(int node, int cost, int stops) {
            this.node = node;
            this.cost = cost;
            this.stops = stops;
        }
    }
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : flights) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];
            adj.get(u).add(new int[]{v, w});
        }
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(src, 0, 0));
        dist[src] = 0;
        while (!q.isEmpty()) {
            Pair current = q.poll();
            int node = current.node;
            int cost = current.cost;
            int stops = current.stops;
            if (stops > k) continue;
            for (int[] it : adj.get(node)) {
                int nextNode = it[0];
                int price = it[1];
                if (cost + price < dist[nextNode] && stops <= k) {
                    dist[nextNode] = cost + price;
                    q.offer(new Pair(nextNode, dist[nextNode], stops + 1));
                }
            }
        }
        return dist[dst] == Integer.MAX_VALUE ? -1 : dist[dst];
    }
}