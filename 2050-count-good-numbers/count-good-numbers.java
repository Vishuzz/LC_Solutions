class Solution {

    static final long MOD = 1000000007;

    static long power(long a, long b) {

        long result = 1;

        while (b > 0) {

            if (b % 2 == 1) {
                result = (result * a) % MOD;
            }

            a = (a * a) % MOD;
            b = b / 2;
        }

        return result;
    }

    public int countGoodNumbers(long n) {

        long even = (n + 1) / 2;
        long odd = n / 2;

        long ans = (power(5, even) * power(4, odd)) % MOD;

        return (int) ans;
    }
}