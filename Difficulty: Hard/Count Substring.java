import java.util.*;

class Solution {

    class Fenwick {
        int[] bit;

        Fenwick(int n) {
            bit = new int[n + 2];
        }

        void update(int idx) {
            while (idx < bit.length) {
                bit[idx]++;
                idx += idx & -idx;
            }
        }

        int query(int idx) {
            int sum = 0;
            while (idx > 0) {
                sum += bit[idx];
                idx -= idx & -idx;
            }
            return sum;
        }
    }

    public int countSubstring(String s) {

        int n = s.length();

        int[] prefix = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            if (s.charAt(i - 1) == '1')
                prefix[i] = prefix[i - 1] + 1;
            else
                prefix[i] = prefix[i - 1] - 1;
        }

        int[] temp = prefix.clone();
        Arrays.sort(temp);

        HashMap<Integer, Integer> map = new HashMap<>();
        int rank = 1;

        for (int x : temp) {
            if (!map.containsKey(x)) {
                map.put(x, rank++);
            }
        }

        Fenwick bit = new Fenwick(rank);

        long ans = 0;

        for (int x : prefix) {
            int idx = map.get(x);

            ans += bit.query(idx - 1);

            bit.update(idx);
        }

        return (int) ans;
    }
}
