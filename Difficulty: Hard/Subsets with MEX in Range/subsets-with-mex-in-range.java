class Solution {
    public int cntSubsets(int arr[], int l, int r) {
        int n = arr.length;
        long MOD = 1000000007L;

        int[] freq = new int[r + 1];

        for (int x : arr) {
            if (x <= r) {
                freq[x]++;
            }
        }

        long[] pow2 = new long[n + 1];
        pow2[0] = 1;

        for (int i = 1; i <= n; i++) {
            pow2[i] = (pow2[i - 1] * 2) % MOD;
        }

        long product = 1;
        long ans = 0;
        int countLE = 0;

        for (int k = 0; k <= r; k++) {
            countLE += freq[k];

            if (k >= l) {
                long greaterWays = pow2[n - countLE];
                long ways = (product * greaterWays) % MOD;
                ans = (ans + ways) % MOD;
            }

            product = (product * (pow2[freq[k]] - 1 + MOD)) % MOD;
        }

        return (int) ans;
    }
}