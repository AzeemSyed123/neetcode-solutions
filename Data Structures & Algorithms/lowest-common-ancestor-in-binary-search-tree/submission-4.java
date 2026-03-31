class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // Base case: empty tree
        if (root == null) {
            return null;
        }

        int curr = root.val;

        // Both p and q are larger → LCA must be in the right subtree
        if (curr < p.val && curr < q.val) {
            return lowestCommonAncestor(root.right, p, q);
        }

        // Both p and q are smaller → LCA must be in the left subtree
        if (curr > p.val && curr > q.val) {
            return lowestCommonAncestor(root.left, p, q);
        }

        // p and q are on different sides (or one equals curr) → this is the LCA
        return root;
    }
}
// Time:  O(h) — h is the height of the tree (O(log n) if balanced)
// Space: O(h) — recursion stack