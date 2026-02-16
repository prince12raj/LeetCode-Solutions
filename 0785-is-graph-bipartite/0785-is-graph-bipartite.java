class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] color = new int[n];
        Arrays.fill(color, -1);
        for (int i = 0; i < n; i++) {
            if (color[i] == -1) {
                Queue<Integer> q = new LinkedList<>();
                q.add(i);
                color[i] = 0;  
                while (!q.isEmpty()) {
                    int v = q.poll();
                    for (int it : graph[v]) {
                        if (color[it] == -1) {
                            color[it] = 1 - color[v];
                            q.add(it);
                        } 
                        else if (color[it] == color[v]) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}
