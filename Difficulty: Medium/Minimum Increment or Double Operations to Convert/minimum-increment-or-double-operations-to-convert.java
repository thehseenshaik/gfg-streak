class Solution {
    public int countMinOperations(int arr[]) {

        int count = 0;
        int n = arr.length;

        while (true) {

            boolean allZero = true;

            // Reduce all odd numbers by 1
            for (int i = 0; i < n; i++) {

                if (arr[i] % 2 == 1) {
                    arr[i]--;
                    count++;
                }

                if (arr[i] != 0) {
                    allZero = false;
                }
            }

            // Stop if every element became 0
            if (allZero)
                break;

            // Reverse of doubling
            for (int i = 0; i < n; i++) {
                arr[i] /= 2;
            }

            count++;
        }

        return count;
    }
}