class Solution {
    public int findJudge(int N, int[][] trust) {
        int[] indeg = new int[N + 1];
        int[] outdeg = new int[N + 1];
        for (int[] t : trust) {
            outdeg[t[0]]++;
            indeg[t[1]]++;
        }
        for (int i = 1; i <= N; i++) {
            if (indeg[i] == N - 1 && outdeg[i] == 0) {
                return i;
            }
        }
        return -1;
    }
}
