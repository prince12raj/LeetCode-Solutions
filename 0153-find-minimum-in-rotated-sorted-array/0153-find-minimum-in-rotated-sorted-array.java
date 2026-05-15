class Solution {
    public int findMin(int[] nums) {
        int n = nums[0];
        for(int a : nums){
            n =  Math.min(n, a);
        }
        return n ;
    }
}
