class Solution {
    static final int  mod = 1000000007;
    public int numberOfSets(int n, int k) {
        int [] dp = new int[n];
        int[] ps = new int[n+1];
        for(int j = 0; j < n ; j++){
            dp[j] = 1;
            ps[j+1] = (ps[j] + dp[j]) % mod;
        }
        for(int i = 1; i <= k ; i++){
            dp[0] = 0;
            for(int j =1; j < n; j++){
                dp[j] = (dp[j-1] + ps[j]) %mod;
            }
            for(int j = 0 ; j < n; j++){
                ps[j+1] = (ps[j] + dp[j]) % mod;
            }
        }
        return dp[n - 1];
    }
}