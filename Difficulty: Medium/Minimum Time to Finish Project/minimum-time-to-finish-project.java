import java.util.*;

class Solution {
    public int minTime(int[] duration, int[][] dependencies) {
        int n = duration.length;

        ArrayList<Integer>[] adj = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }

        int[] indegree = new int[n];

        for (int[] edge : dependencies) {
            int u = edge[0];
            int v = edge[1];

            adj[u].add(v);
            indegree[v]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        int[] finishTime = new int[n];

        for (int i = 0; i < n; i++) {
            finishTime[i] = duration[i];

            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        int processed = 0;
        int answer = 0;

        while (!queue.isEmpty()) {
            int u = queue.poll();
            processed++;

            answer = Math.max(answer, finishTime[u]);

            for (int v : adj[u]) {
                finishTime[v] = Math.max(
                    finishTime[v],
                    finishTime[u] + duration[v]
                );

                indegree[v]--;

                if (indegree[v] == 0) {
                    queue.offer(v);
                }
            }
        }

        // A cycle means the project cannot be completed.
        if (processed != n) {
            return -1;
        }

        return answer;
    }
}