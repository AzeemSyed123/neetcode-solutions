/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public boolean isValidBST(TreeNode root) {
        List<Integer> inOrderList = new LinkedList<>();

        // Step 1: Do an in-order traversal (left → root → right) to collect all values
        helper(root, inOrderList);

        // Step 2: Check if the list is strictly increasing
        // A valid BST's in-order traversal always produces a sorted list
        boolean isBST = true;
        int prev = inOrderList.get(0);

        for (int i = 1; i < inOrderList.size(); i++) {
            // If current value is <= previous, it's not a valid BST
            if (inOrderList.get(i) <= prev)
                isBST = false;
            prev = inOrderList.get(i);
        }

        return isBST;
    }

    // In-order traversal: left subtree → current node → right subtree
    void helper(TreeNode treeNode, List<Integer> inOrderList) {
        if (treeNode == null)
            return;
        helper(treeNode.left, inOrderList);   // go left first
        inOrderList.add(treeNode.val);         // then record current value
        helper(treeNode.right, inOrderList);   // then go right
    }
}
// Time:  O(n) — visit every node once + one pass through the list
// Space: O(n) — storing all values in the list