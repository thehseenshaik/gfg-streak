class Solution {
    public int zigzagSequence(int[][] mat) {
        
        int n = mat.length;
        int[][] dp = new int[n][n];

        // First row
        for (int j = 0; j < n; j++) {
            dp[0][j] = mat[0][j];
        }

        // Remaining rows
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n; j++) {

                int max = 0;

                // Previous row lo different column choose cheyyali
                for (int k = 0; k < n; k++) {
                    if (k != j) {
                        max = Math.max(max, dp[i - 1][k]);
                    }
                }

                dp[i][j] = mat[i][j] + max;
            }
        }

        // Maximum value in last row
        int ans = 0;

        for (int j = 0; j < n; j++) {
            ans = Math.max(ans, dp[n - 1][j]);
        }

        return ans;
    }
}