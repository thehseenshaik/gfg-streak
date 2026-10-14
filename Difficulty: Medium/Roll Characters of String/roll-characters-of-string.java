class Solution {
    public String findRollOut(String s, int[] roll) {
        int n = s.length();
        int[] diff = new int[n + 1];

        for (int r : roll) {
            diff[0]++;
            diff[r]--;
        }

        char[] arr = s.toCharArray();
        int count = 0;

        for (int i = 0; i < n; i++) {
            count += diff[i];
            arr[i] = (char) ('a' + (arr[i] - 'a' + count) % 26);
        }

        return new String(arr);
    }
}