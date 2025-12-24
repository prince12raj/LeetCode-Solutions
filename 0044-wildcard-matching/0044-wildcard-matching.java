class Solution {
    public boolean isMatch(String s, String p) {
        int[][] dp = new int[s.length()][p.length()];
        for (int[] a : dp) {
            Arrays.fill(a, -1);
        }
        return check(s, p, s.length() - 1, p.length() - 1, dp);
    }

    boolean check(String s, String p, int i, int j, int[][] dp) {
        if (i < 0 && j < 0) return true;

        if (i < 0) {
            for (int x = 0; x <= j; x++) {
                if (p.charAt(x) != '*') return false;
            }
            return true;
        }

        if (j < 0) return false;

        if (dp[i][j] != -1) return dp[i][j] == 1;

        boolean ans;
        if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?') {
            ans = check(s, p, i - 1, j - 1, dp);
        } else if (p.charAt(j) == '*') {
            ans = check(s, p, i, j - 1, dp) || check(s, p, i - 1, j, dp);
        } else {
            ans = false;
        }

        dp[i][j] = ans ? 1 : 0;
        return ans;
    }
}