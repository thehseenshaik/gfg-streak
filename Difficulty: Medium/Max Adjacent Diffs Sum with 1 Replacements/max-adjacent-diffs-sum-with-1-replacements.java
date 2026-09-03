class Solution {
    public int maxDiffSum(int[] arr) {

        int n = arr.length;

        if (n == 1) return 0;

        // dp0 -> previous element is replaced with 1
        // dp1 -> previous element remains arr[i]
        long dp0 = 0;
        long dp1 = 0;

        for (int i = 1; i < n; i++) {

            long new0 = Math.max(
                dp0,
                dp1 + Math.abs(1L - arr[i - 1])
            );

            long new1 = Math.max(
                dp0 + Math.abs((long) arr[i] - 1),
                dp1 + Math.abs((long) arr[i] - arr[i - 1])
            );

            dp0 = new0;
            dp1 = new1;
        }

        return (int) Math.max(dp0, dp1);
    }
}