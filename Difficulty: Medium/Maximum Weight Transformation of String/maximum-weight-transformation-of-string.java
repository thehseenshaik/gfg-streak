class Solution {
    public int getMaxWeight(String s) {
        int n = s.length();
        int[] dp = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            // Leave the current character unpaired
            dp[i] = dp[i - 1] + 1;

            // Pair the last two characters
            if (i >= 2) {
                int pairWeight = 4 - (s.charAt(i - 2) == s.charAt(i - 1) ? 1 : 0);
                dp[i] = Math.max(dp[i], dp[i - 2] + pairWeight);
            }
        }

        return dp[n];
    }
}