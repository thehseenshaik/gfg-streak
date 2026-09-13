import java.util.*;

class Solution {
    public int partyHouse(ArrayList<ArrayList<Integer>> adj) {
        int[] a = bfs(adj, 0);
        int[] b = bfs(adj, a[0]);

        int diameter = b[1];

        return (diameter + 1) / 2;
    }

    private int[] bfs(ArrayList<ArrayList<Integer>> adj, int start) {
        int n = adj.size();
        int[] dist = new int[n];
        Arrays.fill(dist, -1);

        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        dist[start] = 0;

        int farthest = start;
        int maxDist = 0;

        while (!q.isEmpty()) {
            int u = q.poll();

            for (int v : adj.get(u)) {
                v--;

                if (dist[v] == -1) {
                    dist[v] = dist[u] + 1;
                    q.add(v);

                    if (dist[v] > maxDist) {
                        maxDist = dist[v];
                        farthest = v;
                    }
                }
            }
        }

        return new int[]{farthest, maxDist};
    }
}