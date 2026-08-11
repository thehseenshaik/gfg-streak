class Solution {
    ArrayList<Integer> largestSquare(int[][] mat, int[][] queries, int k) {
        
        int n = mat.length;
        int m = mat[0].length;

        // Build 2D prefix sum
        int[][] prefix = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                prefix[i][j] = mat[i - 1][j - 1]
                        + prefix[i - 1][j]
                        + prefix[i][j - 1]
                        - prefix[i - 1][j - 1];
            }
        }

        ArrayList<Integer> ans = new ArrayList<>();

        for (int[] query : queries) {

            int r = query[0];
            int c = query[1];

            // Maximum possible radius from this center
            int maxRadius = Math.min(
                    Math.min(r, n - 1 - r),
                    Math.min(c, m - 1 - c)
            );

            int low = 0;
            int high = maxRadius;
            int best = -1;

            while (low <= high) {

                int radius = low + (high - low) / 2;

                int top = r - radius;
                int bottom = r + radius;
                int left = c - radius;
                int right = c + radius;

                // Number of 1s inside the square
                int ones = prefix[bottom + 1][right + 1]
                        - prefix[top][right + 1]
                        - prefix[bottom + 1][left]
                        + prefix[top][left];

                if (ones <= k) {
                    best = radius;
                    low = radius + 1;
                } else {
                    high = radius - 1;
                }
            }

            if (best == -1) {
                ans.add(-1);
            } else {
                ans.add(2 * best + 1);
            }
        }

        return ans;
    }
}