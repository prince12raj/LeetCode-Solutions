class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int max = nums[0];
        for(int i = 0 ;i <nums.length;i++){
            if(max < nums[i]){
                max = nums[i];
            }
            int min = nums[i];
            for(int j = i ; j<nums.length ;j++){
                if(min > nums[j]){
                    min = nums[j];
                }
            }
            if(max-min <= k){
                return i;
            }
        }
        return -1;
    }
}