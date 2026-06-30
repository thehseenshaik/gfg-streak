import java.util.*;

class Solution {
    public int minInsAndDel(int[] a, int[] b) {
        HashMap<Integer, Integer> map = new HashMap<>();

        // Store index of each element in b
        for (int i = 0; i < b.length; i++) {
            map.put(b[i], i);
        }

        // Create sequence of indices
        ArrayList<Integer> seq = new ArrayList<>();
        for (int x : a) {
            if (map.containsKey(x)) {
                seq.add(map.get(x));
            }
        }

        // Find LIS length
        ArrayList<Integer> lis = new ArrayList<>();

        for (int x : seq) {
            int pos = Collections.binarySearch(lis, x);

            if (pos < 0)
                pos = -(pos + 1);

            if (pos == lis.size())
                lis.add(x);
            else
                lis.set(pos, x);
        }

        int lcs = lis.size();

        return (a.length - lcs) + (b.length - lcs);
    }
}