class Solution {
    public int countWithout(int n, int d) {

        if (n == 0)
            return 0;

        String s = String.valueOf(n);
        int len = s.length();

        long[][][] dp = new long[len + 1][2][2];

        return (int) solve(0, 1, 0, s, d, dp);
    }

    private long solve(int pos, int tight, int started,
                       String s, int d, long[][][] dp) {

        if (pos == s.length()) {
            // Exclude number 0
            return started == 1 ? 1 : 0;
        }

        if (dp[pos][tight][started] != 0)
            return dp[pos][tight][started];

        int limit = (tight == 1) ? s.charAt(pos) - '0' : 9;
        long count = 0;

        for (int digit = 0; digit <= limit; digit++) {

            int newTight = (tight == 1 && digit == limit) ? 1 : 0;
            int newStarted = (started == 1 || digit != 0) ? 1 : 0;

            // If number has started, digit d cannot be used
            if (newStarted == 1 && digit == d)
                continue;

            count += solve(pos + 1, newTight, newStarted,
                           s, d, dp);
        }

        dp[pos][tight][started] = count;
        return count;
    }
}