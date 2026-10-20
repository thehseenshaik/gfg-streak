class Solution {
    public ArrayList<Integer> lexicographicallyLargest(int[] arr) {
        int n = arr.length;
        int i = 0;

        while (i < n) {
            int j = i;

            while (j < n && arr[j] % 2 == arr[i] % 2) {
                j++;
            }

            java.util.Arrays.sort(arr, i, j);

            int left = i, right = j - 1;

            while (left < right) {
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                left++;
                right--;
            }

            i = j;
        }

        ArrayList<Integer> result = new ArrayList<>();
        for (int num : arr) {
            result.add(num);
        }

        return result;
    }
}