class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int[] sorted = nums.clone();
        Arrays.sort(sorted);
        int i = 0;
        int j = nums.length - 1;
        while (i < nums.length && nums[i] == sorted[i]) {
            i++;
        }
        while (j > i && nums[j] == sorted[j]) {
            j--;
        }
        return (i == nums.length) ? 0 : j - i + 1;
    }
}