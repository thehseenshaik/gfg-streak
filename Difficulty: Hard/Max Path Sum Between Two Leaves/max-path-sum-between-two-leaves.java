class Solution {
    int ans;

    int solve(Node root) {
        if (root == null)
            return 0;

        if (root.left == null && root.right == null)
            return root.data;

        int left = solve(root.left);
        int right = solve(root.right);

        if (root.left != null && root.right != null) {
            ans = Math.max(ans, left + root.data + right);
            return root.data + Math.max(left, right);
        }

        if (root.left != null)
            return root.data + left;

        return root.data + right;
    }

    public int maxPathSum(Node root) {
        if (root == null)
            return -1;

        ans = Integer.MIN_VALUE;
        solve(root);

        return ans == Integer.MIN_VALUE ? -1 : ans;
    }
}