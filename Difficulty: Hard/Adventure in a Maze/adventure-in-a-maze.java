import java.util.*;

class Solution {

    static final int MOD = 1000000007;

    int[][] pathMemo;
    int[][] adventureMemo;
    boolean[][] visited;

    public ArrayList<Integer> findWays(int[][] grid) {

        int n = grid.length;

        pathMemo = new int[n][n];
        adventureMemo = new int[n][n];
        visited = new boolean[n][n];

        int[] ans = solve(grid, 0, 0, n);

        ArrayList<Integer> result = new ArrayList<>();
        result.add(ans[0]);
        result.add(ans[1]);

        return result;
    }

    private int[] solve(int[][] grid, int i, int j, int n) {

        // Out of bounds
        if (i >= n || j >= n) {
            return new int[]{0, 0};
        }

        // Destination
        if (i == n - 1 && j == n - 1) {
            return new int[]{1, grid[i][j]};
        }

        // Already calculated
        if (visited[i][j]) {
            return new int[]{
                pathMemo[i][j],
                adventureMemo[i][j]
            };
        }

        visited[i][j] = true;

        int totalPaths = 0;
        int maxAdventure = 0;

        // Right
        if (grid[i][j] == 1 || grid[i][j] == 3) {

            int[] right = solve(grid, i, j + 1, n);

            totalPaths = (totalPaths + right[0]) % MOD;

            if (right[0] > 0) {
                maxAdventure = Math.max(
                    maxAdventure,
                    grid[i][j] + right[1]
                );
            }
        }

        // Down
        if (grid[i][j] == 2 || grid[i][j] == 3) {

            int[] down = solve(grid, i + 1, j, n);

            totalPaths = (totalPaths + down[0]) % MOD;

            if (down[0] > 0) {
                maxAdventure = Math.max(
                    maxAdventure,
                    grid[i][j] + down[1]
                );
            }
        }

        pathMemo[i][j] = totalPaths;
        adventureMemo[i][j] = maxAdventure;

        return new int[]{totalPaths, maxAdventure};
    }
}