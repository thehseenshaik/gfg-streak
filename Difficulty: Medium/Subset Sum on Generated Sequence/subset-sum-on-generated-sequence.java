class Solution {
    public boolean isPossible(int[] arr, int s, int x) {

        long[] nums = new long[arr.length + 1];

        nums[0] = s;

        long sum = s;
        int size = 1;

        for (int i = 0; i < arr.length; i++) {

            long next = sum + arr[i];

            nums[size++] = next;
            sum += next;

            // Once next > x, all further numbers will also be > x
            if (next > x) {
                break;
            }
        }

        // Greedily take the largest possible numbers
        long target = x;

        for (int i = size - 1; i >= 0; i--) {

            if (nums[i] <= target) {
                target -= nums[i];
            }

            if (target == 0) {
                return true;
            }
        }

        return false;
    }
}