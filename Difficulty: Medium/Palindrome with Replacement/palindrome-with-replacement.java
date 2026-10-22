class Solution {
    public int minimumSum(String s) {
        int n = s.length();
        int m = (n + 1) / 2;
        int[] cost = new int[26];
        int[] next = new int[26];

        for (int c = 0; c < 26; c++) {
            cost[c] = 0;
        }

        char[] a = new char[m];

        for (int i = 0; i < m; i++) {
            char left = s.charAt(i);
            char right = s.charAt(n - 1 - i);

            if (left != '?' && right != '?' && left != right) {
                return -1;
            }

            if (left != '?') {
                a[i] = left;
            } else if (right != '?') {
                a[i] = right;
            } else {
                a[i] = '?';
            }
        }

        for (int c = 0; c < 26; c++) {
            cost[c] = a[0] == '?' || a[0] == (char) ('a' + c) ? 0 : 100000000;
        }

        for (int i = 1; i < m; i++) {
            for (int c = 0; c < 26; c++) {
                next[c] = 100000000;

                if (a[i] != '?' && a[i] != (char) ('a' + c)) {
                    continue;
                }

                for (int p = 0; p < 26; p++) {
                    next[c] = Math.min(next[c],
                        cost[p] + Math.abs(c - p) * (i == n - 1 - i ? 1 : 2));
                }
            }

            int[] temp = cost;
            cost = next;
            next = temp;
        }

        int ans = Integer.MAX_VALUE;
        for (int c = 0; c < 26; c++) {
            ans = Math.min(ans, cost[c]);
        }

        return ans;
    }
}