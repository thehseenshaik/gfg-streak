/* Structure of Binary Tree Node
class Node {
    int data;
    Node left, right;

    Node(int val) {
        data = val;
        left = right = null;
    }
}
*/

class Solution {

    int preIndex;
    HashMap<Integer, Integer> map;

    Node build(int[] pre, int l, int r) {

        if (preIndex >= pre.length || l > r)
            return null;

        Node root = new Node(pre[preIndex++]);

        // Leaf node
        if (l == r || preIndex >= pre.length)
            return root;

        int idx = map.get(pre[preIndex]);

        root.left = build(pre, idx, r);
        root.right = build(pre, l + 1, idx - 1);

        return root;
    }

    public Node constructBinaryTree(int[] pre, int[] preMirror) {

        preIndex = 0;
        map = new HashMap<>();

        for (int i = 0; i < preMirror.length; i++) {
            map.put(preMirror[i], i);
        }

        return build(pre, 0, preMirror.length - 1);
    }
}