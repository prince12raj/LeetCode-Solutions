class Solution {
    public int findJudge(int N, int[][] trust) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            adj.add(new ArrayList<>());
        }
        int[] indeg = new int[N + 1];
        for (int[] t : trust) {
            adj.get(t[0]).add(t[1]);
            indeg[t[1]]++;
        }
        for (int i = 1; i <= N; i++) {
            if (adj.get(i).size() == 0 && indeg[i] == N - 1) {
                return i;
            }
        }
        return -1;
    }
}
