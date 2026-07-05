class Solution {
    public int maxCharGap(String s) {

        int[] first = new int[26];

        for (int i = 0; i < 26; i++) {
            first[i] = -1;
        }

        int ans = -1;

        for (int i = 0; i < s.length(); i++) {

            int idx = s.charAt(i) - 'a';

            if (first[idx] == -1) {
                first[idx] = i;
            } else {
                ans = Math.max(ans, i - first[idx] - 1);
            }
        }

        return ans;
    }
}