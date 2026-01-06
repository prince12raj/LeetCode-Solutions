class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int maxPileSize = 0;
        for (int pile : piles) {
            maxPileSize = Math.max(maxPileSize, pile);
        }
        
        if (h == piles.length) return maxPileSize;
        int start = 1;
        int end = maxPileSize;
        while (start < end) {
            int currSpeed = start + (end - start) / 2;
            long hoursTaken = 0; 
            for (int pile : piles) {
                hoursTaken += (long)(pile + currSpeed - 1) / currSpeed; 
            }
            if (hoursTaken > h) {
                start = currSpeed + 1;
            } else {
                end = currSpeed;
            }
        }
        
        return start;
    }
}