class Solution {
    public int findJudge(int N, int[][] trust) {
        int[][] mat = new int[N + 1][N + 1];
        for (int[] t : trust) {
            mat[t[0]][t[1]] = 1;
        }
        for (int i = 1; i <= N; i++) {
            int out = 0, in = 0;
            for (int j = 1; j <= N; j++) {
                out += mat[i][j]; 
                in += mat[j][i]; 
            }
            if (out == 0 && in == N - 1) {
                return i;
            }
        }
        return -1;
    }
}
