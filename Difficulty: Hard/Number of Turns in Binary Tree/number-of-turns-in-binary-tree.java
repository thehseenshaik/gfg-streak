class Solution {

    public int numberOfTurns(Node root, int p, int q) {

        Node lca = findLCA(root, p, q);

        StringBuilder pathP = new StringBuilder();
        StringBuilder pathQ = new StringBuilder();

        findPath(lca, p, pathP);
        findPath(lca, q, pathQ);

        StringBuilder path = new StringBuilder();

        // Actual path is p -> LCA, so reverse LCA -> p path
        path.append(pathP.reverse());

        // Then LCA -> q
        path.append(pathQ);

        int turns = 0;

        for (int i = 1; i < path.length(); i++) {
            if (path.charAt(i) != path.charAt(i - 1)) {
                turns++;
            }
        }

        return turns == 0 ? -1 : turns;
    }

    private Node findLCA(Node root, int p, int q) {

        if (root == null || root.data == p || root.data == q) {
            return root;
        }

        Node left = findLCA(root.left, p, q);
        Node right = findLCA(root.right, p, q);

        if (left != null && right != null) {
            return root;
        }

        return left != null ? left : right;
    }

    private boolean findPath(Node root, int target, StringBuilder path) {

        if (root == null) {
            return false;
        }

        if (root.data == target) {
            return true;
        }

        path.append('L');

        if (findPath(root.left, target, path)) {
            return true;
        }

        path.deleteCharAt(path.length() - 1);

        path.append('R');

        if (findPath(root.right, target, path)) {
            return true;
        }

        path.deleteCharAt(path.length() - 1);

        return false;
    }
}