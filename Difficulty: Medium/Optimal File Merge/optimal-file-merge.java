class Solution {
    public int minComputation(int[] files) {
        java.util.PriorityQueue<Integer> pq =
            new java.util.PriorityQueue<>();

        for (int file : files) {
            pq.offer(file);
        }

        int cost = 0;

        while (pq.size() > 1) {
            int a = pq.poll();
            int b = pq.poll();

            int sum = a + b;
            cost += sum;

            pq.offer(sum);
        }

        return cost;
    }
}