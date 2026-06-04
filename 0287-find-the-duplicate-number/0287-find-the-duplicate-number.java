class Solution {
    public int findDuplicate(int[] nums) {
        HashMap<Integer , Integer> mp = new HashMap<>();

        for(int n : nums){
            mp.put(n , mp.getOrDefault(n, 0)+1);
        }
        for(int i = 0 ; i < nums.length ; i++){
            if(mp.get(nums[i]) > 1){
                return nums[i];
            }
        }
        return 0;
    }
}