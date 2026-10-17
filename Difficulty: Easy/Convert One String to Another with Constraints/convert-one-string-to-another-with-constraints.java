class Solution {
    public boolean isItPossible(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }

        int i = 0, j = 0;
        int n = s1.length();

        while (i < n && j < n) {
            while (i < n && s1.charAt(i) == '#') i++;
            while (j < n && s2.charAt(j) == '#') j++;

            if (i == n || j == n) {
                return i == n && j == n;
            }

            char c = s1.charAt(i);

            if (c != s2.charAt(j)) {
                return false;
            }

            if (c == 'A' && i < j) {
                return false;
            }

            if (c == 'B' && i > j) {
                return false;
            }

            i++;
            j++;
        }

        return true;
    }
}