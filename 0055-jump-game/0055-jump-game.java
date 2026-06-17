class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int fur =0;
        for(int i=0; i < n; i++){
            if(i > fur) return false;
            fur = Math.max(fur, i + nums[i]);
        }
        return true;
    }
}