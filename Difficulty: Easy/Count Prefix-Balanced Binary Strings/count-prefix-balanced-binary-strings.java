class Solution {

    static final long MOD = 1000000007L;

    public int prefixStrings(int n) {

        long numerator = 1;
        long denominator = 1;

        // Calculate nCr = (2n choose n)
        for (int i = 1; i <= n; i++) {
            numerator = (numerator * (n + i)) % MOD;
            denominator = (denominator * i) % MOD;
        }

        long combination = numerator * power(denominator, MOD - 2) % MOD;

        // Divide by (n + 1)
        long inverse = power(n + 1, MOD - 2);

        return (int) (combination * inverse % MOD);
    }

    private long power(long base, long exp) {

        long result = 1;

        while (exp > 0) {

            if ((exp & 1) == 1) {
                result = (result * base) % MOD;
            }

            base = (base * base) % MOD;
            exp >>= 1;
        }

        return result;
    }
}