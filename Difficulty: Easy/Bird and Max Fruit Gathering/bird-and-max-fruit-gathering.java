import java.util.*;

class Solution {
    public int maxFruits(ArrayList<Integer> arr, int m) {

        int n = arr.size();

        // Sum of first window
        long sum = 0;
        for (int i = 0; i < m; i++) {
            sum += arr.get(i);
        }

        long maxSum = sum;

        // Slide circular window
        for (int start = 1; start < n; start++) {

            // Remove previous first element
            sum -= arr.get(start - 1);

            // Add next element (circular index)
            int next = (start + m - 1) % n;
            sum += arr.get(next);

            maxSum = Math.max(maxSum, sum);
        }

        return (int) maxSum;
    }
}