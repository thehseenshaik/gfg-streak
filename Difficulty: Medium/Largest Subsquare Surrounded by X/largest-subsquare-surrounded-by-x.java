class Solution {
    public int largestSubsquare(char mat[][]) {
        int n = mat.length;

        int[][] right = new int[n][n];
        int[][] down = new int[n][n];

        // Precompute consecutive X's to the right and downward
        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (mat[i][j] == 'X') {
                    right[i][j] = 1 + (j + 1 < n ? right[i][j + 1] : 0);
                    down[i][j] = 1 + (i + 1 < n ? down[i + 1][j] : 0);
                }
            }
        }

        int maxSize = 0;

        // Check possible square boundaries
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int limit = Math.min(right[i][j], down[i][j]);

                for (int size = limit; size > maxSize; size--) {
                    int bottom = i + size - 1;
                    int rightCol = j + size - 1;

                    if (bottom < n && rightCol < n &&
                        right[bottom][j] >= size &&
                        down[i][rightCol] >= size) {

                        maxSize = size;
                        break;
                    }
                }
            }
        }

        return maxSize;
    }
}