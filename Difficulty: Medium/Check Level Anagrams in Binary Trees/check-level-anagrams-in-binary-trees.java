import java.util.*;

class Solution {
    public boolean areAnagrams(Node root1, Node root2) {

        if (root1 == null && root2 == null)
            return true;

        if (root1 == null || root2 == null)
            return false;

        Queue<Node> q1 = new LinkedList<>();
        Queue<Node> q2 = new LinkedList<>();

        q1.offer(root1);
        q2.offer(root2);

        while (!q1.isEmpty() && !q2.isEmpty()) {

            int size1 = q1.size();
            int size2 = q2.size();

            if (size1 != size2)
                return false;

            HashMap<Integer, Integer> freq = new HashMap<>();

            // Count frequencies of the first tree's level
            for (int i = 0; i < size1; i++) {
                Node curr = q1.poll();

                freq.put(curr.data,
                         freq.getOrDefault(curr.data, 0) + 1);

                if (curr.left != null)
                    q1.offer(curr.left);

                if (curr.right != null)
                    q1.offer(curr.right);
            }

            // Match frequencies using the second tree's level
            for (int i = 0; i < size2; i++) {
                Node curr = q2.poll();

                if (!freq.containsKey(curr.data))
                    return false;

                freq.put(curr.data, freq.get(curr.data) - 1);

                if (freq.get(curr.data) == 0)
                    freq.remove(curr.data);

                if (curr.left != null)
                    q2.offer(curr.left);

                if (curr.right != null)
                    q2.offer(curr.right);
            }

            if (!freq.isEmpty())
                return false;
        }

        return q1.isEmpty() && q2.isEmpty();
    }
}