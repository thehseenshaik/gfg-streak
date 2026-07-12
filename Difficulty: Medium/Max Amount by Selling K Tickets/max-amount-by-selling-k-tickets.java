class Solution {
    public int maxAmount(int[] arr, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int x : arr) {
            pq.offer(x);
        }

        long ans = 0;
        long mod = 1000000007L;

        while (k > 0 && !pq.isEmpty()) {
            int curr = pq.poll();
            ans = (ans + curr) % mod;

            if (curr > 1) {
                pq.offer(curr - 1);
            }

            k--;
        }

        return (int) ans;
    }
}