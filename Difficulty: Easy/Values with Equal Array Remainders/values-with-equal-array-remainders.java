class Solution {
    public int sameMod(int[] arr) {
        boolean same = true;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != arr[0]) {
                same = false;
                break;
            }
        }

        if (same) return -1;

        int g = 0;

        for (int i = 1; i < arr.length; i++) {
            g = gcd(g, Math.abs(arr[i] - arr[0]));
        }

        int count = 0;

        for (int i = 1; i * i <= g; i++) {
            if (g % i == 0) {
                count++;
                if (i != g / i)
                    count++;
            }
        }

        return count;
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }
}