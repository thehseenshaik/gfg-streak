class Solution {
    public int maxIndexDifference(String s) {

        int n = s.length();

        int[] best = new int[26];
        Arrays.fill(best, -1);

        int[] dp = new int[n];

        int ans = -1;

        for (int i = n - 1; i >= 0; i--) {

            int ch = s.charAt(i) - 'a';

            if (ch == 25) {
                dp[i] = i;
            } else if (best[ch + 1] != -1) {
                dp[i] = best[ch + 1];
            } else {
                dp[i] = i;
            }

            best[ch] = Math.max(best[ch], dp[i]);

            if (ch == 0) {
                ans = Math.max(ans, dp[i] - i);
            }
        }

        return ans;
    }
}