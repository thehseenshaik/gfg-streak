import java.util.*;

class Solution {
    public int numberOfCells(int r, int c, int u, int d, char[][] mat) {

        int n = mat.length;
        int m = mat[0].length;

        if (mat[r][c] == '#') {
            return 0;
        }

        int[][] up = new int[n][m];

        for (int i = 0; i < n; i++) {
            Arrays.fill(up[i], Integer.MAX_VALUE);
        }

        Deque<int[]> dq = new ArrayDeque<>();

        up[r][c] = 0;
        dq.offerFirst(new int[]{r, c});

        int[] dr = {0, 0, -1, 1};
        int[] dc = {-1, 1, 0, 0};

        while (!dq.isEmpty()) {

            int[] curr = dq.pollFirst();
            int x = curr[0];
            int y = curr[1];

            for (int k = 0; k < 4; k++) {

                int nx = x + dr[k];
                int ny = y + dc[k];

                if (nx < 0 || nx >= n || ny < 0 || ny >= m ||
                    mat[nx][ny] == '#') {
                    continue;
                }

                // Moving up costs 1, other moves cost 0
                int cost = (dr[k] == -1) ? 1 : 0;

                if (up[x][y] + cost < up[nx][ny]) {

                    up[nx][ny] = up[x][y] + cost;

                    if (cost == 0) {
                        dq.offerFirst(new int[]{nx, ny});
                    } else {
                        dq.offerLast(new int[]{nx, ny});
                    }
                }
            }
        }

        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if (up[i][j] == Integer.MAX_VALUE) {
                    continue;
                }

                int upUsed = up[i][j];
                int downUsed = upUsed + (i - r);

                if (upUsed <= u && downUsed <= d) {
                    count++;
                }
            }
        }

        return count;
    }
}