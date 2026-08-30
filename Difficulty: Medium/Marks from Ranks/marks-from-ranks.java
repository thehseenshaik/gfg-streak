import java.util.*;

class Solution {
    public ArrayList<Integer> getMarks(int[] l, int[] r, int[] rank) {

        int n = l.length;
        int[] prefix = new int[n];

        // Count of marks up to each interval
        for (int i = 0; i < n; i++) {
            int count = r[i] - l[i] + 1;

            if (i == 0)
                prefix[i] = count;
            else
                prefix[i] = prefix[i - 1] + count;
        }

        ArrayList<Integer> ans = new ArrayList<>();

        for (int x : rank) {

            int low = 0;
            int high = n - 1;

            // Find interval containing this rank
            while (low < high) {
                int mid = low + (high - low) / 2;

                if (prefix[mid] >= x)
                    high = mid;
                else
                    low = mid + 1;
            }

            int i = low;

            int previous = (i == 0) ? 0 : prefix[i - 1];

            int mark = l[i] + (x - previous - 1);

            ans.add(mark);
        }

        return ans;
    }
}