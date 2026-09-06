class Solution {
    public long pairAndSum(int[] arr) {

        long ans = 0;

        // Check every bit
        for (int bit = 0; bit < 31; bit++) {

            long count = 0;

            // Count numbers having this bit set
            for (int num : arr) {
                if ((num & (1 << bit)) != 0) {
                    count++;
                }
            }

            // Number of pairs where this bit is set in both numbers
            long pairs = count * (count - 1) / 2;

            ans += pairs * (1L << bit);
        }

        return ans;
    }
}