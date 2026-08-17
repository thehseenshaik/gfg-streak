import java.util.*;

class Solution {
    public int minThrows(int n, int[] lad, int[] sn) {

        int total = n * n;

        int[] jump = new int[total + 1];
        Arrays.fill(jump, -1);

        // Ladders
        for (int i = 0; i < lad.length; i += 2) {
            jump[lad[i]] = lad[i + 1];
        }

        // Snakes
        for (int i = 0; i < sn.length; i += 2) {
            jump[sn[i]] = sn[i + 1];
        }

        boolean[] visited = new boolean[total + 1];

        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        visited[1] = true;

        int throwsCount = 0;

        while (!q.isEmpty()) {

            int size = q.size();

            while (size-- > 0) {

                int current = q.poll();

                if (current == total)
                    return throwsCount;

                for (int dice = 1; dice <= 6; dice++) {

                    int next = current + dice;

                    if (next > total)
                        continue;

                    // Take snake or ladder immediately
                    if (jump[next] != -1) {
                        next = jump[next];
                    }

                    if (!visited[next]) {
                        visited[next] = true;
                        q.add(next);
                    }
                }
            }

            throwsCount++;
        }

        return -1;
    }
}