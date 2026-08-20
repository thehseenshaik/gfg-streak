class Solution {

    int ans = Integer.MIN_VALUE;

    int maxDiff(Node root) {
        findMin(root);
        return ans;
    }

    int findMin(Node root) {

        if (root == null) {
            return Integer.MAX_VALUE;
        }

        // Leaf node
        if (root.left == null && root.right == null) {
            return root.data;
        }

        int leftMin = findMin(root.left);
        int rightMin = findMin(root.right);

        int minDescendant = Math.min(leftMin, rightMin);

        // Current node - minimum descendant
        ans = Math.max(ans, root.data - minDescendant);

        // Return minimum value in this subtree
        return Math.min(root.data, minDescendant);
    }
}