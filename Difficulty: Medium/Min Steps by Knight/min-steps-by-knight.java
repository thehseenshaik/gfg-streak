import java.util.*;

class Solution {
    public int minStepToReachTarget(int knightPos[], int targetPos[], int n) {
        int sx = knightPos[0] - 1;
        int sy = knightPos[1] - 1;

        int tx = targetPos[0] - 1;
        int ty = targetPos[1] - 1;

        if (sx == tx && sy == ty) {
            return 0;
        }

        int[][] dist = new int[n][n];

        for (int[] row : dist) {
            Arrays.fill(row, -1);
        }

        int[] dx = {2, 2, -2, -2, 1, 1, -1, -1};
        int[] dy = {1, -1, 1, -1, 2, -2, 2, -2};

        Queue<int[]> q = new LinkedList<>();

        q.add(new int[]{sx, sy});
        dist[sx][sy] = 0;

        while (!q.isEmpty()) {
            int[] curr = q.poll();

            int x = curr[0];
            int y = curr[1];

            for (int i = 0; i < 8; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && nx < n &&
                    ny >= 0 && ny < n &&
                    dist[nx][ny] == -1) {

                    dist[nx][ny] = dist[x][y] + 1;

                    if (nx == tx && ny == ty) {
                        return dist[nx][ny];
                    }

                    q.add(new int[]{nx, ny});
                }
            }
        }

        return -1;
    }
}