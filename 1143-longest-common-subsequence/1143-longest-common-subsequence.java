class Solution {
    static int dp[][];
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        dp = new int [n+1][m+1]; 
        for(int a[] : dp){
            Arrays.fill(a,-1);
        }
       return fxn(text1 ,text2 ,n-1 ,m-1);
    }
    int fxn(String s, String p , int i , int j){
        if(i < 0 || j < 0) return 0;
        if(dp[i][j] != -1) return dp[i][j];
        if(s.charAt(i) == p.charAt(j)) return dp[i][j] =1+fxn(s, p, i-1, j-1);

        else{
            return dp[i][j] =Math.max(fxn(s, p, i-1, j), fxn(s, p, i, j-1));
        }
    }
}
