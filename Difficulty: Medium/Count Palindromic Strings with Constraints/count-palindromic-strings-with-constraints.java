class Solution {
    public int palindromicStrings(int n, int k) {

        final long MOD = 1000000007L;
        long ans = 0;

        // prod[m] = k * (k-1) * ... for m factors
        long prod = 1;

        for (int len = 1; len <= n; len++) {

            int required;

            if (len % 2 == 0) {
                // Length = 2m -> m distinct characters are needed
                required = len / 2;
            } else {
                // Length = 2m+1 -> m paired chars + 1 middle char
                required = len / 2 + 1;
            }

            // Calculate P(k, required)
            prod = 1;
            for (int j = 0; j < required; j++) {
                prod = (prod * (k - j)) % MOD;
            }

            ans = (ans + prod) % MOD;
        }

        return (int) ans;
    }
}