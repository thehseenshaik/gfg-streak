class Solution {
    public int formPyramid(int[] arr) {
        int n = arr.length;

        int[] left = new int[n];
        int[] right = new int[n];

        long total = 0;
        long maxPyramidSum = 0;

        // Calculate maximum valid heights from the left
        for (int i = 0; i < n; i++) {
            total += arr[i];

            if (i == 0) {
                left[i] = Math.min(arr[i], 1);
            } else {
                left[i] = Math.min(arr[i], left[i - 1] + 1);
            }
        }

        // Calculate maximum valid heights from the right
        for (int i = n - 1; i >= 0; i--) {
            if (i == n - 1) {
                right[i] = Math.min(arr[i], 1);
            } else {
                right[i] = Math.min(arr[i], right[i + 1] + 1);
            }

            int peak = Math.min(left[i], right[i]);

            // Pyramid sum: 1 + 2 + ... + peak + ... + 2 + 1 = peak²
            maxPyramidSum = Math.max(maxPyramidSum, (long) peak * peak);
        }

        return (int) (total - maxPyramidSum);
    }
}