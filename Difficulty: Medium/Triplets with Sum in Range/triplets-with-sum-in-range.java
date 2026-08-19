class Solution {

    public int countTriplets(int[] arr, int l, int r) {
        Arrays.sort(arr);

        return (int)(count(arr, r) - count(arr, l - 1));
    }

    private long count(int[] arr, int x) {
        int n = arr.length;
        long ans = 0;

        for (int i = 0; i < n - 2; i++) {
            int j = i + 1;
            int k = n - 1;

            while (j < k) {
                long sum = (long) arr[i] + arr[j] + arr[k];

                if (sum <= x) {
                    ans += k - j;
                    j++;
                } else {
                    k--;
                }
            }
        }

        return ans;
    }
}