class Solution {
    static int dp[][];
    static int arr[];
    public int maxCoins(int[] nums) {
        int n = nums.length;
        arr = new int[n + 2];
        dp = new int[n + 2][n + 2];
        arr[0] = 1;
        arr[n + 1] = 1;
        for (int i = 0; i < n; i++) {
            arr[i + 1] = nums[i];
        }
        for (int[] a : dp) {
            Arrays.fill(a, -1);
        }
        return fxn(1, n);
    }

    int fxn(int i, int j) {
        if (i > j) return 0; 
        if (dp[i][j] != -1) return dp[i][j];
        int maxCoins = 0;
        for (int k = i; k <= j; k++) {
            int coins = arr[i - 1] * arr[k] * arr[j + 1] + fxn(i, k - 1) + fxn(k + 1, j); 
            maxCoins = Math.max(maxCoins, coins);
        }

        return dp[i][j] = maxCoins;
    }
}
