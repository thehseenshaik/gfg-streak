import java.util.*;

class Solution {
    public int longestPath(String s, int[][] edges) {
        int n = s.length();

        ArrayList<Integer>[] adj = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int[] e : edges) {
            int u = e[0] - 1;
            int v = e[1] - 1;

            adj[u].add(v);
            adj[v].add(u);
        }

        // Build parent array and traversal order
        int[] parent = new int[n];
        Arrays.fill(parent, -1);

        int[] order = new int[n];
        int count = 0;

        order[count++] = 0;
        parent[0] = -2;

        for (int i = 0; i < count; i++) {
            int u = order[i];

            for (int v : adj[u]) {
                if (v == parent[u]) continue;

                parent[v] = u;
                order[count++] = v;
            }
        }

        /*
         * down[u] = longest same-color path
         *           starting at u and going down.
         */
        int[] down = new int[n];

        int[] best1 = new int[n];
        int[] best2 = new int[n];
        int[] bestChild = new int[n];

        Arrays.fill(bestChild, -1);

        // Bottom-up DP
        for (int i = n - 1; i >= 0; i--) {
            int u = order[i];

            for (int v : adj[u]) {
                if (parent[v] == u &&
                    s.charAt(u) == s.charAt(v)) {

                    int val = down[v];

                    if (val > best1[u]) {
                        best2[u] = best1[u];
                        best1[u] = val;
                        bestChild[u] = v;
                    } else if (val > best2[u]) {
                        best2[u] = val;
                    }
                }
            }

            down[u] = 1 + best1[u];
        }

        /*
         * up[u] = longest same-color path starting at u
         *         and going through its parent side.
         */
        int[] up = new int[n];

        up[0] = 0;

        for (int i = 0; i < n; i++) {
            int u = order[i];

            for (int v : adj[u]) {
                if (parent[v] != u) continue;

                if (s.charAt(u) == s.charAt(v)) {

                    int other;

                    if (bestChild[u] == v) {
                        other = best2[u];
                    } else {
                        other = best1[u];
                    }

                    /*
                     * v -> u -> sibling...
                     *
                     * +1 for v
                     * +1 for u before entering sibling branch
                     */
                    up[v] = 1 + Math.max(up[u], 1 + other);

                } else {
                    up[v] = 0;
                }
            }
        }

        int answer = 1;

        /*
         * 1. Paths containing only one color.
         */
        for (int u = 0; u < n; u++) {

            // Two child branches through u
            answer = Math.max(
                answer,
                1 + best1[u] + best2[u]
            );

            // Parent-side branch + child branch
            if (up[u] > 0) {
                answer = Math.max(
                    answer,
                    up[u] + best1[u]
                );
            }

            answer = Math.max(answer, down[u]);
            answer = Math.max(answer, up[u]);
        }

        /*
         * 2. Paths of the form:
         *
         * R -> R -> ... -> B -> B -> ...
         *
         * Every R-B edge can be the transition point.
         */
        for (int[] e : edges) {

            int u = e[0] - 1;
            int v = e[1] - 1;

            if (s.charAt(u) == s.charAt(v)) {
                continue;
            }

            /*
             * Since u and v have different colors,
             * their same-color arms cannot cross this edge.
             */
            int armU = Math.max(
                1,
                Math.max(up[u], down[u])
            );

            int armV = Math.max(
                1,
                Math.max(up[v], down[v])
            );

            answer = Math.max(answer, armU + armV);
        }

        return answer;
    }
}