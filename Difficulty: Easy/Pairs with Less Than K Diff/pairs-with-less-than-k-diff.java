import java.util.Arrays;

class Solution {
    public static int countPairs(int arr[], int k) {

        Arrays.sort(arr);

        int n = arr.length;
        int left = 0;
        int right = 1;
        int count = 0;

        while (right < n) {

            if (arr[right] - arr[left] < k) {
                count += (right - left);
                right++;
            } else {
                left++;

                if (left == right) {
                    right++;
                }
            }
        }

        return count;
    }
}