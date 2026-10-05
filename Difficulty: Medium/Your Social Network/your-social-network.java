import java.util.*;

class Solution {
    public ArrayList<ArrayList<Integer>> socialNetwork(int[] arr) {
        int n = arr.length + 1;
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

        for (int i = 2; i <= n; i++) {
            int[] dist = new int[n + 1];
            Arrays.fill(dist, -1);

            int current = i;
            int d = 0;

            while (current != 1) {
                current = arr[current - 2];
                d++;
                dist[current] = d;
            }

            for (int j = 1; j < i; j++) {
                if (dist[j] != -1) {
                    ArrayList<Integer> temp = new ArrayList<>();
                    temp.add(i);
                    temp.add(j);
                    temp.add(dist[j]);
                    ans.add(temp);
                }
            }
        }

        return ans;
    }
}