class Solution {
    public int maxSumSubarray(int[] arr) {
        int n = arr.length;

        if (n == 1) return arr[0];

        int[] fw = new int[n];
        int[] bw = new int[n];

        fw[0] = arr[0];
        int ans = arr[0];

        // Maximum subarray sum ending at each index
        for (int i = 1; i < n; i++) {
            fw[i] = Math.max(arr[i], fw[i - 1] + arr[i]);
            ans = Math.max(ans, fw[i]);
        }

        bw[n - 1] = arr[n - 1];

        // Maximum subarray sum starting at each index
        for (int i = n - 2; i >= 0; i--) {
            bw[i] = Math.max(arr[i], bw[i + 1] + arr[i]);
        }

        // Try removing one element
        for (int i = 1; i < n - 1; i++) {
            ans = Math.max(ans, fw[i - 1] + bw[i + 1]);
        }

        return ans;
    }
}