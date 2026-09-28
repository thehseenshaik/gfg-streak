import java.util.*;

class Solution {
    public ArrayList<Integer> processQueries(int[] arr, int[][] queries) {
        int n = arr.length;

        int size = 1;
        while (size < n) {
            size *= 2;
        }

        int[] tree = new int[2 * size];

        // Build segment tree
        for (int i = 0; i < n; i++) {
            tree[size + i] = arr[i];
        }

        for (int i = size - 1; i >= 1; i--) {
            tree[i] = gcd(tree[2 * i], tree[2 * i + 1]);
        }

        ArrayList<Integer> result = new ArrayList<>();

        for (int[] query : queries) {

            if (query[0] == 0) {
                // GCD query: [0, l, r]
                int l = query[1] + size;
                int r = query[2] + size;

                int leftGcd = 0;
                int rightGcd = 0;

                while (l <= r) {
                    if ((l & 1) == 1) {
                        leftGcd = gcd(leftGcd, tree[l]);
                        l++;
                    }

                    if ((r & 1) == 0) {
                        rightGcd = gcd(tree[r], rightGcd);
                        r--;
                    }

                    l /= 2;
                    r /= 2;
                }

                result.add(gcd(leftGcd, rightGcd));

            } else {
                // Update query: [1, index, value]
                int index = query[1];
                int value = query[2];

                int pos = size + index;
                tree[pos] = value;

                pos /= 2;

                while (pos >= 1) {
                    tree[pos] = gcd(tree[2 * pos], tree[2 * pos + 1]);
                    pos /= 2;
                }
            }
        }

        return result;
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }

        return a;
    }
}