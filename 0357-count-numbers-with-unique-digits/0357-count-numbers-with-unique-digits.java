class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0){
            return 1;
        }
        int res = 10;
        int ud = 9;
        int an = 9;
        while(n--> 1 && an > 0){
            ud = ud * an;
            res += ud;
            an--;
        }
        return res;
    }
}