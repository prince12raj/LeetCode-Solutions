class Solution {
    static int dp[][];
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        dp = new int[n][n+1];
        for(int a[] : dp) {
            Arrays.fill(a ,0);
        }
        return solve(nums, 0, -1);
    }
    int solve(int[] nums, int i, int prev) {
        if (i == nums.length) return 0;
        if(dp[i][prev+1] !=0 ) return dp[i][prev+1];
        int notTake = solve(nums, i + 1, prev);
        int take = 0;
        if (prev == -1 || nums[i] > nums[prev]) {
            take = 1 + solve(nums, i + 1, i);
        }   
        return dp[i][prev+1] =Math.max(take, notTake);
    }
}
