class Solution {
    public int countAlwaysFound(int[] arr) {
        int n = arr.length;
        int count = 0;
        int maxLeft = Integer.MIN_VALUE;

        int[] minRight = new int[n];
        minRight[n - 1] = Integer.MAX_VALUE;

        for (int i = n - 2; i >= 0; i--) {
            minRight[i] = Math.min(arr[i + 1], minRight[i + 1]);
        }

        for (int i = 0; i < n; i++) {
            if (arr[i] > maxLeft && arr[i] < minRight[i]) {
                count++;
            }
            maxLeft = Math.max(maxLeft, arr[i]);
        }

        return count;
    }
}