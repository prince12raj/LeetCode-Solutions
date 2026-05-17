class Solution {
    public int countLocalMaximums(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        ArrayList<int[]>[] pos = new ArrayList[201];
        for(int i = 0; i <= 200; i++)
            pos[i] = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                pos[matrix[i][j]].add(new int[]{i, j});
            }
        }
        int ans = 0;
        for(int r = 0; r < n; r++) {
            for(int c = 0; c < m; c++) {
                int x = matrix[r][c];
                if(x == 0) continue;
                boolean ok = true;
                for(int val = x + 1; val <= 200 && ok; val++) {
                    for(int[] p : pos[val]) {
                        int nr = p[0];
                        int nc = p[1];
                        int dr = Math.abs(nr - r);
                        int dc = Math.abs(nc - c);
                        if(dr <= x && dc <= x) {
                            if(dr == x && dc == x)
                                continue;

                            ok = false;
                            break;
                        }
                    }
                }

                if(ok)
                ans++;
            }
        }
        return ans;
    }
}