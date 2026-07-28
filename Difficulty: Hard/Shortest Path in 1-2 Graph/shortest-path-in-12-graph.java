class Solution {

    static class Pair {
        int node;
        int dist;

        Pair(int node, int dist) {
            this.node = node;
            this.dist = dist;
        }
    }

    public int shortestPath(int V, int src, int dest, int[][] edges) {

        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] e : edges) {
            int u = e[0];
            int v = e[1];
            int w = e[2];

            adj.get(u).add(new Pair(v, w));
            adj.get(v).add(new Pair(u, w));
        }

        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);

        PriorityQueue<Pair> pq =
            new PriorityQueue<>((a, b) -> a.dist - b.dist);

        dist[src] = 0;
        pq.offer(new Pair(src, 0));

        while (!pq.isEmpty()) {

            Pair cur = pq.poll();

            if (cur.dist > dist[cur.node])
                continue;

            for (Pair next : adj.get(cur.node)) {

                if (dist[next.node] > cur.dist + next.dist) {
                    dist[next.node] = cur.dist + next.dist;
                    pq.offer(new Pair(next.node, dist[next.node]));
                }
            }
        }

        return dist[dest] == Integer.MAX_VALUE ? -1 : dist[dest];
    }
}