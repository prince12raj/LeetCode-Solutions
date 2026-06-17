class Solution {

    public int coinChange(int[] coins, int amount) {

        int INF = 1000000;

        int[] dp = new int[amount + 1];

        Arrays.fill(dp, INF);

        dp[0] = 0;

        for(int coin : coins){

            for(int j = coin; j <= amount; j++){

                dp[j] = Math.min(dp[j], 1 + dp[j - coin]);
            }
        }

        return dp[amount] >= INF ? -1 : dp[amount];
    }
}