import java.util.*;

class Solution {
    public ArrayList<ArrayList<Integer>> searchWord(char[][] mat, String word) {

        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

        int n = mat.length;
        int m = mat[0].length;

        int[] dr = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] dc = {-1, 0, 1, -1, 1, -1, 0, 1};

        // Row-wise and column-wise traversal gives lexicographical order
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if (mat[i][j] != word.charAt(0)) continue;

                boolean found = false;

                // Check all 8 directions
                for (int dir = 0; dir < 8 && !found; dir++) {

                    int r = i;
                    int c = j;
                    int k;

                    for (k = 0; k < word.length(); k++) {

                        if (r < 0 || r >= n || c < 0 || c >= m ||
                            mat[r][c] != word.charAt(k)) {
                            break;
                        }

                        r += dr[dir];
                        c += dc[dir];
                    }

                    if (k == word.length()) {
                        found = true;
                    }
                }

                if (found) {
                    ArrayList<Integer> pos = new ArrayList<>();
                    pos.add(i);
                    pos.add(j);
                    ans.add(pos);
                }
            }
        }

        return ans;
    }
}