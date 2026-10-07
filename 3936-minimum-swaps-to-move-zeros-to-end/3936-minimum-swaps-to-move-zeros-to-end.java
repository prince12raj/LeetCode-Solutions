class Solution {
    public int minimumSwaps(int[] nums) {
        int n = nums.length;
        int zeroCount = 0;
        int swaps = 0;

        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                zeroCount++;}}
      for(int i=n-zeroCount;i<n;i++){
        if(nums[i]!=0) swaps++;
      }
      return swaps;
        
    }
}