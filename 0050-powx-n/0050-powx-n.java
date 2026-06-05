class Solution {
    public double myPow(double x, int n) {
        long N = n;
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }
        return power(x, N);
    }
    private double power(double x, long n) {
        if (n == 0) {
            return 1.0;
        }
        double h = power(x, n / 2);
        if (n % 2 == 0) {
            return h * h;
        } else {
            return x * h * h;
        }
    }
}