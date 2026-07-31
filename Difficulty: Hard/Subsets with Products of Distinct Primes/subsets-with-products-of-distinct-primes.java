class Solution {

    static final int MOD = 1000000007;
    static final int[] primes = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29};

    public int countSubsets(int[] arr) {

        int[] freq = new int[31];
        int ones = 0;

        for (int x : arr) {
            if (x == 1)
                ones++;
            else
                freq[x]++;
        }

        long[] dp = new long[1 << 10];
        dp[0] = 1;

        for (int num = 2; num <= 30; num++) {

            if (freq[num] == 0)
                continue;

            int mask = 0;
            boolean valid = true;
            int x = num;

            for (int i = 0; i < 10; i++) {

                int cnt = 0;

                while (x % primes[i] == 0) {
                    cnt++;
                    x /= primes[i];
                }

                if (cnt > 1) {
                    valid = false;
                    break;
                }

                if (cnt == 1)
                    mask |= (1 << i);
            }

            if (!valid)
                continue;

            for (int state = (1 << 10) - 1; state >= 0; state--) {
                if ((state & mask) == 0) {
                    dp[state | mask] =
                        (dp[state | mask] + dp[state] * freq[num]) % MOD;
                }
            }
        }

        long ans = 0;

        for (int mask = 1; mask < (1 << 10); mask++) {
            ans = (ans + dp[mask]) % MOD;
        }

        long pow = 1;

        while (ones-- > 0) {
            pow = (pow * 2) % MOD;
        }

        ans = (ans * pow) % MOD;

        return (int) ans;
    }
}