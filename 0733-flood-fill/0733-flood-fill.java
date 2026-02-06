class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int real = image[sr][sc];
        if (real == color) {
            return image;
        }
        dfs(image, sr, sc, real, color);
        return image;
    }
    private void dfs(int[][] image, int r, int c, int real, int nc) {
        if (r < 0 || c < 0 || r >= image.length || c >= image[0].length) {
            return;
        }
        if (image[r][c] != real) {
            return;
        }
        image[r][c] = nc;
        dfs(image, r + 1, c, real, nc);
        dfs(image, r - 1, c, real, nc);
        dfs(image, r, c + 1, real, nc);
        dfs(image, r, c - 1, real, nc);
    }
}
