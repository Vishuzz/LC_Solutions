class Solution {
    private double helper(double x, long n) {
        // Base case: anything raised to 0 is 1
        if (n == 0) return 1.0;
        
        // Base case: anything raised to 1 is itself
        if (n == 1) return x;
        
        // If 'n' is even
        if (n % 2 == 0) {
            // Recursive call: square the base and halve the exponent
            return helper(x * x, n / 2);
        }
        
        // If 'n' is odd
        // Recursive call: multiply base once and reduce exponent by 1
        return x * helper(x, n - 1);
    }
    public double myPow(double x, int n) {
        long N = n;
        if (N < 0) {
            return 1.0 / helper(x, -N);
        }
        // If 'n' is non-negative
        return helper(x, N);
    }
}