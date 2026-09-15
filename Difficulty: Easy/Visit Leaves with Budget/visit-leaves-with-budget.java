import java.util.*;

class Solution {
    public int getCount(Node root, int k) {
        ArrayList<Integer> levels = new ArrayList<>();

        findLeaves(root, 1, levels);

        Collections.sort(levels);

        int count = 0;
        int cost = 0;

        for (int level : levels) {
            if (cost + level > k)
                break;

            cost += level;
            count++;
        }

        return count;
    }

    private void findLeaves(Node root, int level, ArrayList<Integer> levels) {
        if (root == null)
            return;

        if (root.left == null && root.right == null) {
            levels.add(level);
            return;
        }

        findLeaves(root.left, level + 1, levels);
        findLeaves(root.right, level + 1, levels);
    }
}