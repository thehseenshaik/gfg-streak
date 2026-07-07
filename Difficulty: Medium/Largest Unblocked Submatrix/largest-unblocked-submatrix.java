import java.util.*;

class Solution {
    public int largestArea(int n, int m, int[][] arr) {

        int k = arr.length;

        int[] rows = new int[k + 2];
        int[] cols = new int[k + 2];

        rows[0] = 0;
        cols[0] = 0;

        for (int i = 0; i < k; i++) {
            rows[i + 1] = arr[i][0];
            cols[i + 1] = arr[i][1];
        }

        rows[k + 1] = n + 1;
        cols[k + 1] = m + 1;

        Arrays.sort(rows);
        Arrays.sort(cols);

        int maxRows = 0;
        int maxCols = 0;

        for (int i = 1; i < rows.length; i++) {
            maxRows = Math.max(maxRows, rows[i] - rows[i - 1] - 1);
        }

        for (int i = 1; i < cols.length; i++) {
            maxCols = Math.max(maxCols, cols[i] - cols[i - 1] - 1);
        }

        return maxRows * maxCols;
    }
}