class Solution {
    int[][][] dp;
    public int countDigitOne(int n) {
        String s = String.valueOf(n);
        dp = new int[s.length()][2][s.length() + 1];
        for (int i = 0; i < s.length(); i++){
            for (int j = 0; j < 2; j++){
                for (int k = 0; k <= s.length(); k++){
                    dp[i][j][k] = -1;
                }
            }
        }
        return fxn(s, 0, 1, 0);
    }
    int fxn(String s, int i, int rest, int count) {
        if (i == s.length())  return count;
        if (dp[i][rest][count] != -1) return dp[i][rest][count];
        int ub = (rest == 1) ? s.charAt(i) - '0' : 9;
        int res = 0;
        for (int digit = 0; digit <= ub; digit++) {
            res += fxn(s,i + 1,(rest == 1 && digit == ub) ? 1 : 0,count + (digit == 1 ? 1 : 0)
            );
        }
        return dp[i][rest][count] = res;
    }
}
