class Solution {
    public int maxSubsetXOR(int[] arr) {

        int n = arr.length;
        int index = 0;

        for (int bit = 31; bit >= 0; bit--) {

            int maxIndex = -1;

            for (int i = index; i < n; i++) {
                if (((arr[i] >> bit) & 1) == 1) {
                    maxIndex = i;
                    break;
                }
            }

            if (maxIndex == -1)
                continue;

            int temp = arr[index];
            arr[index] = arr[maxIndex];
            arr[maxIndex] = temp;

            for (int i = 0; i < n; i++) {
                if (i != index && ((arr[i] >> bit) & 1) == 1) {
                    arr[i] ^= arr[index];
                }
            }

            index++;
        }

        int ans = 0;

        for (int x : arr) {
            ans = Math.max(ans, ans ^ x);
        }

        return ans;
    }
}