class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int real  = image[sr][sc];
        if(real == color){
            return image;
        }
        dfs(image , sr, sc, color, real);
        return image;
    }
    void dfs(int [][]image, int n, int m, int color, int real){
        if(n >= image.length || m >= image[0].length || n <0 || m <0 ){
            return;
        }
        if(image[n][m] != real){
            return;
        }
        image[n][m] = color;
        dfs(image, n+1, m, color, real);
        dfs(image, n-1, m, color, real);
        dfs(image, n, m+1, color, real);
        dfs(image,n , m-1, color, real);
    }
}
