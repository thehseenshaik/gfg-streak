class Solution {
    public int minProd(int[] arr) {

        int negCount = 0;
        int zeroCount = 0;

        long product = 1;
        int minNeg = Integer.MAX_VALUE;
        int minPos = Integer.MAX_VALUE;

        for (int x : arr) {

            if (x == 0) {
                zeroCount++;
            }
            else if (x < 0) {
                negCount++;
                product *= x;
                minNeg = Math.min(minNeg, -x);
            }
            else {
                minPos = Math.min(minPos, x);

                if (x != 1) {
                    product *= x;
                }
            }
        }

        // No negative numbers
        if (negCount == 0) {
            if (zeroCount > 0)
                return 0;

            return minPos;
        }

        // Even number of negative numbers
        if (negCount % 2 == 0) {
            product /= -minNeg;
        }

        return (int) product;
    }
}