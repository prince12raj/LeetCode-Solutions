class Solution {
    public long maxAlternatingSum(int[] nums) {
        long even = 0;
        long odd = 0;
        for (int num : nums) {
            even = Math.max(even, odd + num);
            odd = even - num;
        }
        return even;
    }
}