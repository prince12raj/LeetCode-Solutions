class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int sum = 0;
        int i = 0;
        int j = 0;
        int n = nums.length;
        int cnt = Integer.MAX_VALUE;
        while(j < nums.length){
            sum+= nums[j];
            while(sum >= target){
                cnt =Math.min(cnt, j -i +1);
                sum -= nums[i];
                i++;
            }
            j++;
        }
        return (cnt == Integer.MAX_VALUE) ? 0 : cnt;
    }
}