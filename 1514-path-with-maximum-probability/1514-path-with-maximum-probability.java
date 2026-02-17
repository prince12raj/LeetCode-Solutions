class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb,int start_node, int end_node) {
        List<List<double[]>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            double prob = succProb[i];
            adj.get(u).add(new double[]{v, prob});
            adj.get(v).add(new double[]{u, prob});
        }
        PriorityQueue<double[]> pq = new PriorityQueue<>((a, b) -> Double.compare(b[0], a[0]));
        double[] maxProb = new double[n];
        maxProb[start_node] = 1.0;
        pq.offer(new double[]{1.0, start_node});
        while (!pq.isEmpty()) {
            double[] curr = pq.poll();
            double prob = curr[0];
            int node = (int) curr[1];
            if (node == end_node) {
                return prob;
            }
            for (double[] uv : adj.get(node)) {
                int next = (int)uv[0];
                double nodeProb = uv[1];
                if (prob * nodeProb > maxProb[next]) {
                    maxProb[next] = prob * nodeProb;
                    pq.offer(new double[]{maxProb[next], next});
                }
            }
        }
        return maxProb[end_node];
    }
}
