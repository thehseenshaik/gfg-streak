import java.util.*;

class Solution {
    public int dominantPairs(int[] arr) {
        int n = arr.length / 2;

        int[] a = new int[n];
        int[] b = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = arr[i];
            b[i] = arr[n + i];
        }

        Arrays.sort(a);
        Arrays.sort(b);

        int j = 0;
        long count = 0;

        for (int i = 0; i < n; i++) {
            while (j < n && (long)a[i] >= 5L * b[j]) {
                j++;
            }
            count += j;
        }

        return (int) count;
    }
}