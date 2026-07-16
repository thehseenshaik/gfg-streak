class Solution {
    public int countWays(int n, int sum) {
        int[][] dp = new int[n + 1][sum + 1];

        // First digit cannot be 0
        for (int d = 1; d <= 9 && d <= sum; d++) {
            dp[1][d] = 1;
        }

        // Remaining digits
        for (int i = 2; i <= n; i++) {
            for (int s = 0; s <= sum; s++) {
                for (int d = 0; d <= 9; d++) {
                    if (s >= d) {
                        dp[i][s] += dp[i - 1][s - d];
                    }
                }
            }
        }

        return dp[n][sum] == 0 ? -1 : dp[n][sum];
    }
}