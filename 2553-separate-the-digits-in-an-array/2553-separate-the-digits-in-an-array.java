class Solution {
    public int[] separateDigits(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for (int x : nums) {
            List<Integer> tmp = new ArrayList<>();
            while (x > 0) {
                tmp.add(x % 10);
                x /= 10;
            }
            for (int i = tmp.size() - 1; i >= 0; i--) {
                res.add(tmp.get(i));
            }
        }
        int[] ret = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            ret[i] = res.get(i);
        }
        return ret;
    }
}