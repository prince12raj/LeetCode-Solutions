class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        HashMap<Integer, Integer> mp = new HashMap<>();
        int res[] = new int[2];
        for (int num[] : grid) {
            for (int n : num) {
                mp.put(n, mp.getOrDefault(n, 0) + 1);
            }
        }
        int sum = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (mp.get(grid[i][j]) > 1) {
                    res[0] = grid[i][j];
                }
                sum += grid[i][j];
            }
        }
        int ts = grid.length * grid.length;
        int es = ts * (ts + 1) / 2;
        res[1] = es - sum + res[0];
        return res;
    }
}