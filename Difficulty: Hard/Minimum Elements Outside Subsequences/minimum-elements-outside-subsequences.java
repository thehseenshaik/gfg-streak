import java.util.*;

class Solution {
    public int minCount(int[] arr) {

        int MAX = 101; // arr[i] <= 100
        int[][] dp = new int[102][102];

        // dp[inc][dec] = maximum elements selected
        // inc = last element of increasing subsequence
        // dec = last element of decreasing subsequence

        dp[0][101] = 0;

        for (int x : arr) {

            int[][] next = new int[102][102];

            for (int inc = 0; inc <= 100; inc++) {
                for (int dec = 1; dec <= 101; dec++) {

                    if (dp[inc][dec] == 0 &&
                        !(inc == 0 && dec == 101)) {
                        continue;
                    }

                    // Option 1: Don't use current element
                    next[inc][dec] = Math.max(
                        next[inc][dec],
                        dp[inc][dec]
                    );

                    // Option 2: Add to increasing subsequence
                    if (x > inc) {
                        next[x][dec] = Math.max(
                            next[x][dec],
                            dp[inc][dec] + 1
                        );
                    }

                    // Option 3: Add to decreasing subsequence
                    if (x < dec) {
                        next[inc][x] = Math.max(
                            next[inc][x],
                            dp[inc][dec] + 1
                        );
                    }
                }
            }

            dp = next;
        }

        int maxUsed = 0;

        for (int inc = 0; inc <= 100; inc++) {
            for (int dec = 1; dec <= 101; dec++) {
                maxUsed = Math.max(maxUsed, dp[inc][dec]);
            }
        }

        return arr.length - maxUsed;
    }
}