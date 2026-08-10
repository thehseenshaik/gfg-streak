class Solution {
    public int maxTask(int[] h, int[] l) {
        int n = h.length;

        int[] dp = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            // Low-effort task on current day
            dp[i] = dp[i - 1] + l[i - 1];

            // High-effort task on current day
            if (i >= 2) {
                dp[i] = Math.max(dp[i], dp[i - 2] + h[i - 1]);
            } else {
                dp[i] = Math.max(dp[i], h[i - 1]);
            }

            // Do nothing
            dp[i] = Math.max(dp[i], dp[i - 1]);
        }

        return dp[n];
    }
}