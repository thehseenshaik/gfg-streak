class Solution {
    public int countSubsequences(String s, int n) {

        int MOD = 1000000007;

        long[] dp = new long[n];

        for (char ch : s.toCharArray()) {

            int digit = ch - '0';

            long[] next = dp.clone();

            // Start a new subsequence with this digit
            int rem = digit % n;
            next[rem] = (next[rem] + 1) % MOD;

            // Add digit to existing subsequences
            for (int r = 0; r < n; r++) {

                int newRem = (r * 10 + digit) % n;

                next[newRem] =
                    (next[newRem] + dp[r]) % MOD;
            }

            dp = next;
        }

        return (int) dp[0];
    }
}