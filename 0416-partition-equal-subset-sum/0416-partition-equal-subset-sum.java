class Solution {
    public boolean canPartition(int[] nums) {
        int total = 0;
        for (int num : nums) total += num;
        if (total % 2 != 0) return false;
        int t = total / 2;
        int n = nums.length;
        int[][] dp = new int[n][t + 1];
        for (int i = 0; i < n; i++) {
            dp[i][0] = 1;
        }
        // if (nums[0] <= t) dp[0][nums[0]] = 1;
        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= t; j++) {
                int ex = dp[i - 1][j];
                int in = 0;
                if (nums[i] <= j) {
                    in = dp[i - 1][j - nums[i]];
                }
                dp[i][j] = (in == 1 || ex == 1) ? 1 : 0;
            }
        }
        return dp[n - 1][t] == 1;
    }
}
