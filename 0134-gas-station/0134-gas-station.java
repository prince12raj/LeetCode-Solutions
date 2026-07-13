class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        for (int i = 0; i < n; i++) {
            int tank = 0;
            boolean canComplete = true;
            for (int j = 0; j < n; j++) {
                int a = (i + j) % n; 
                tank += gas[a] - cost[a];
                if (tank < 0) {
                    canComplete = false;
                    break;
                }
            }
            if (canComplete) {
                return i;
            }
        }
        return -1;
    }
}
