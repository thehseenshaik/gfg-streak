class Solution {
    public int maxDiffSubArrays(int[] arr) {
        int n = arr.length;

        int[] leftMax = new int[n];
        int[] rightMax = new int[n];
        int[] leftMin = new int[n];
        int[] rightMin = new int[n];

        // Maximum subarray sum from left
        int cur = arr[0];
        leftMax[0] = arr[0];
        for (int i = 1; i < n; i++) {
            cur = Math.max(arr[i], cur + arr[i]);
            leftMax[i] = Math.max(leftMax[i - 1], cur);
        }

        // Maximum subarray sum from right
        cur = arr[n - 1];
        rightMax[n - 1] = arr[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            cur = Math.max(arr[i], cur + arr[i]);
            rightMax[i] = Math.max(rightMax[i + 1], cur);
        }

        // Minimum subarray sum from left
        cur = arr[0];
        leftMin[0] = arr[0];
        for (int i = 1; i < n; i++) {
            cur = Math.min(arr[i], cur + arr[i]);
            leftMin[i] = Math.min(leftMin[i - 1], cur);
        }

        // Minimum subarray sum from right
        cur = arr[n - 1];
        rightMin[n - 1] = arr[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            cur = Math.min(arr[i], cur + arr[i]);
            rightMin[i] = Math.min(rightMin[i + 1], cur);
        }

        int ans = 0;

        for (int i = 0; i < n - 1; i++) {
            ans = Math.max(ans, Math.abs(leftMax[i] - rightMin[i + 1]));
            ans = Math.max(ans, Math.abs(leftMin[i] - rightMax[i + 1]));
        }

        return ans;
    }
}