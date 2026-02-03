class Solution {
    public int findCenter(int[][] edges) {
        int n = edges.length + 1;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] e : edges) {
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }
        for (int i = 1; i <= n; i++) {
            if (adj.get(i).size() == n - 1) {
                return i;
            }
        }

        return -1;
    }
}
