class Solution {
    public int solve(int n, String s) {

        int[] state = new int[26];
        // 0 = not seen
        // 1 = currently using a computer
        // 2 = rejected
        // 3 = completed

        int available = n;
        int rejected = 0;

        for (int i = 0; i < s.length(); i++) {

            int ch = s.charAt(i) - 'A';

            // Arrival
            if (state[ch] == 0) {

                if (available > 0) {
                    state[ch] = 1;
                    available--;
                } else {
                    state[ch] = 2;
                    rejected++;
                }
            }

            // Departure
            else {

                // Customer had a computer, so free it
                if (state[ch] == 1) {
                    available++;
                }

                state[ch] = 3;
            }
        }

        return rejected;
    }
}