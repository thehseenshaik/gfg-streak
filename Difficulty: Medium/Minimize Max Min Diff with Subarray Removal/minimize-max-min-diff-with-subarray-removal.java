class Solution {
    public int minDiff(int k, int[] arr) {
        int n = arr.length;

        if (k == 0) {
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;

            for (int x : arr) {
                min = Math.min(min, x);
                max = Math.max(max, x);
            }

            return max - min;
        }

        int[] prefixMin = new int[n];
        int[] prefixMax = new int[n];
        int[] suffixMin = new int[n];
        int[] suffixMax = new int[n];

        prefixMin[0] = prefixMax[0] = arr[0];

        for (int i = 1; i < n; i++) {
            prefixMin[i] = Math.min(prefixMin[i - 1], arr[i]);
            prefixMax[i] = Math.max(prefixMax[i - 1], arr[i]);
        }

        suffixMin[n - 1] = suffixMax[n - 1] = arr[n - 1];

        for (int i = n - 2; i >= 0; i--) {
            suffixMin[i] = Math.min(suffixMin[i + 1], arr[i]);
            suffixMax[i] = Math.max(suffixMax[i + 1], arr[i]);
        }

        int ans = Integer.MAX_VALUE;

        for (int i = 0; i <= n - k; i++) {
            int left = i - 1;
            int right = i + k;

            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;

            if (left >= 0) {
                min = Math.min(min, prefixMin[left]);
                max = Math.max(max, prefixMax[left]);
            }

            if (right < n) {
                min = Math.min(min, suffixMin[right]);
                max = Math.max(max, suffixMax[right]);
            }

            if (min == Integer.MAX_VALUE) {
                return 0;
            }

            ans = Math.min(ans, max - min);
        }

        return ans;
    }
}