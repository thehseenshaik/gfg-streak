class Solution {
    public int maxValue(int n) {
        int ans = 0;
        int consecutive = 0;

        for (int i = 30; i >= 0; i--) {
            int bit = (n >> i) & 1;

            if (bit == 1) {
                if (consecutive == 2) {
                    consecutive = 0;
                } else {
                    ans |= (1 << i);
                    consecutive++;
                }
            } else {
                consecutive = 0;
            }
        }

        return ans;
    }
}