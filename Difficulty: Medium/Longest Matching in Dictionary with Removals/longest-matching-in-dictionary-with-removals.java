import java.util.*;

class Solution {
    public String findLongestWord(String s, List<String> d) {
        int n = s.length();

        // Store the positions of each character in s
        List<Integer>[] positions = new ArrayList[26];

        for (int i = 0; i < 26; i++) {
            positions[i] = new ArrayList<>();
        }

        for (int i = 0; i < n; i++) {
            positions[s.charAt(i) - 'a'].add(i);
        }

        String result = "";

        for (String word : d) {
            if (word.length() < result.length()) {
                continue;
            }

            int currentPos = -1;
            boolean valid = true;

            for (int k = 0; k < word.length(); k++) {
                List<Integer> list = positions[word.charAt(k) - 'a'];

                // Find the first occurrence strictly after currentPos
                int left = 0, right = list.size();

                while (left < right) {
                    int mid = left + (right - left) / 2;

                    if (list.get(mid) <= currentPos) {
                        left = mid + 1;
                    } else {
                        right = mid;
                    }
                }

                if (left == list.size()) {
                    valid = false;
                    break;
                }

                currentPos = list.get(left);
            }

            if (valid) {
                if (word.length() > result.length() ||
                    (word.length() == result.length() &&
                     word.compareTo(result) < 0)) {
                    result = word;
                }
            }
        }

        return result;
    }
}