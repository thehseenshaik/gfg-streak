class Solution {
    public int goodIndices(int[] arr) {
        int n = arr.length;
        int[] state = new int[n];
        int count = 0;

        for (int i = 0; i < n; i++) {
            if (state[i] != 0) {
                continue;
            }

            java.util.ArrayList<Integer> path = new java.util.ArrayList<>();
            int curr = i;

            while (curr >= 0 && curr < n && state[curr] == 0) {
                state[curr] = 1;
                path.add(curr);

                if (arr[curr] == 0) {
                    break;
                }

                curr += arr[curr];
            }

            boolean good = curr < 0 || curr >= n;

            if (curr >= 0 && curr < n && state[curr] == 2) {
                good = true;
            }

            for (int idx : path) {
                state[idx] = good ? 2 : 3;
            }
        }

        for (int x : state) {
            if (x == 2) {
                count++;
            }
        }

        return count;
    }
}