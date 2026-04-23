class Solution {
    public int orangesRotting(int[][] grid) {
        int n =  grid.length;
        int m = grid[0].length;
        int fresh = 0;
        int time =0;
        Queue<int[]> q = new LinkedList<>();
        for(int i= 0 ; i < n ; i ++){
            for(int j=0; j < m ; j ++){
                if(grid[i][j] == 2){
                    q.add(new int[]{i,j});
                }else if(grid[i][j]==1){
                    fresh++;
                }
            }
        }
        if(fresh == 0) return 0;
         int dr[] = {-1, 1, 0, 0};
         int dc[] = {0, 0, -1, 1};
        while(!q.isEmpty()){
            int size = q.size();
            boolean rot = false;
            for(int j = 0 ; j < size; j++){
                int curr[] = q.poll();
            for(int i = 0; i< 4; i++){
                int nr = dr[i] + curr[0];
                int nc = dc[i]+ curr[1];
                if(nr >= 0 && nc >=0 && nr <n && nc< m && grid[nr][nc]==1){
                    grid[nr][nc]= 2;
                    q.add(new int []{nr ,nc});
                    fresh --;
                    rot = true;
                }
            }
            }
            if (rot) time++;
        }
        return fresh == 0 ? time : -1;
    }
}