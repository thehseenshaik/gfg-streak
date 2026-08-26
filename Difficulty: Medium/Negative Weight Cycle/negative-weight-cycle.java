class Solution {
    public boolean isNegativeWeightCycle(int V, int[][] edges) {

        // Initialize all distances to 0 so every component is checked
        long[] dist = new long[V];

        // Relax all edges V-1 times
        for (int i = 1; i < V; i++) {
            boolean updated = false;

            for (int[] edge : edges) {
                int u = edge[0];
                int v = edge[1];
                int w = edge[2];

                if (dist[u] + w < dist[v]) {
                    dist[v] = dist[u] + w;
                    updated = true;
                }
            }

            if (!updated) break;
        }

        // If relaxation is still possible, negative cycle exists
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];

            if (dist[u] + w < dist[v]) {
                return true;
            }
        }

        return false;
    }
}