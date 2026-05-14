class Solution {
    public int[] countOppositeParity(int[] nums) {
        int res[] = new int[nums.length];
        int odd = 0; 
        int even = 0;
        for(int i = nums.length -1; i >= 0 ; i--){
            if(nums[i] % 2 == 0){
                even++;
                res[i] = odd;
            }
            else{
                odd++;
                res[i] = even;
            }
        }
        return res;
    }
}