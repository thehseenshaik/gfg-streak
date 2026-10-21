class Solution {
    public int minSubarraySum(int[] arr) {
        int curr = arr[0];
        int minSum = arr[0];

        for (int i = 1; i < arr.length; i++) {
            curr = Math.min(arr[i], curr + arr[i]);
            minSum = Math.min(minSum, curr);
        }

        return minSum;
    }
}