import java.util.*;

class Solution {
    public int maxArea(int[][] mat) {

        int n = mat.length;
        int m = mat[0].length;
        int ans = 0;

        int[] height = new int[m];

        for (int i = 0; i < n; i++) {

            // Calculate consecutive 1s height
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 1) {
                    height[j]++;
                } else {
                    height[j] = 0;
                }
            }

            // Sort heights because columns can be swapped
            int[] temp = height.clone();
            Arrays.sort(temp);

            // Calculate maximum area
            for (int j = m - 1; j >= 0; j--) {
                int width = m - j;
                ans = Math.max(ans, temp[j] * width);
            }
        }

        return ans;
    }
}