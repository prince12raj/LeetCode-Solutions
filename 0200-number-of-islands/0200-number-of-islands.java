class Solution {
    int n, m;
    public int numIslands(char[][] grid) {
        n =  grid.length;
        m =  grid[0].length;
        int cnt = 0;
        for(int i = 0;i <n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(grid[i][j] == '1'){
                    dfs(i, j , grid);
                    cnt++;
                }
            }
        }
        return cnt;
    }
    public void dfs(int i , int j , char[][] grid){
        if(i< n && j < m && i >=0 && j >=0 && grid[i][j]== '1'){
            grid[i][j] = '0';
            dfs(i+1 , j , grid);
            dfs(i, j+1, grid);
            dfs(i, j-1, grid);
            dfs(i-1, j, grid);
        }
    }
}
