class Solution {
    public String compress(String s) {

        int n = s.length();

        // LPS / Prefix Function
        int[] lps = new int[n];

        for (int i = 1; i < n; i++) {

            int j = lps[i - 1];

            while (j > 0 && s.charAt(i) != s.charAt(j)) {
                j = lps[j - 1];
            }

            if (s.charAt(i) == s.charAt(j)) {
                j++;
            }

            lps[i] = j;
        }

        StringBuilder ans = new StringBuilder();

        int i = n - 1;

        while (i >= 0) {

            if (i % 2 == 1) {

                int len = i + 1;
                int border = lps[i];

                // Check whether the whole prefix is made
                // by repeating its first half
                if (border >= len / 2 &&
                    len % (2 * (len - border)) == 0) {

                    ans.append('*');

                    // Jump to the first half
                    i = i / 2 + 1;
                }
                else {
                    ans.append(s.charAt(i));
                }

            }
            else {
                ans.append(s.charAt(i));
            }

            i--;
        }

        return ans.reverse().toString();
    }
}