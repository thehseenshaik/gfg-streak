class Solution {
    public int findMax(int n) {
        int ans = n;
        int maxSum = digitSum(n);

        for (int p = 1; p <= n; p *= 10) {
            int x = (n / p - 1) * p + (p - 1);

            if (x >= 1 && x <= n) {
                int sum = digitSum(x);

                if (sum > maxSum || (sum == maxSum && x > ans)) {
                    maxSum = sum;
                    ans = x;
                }
            }

            if (p > n / 10) break;
        }

        return ans;
    }

    private int digitSum(int x) {
        int sum = 0;

        while (x > 0) {
            sum += x % 10;
            x /= 10;
        }

        return sum;
    }
}