import java.util.*;

class Solution {
    public ArrayList<ArrayList<Integer>> formCoils(int n) {
        int size = 4 * n;
        int[][] mat = new int[size][size];

        int val = 1;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                mat[i][j] = val++;
            }
        }

        ArrayList<Integer> coil1 = new ArrayList<>();
        ArrayList<Integer> coil2 = new ArrayList<>();

        // First coil: start at top-left
        for (int layer = 0; layer < size / 2; layer += 2) {
            int top = layer;
            int left = layer;
            int bottom = size - 1 - layer;
            int right = size - 1 - layer;

            // Move down
            for (int i = top; i <= bottom; i++)
                coil1.add(mat[i][left]);

            // Move right
            for (int j = left + 1; j < right; j++)
                coil1.add(mat[bottom][j]);

            // Move up
            for (int i = bottom - 1; i > top; i--)
                coil1.add(mat[i][right - 1]);

            // Move left
            for (int j = right - 2; j >= left + 2; j--)
                coil1.add(mat[top + 1][j]);
        }

        // Second coil: start at bottom-right
        for (int layer = 0; layer < size / 2; layer += 2) {
            int top = layer;
            int left = layer;
            int bottom = size - 1 - layer;
            int right = size - 1 - layer;

            // Move up
            for (int i = bottom; i >= top; i--)
                coil2.add(mat[i][right]);

            // Move left
            for (int j = right - 1; j > left; j--)
                coil2.add(mat[top][j]);

            // Move down
            for (int i = top + 1; i < bottom; i++)
                coil2.add(mat[i][left + 1]);

            // Move right
            for (int j = left + 2; j <= right - 2; j++)
                coil2.add(mat[bottom - 1][j]);
        }

        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        result.add(coil1);
        result.add(coil2);

        return result;
    }
}