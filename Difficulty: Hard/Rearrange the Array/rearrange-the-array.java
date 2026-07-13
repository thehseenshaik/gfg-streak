class Solution {
    static final int MOD = 1000000007;

    int minOperations(int[] b) {
        int n = b.length;
        boolean[] vis = new boolean[n];
        int[] maxPow = new int[n + 1];

        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                int len = 0;
                int cur = i;

                while (!vis[cur]) {
                    vis[cur] = true;
                    cur = b[cur] - 1;
                    len++;
                }

                factorize(len, maxPow);
            }
        }

        long ans = 1;

        for (int p = 2; p <= n; p++) {
            for (int i = 0; i < maxPow[p]; i++) {
                ans = (ans * p) % MOD;
            }
        }

        return (int) ans;
    }

    void factorize(int x, int[] maxPow) {
        for (int p = 2; p * p <= x; p++) {
            if (x % p == 0) {
                int cnt = 0;
                while (x % p == 0) {
                    x /= p;
                    cnt++;
                }
                maxPow[p] = Math.max(maxPow[p], cnt);
            }
        }

        if (x > 1) {
            maxPow[x] = Math.max(maxPow[x], 1);
        }
    }
}