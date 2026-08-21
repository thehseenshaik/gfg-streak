class Solution {
    int transform(String s1, String s2) {

        if (s1.length() != s2.length()) {
            return -1;
        }

        // Check if both strings have same characters
        int[] freq = new int[256];

        for (int i = 0; i < s1.length(); i++) {
            freq[s1.charAt(i)]++;
            freq[s2.charAt(i)]--;
        }

        for (int i = 0; i < 256; i++) {
            if (freq[i] != 0) {
                return -1;
            }
        }

        int i = s1.length() - 1;
        int j = s2.length() - 1;
        int count = 0;

        // Compare from right to left
        while (i >= 0) {
            if (s1.charAt(i) == s2.charAt(j)) {
                j--;
            } else {
                count++;
            }
            i--;
        }

        return count;
    }
}