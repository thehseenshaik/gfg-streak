class Solution {
    public int maximumSubarray(int[] arr) {
        long noSquare = arr[0];
        long oneSquare = (long) arr[0] * arr[0];

        long ans = Math.max(noSquare, oneSquare);

        for (int i = 1; i < arr.length; i++) {
            long x = arr[i];

            long newOneSquare = Math.max(
                x * x,
                Math.max(oneSquare + x, noSquare + x * x)
            );

            long newNoSquare = Math.max(x, noSquare + x);

            noSquare = newNoSquare;
            oneSquare = newOneSquare;

            ans = Math.max(ans, Math.max(noSquare, oneSquare));
        }

        return (int) ans;
    }
}