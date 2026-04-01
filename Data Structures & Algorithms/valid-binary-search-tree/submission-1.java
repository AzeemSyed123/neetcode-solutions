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

        // step 1 do an in order traversal (left -> root -> right) to collect all values
        helper(root, inOrderList);

        //step 2 check if the list is strictly increasing 
        // a valid bst's in order traversal always produces a sort list
        boolean isBst = true;
        int prev = inOrderList.get(0);

        for(int i = 1 ; i< inOrderList.size(); i++){
            //if current value is <= previous , its not a valid BST
            if(inOrderList.get(i) <= prev)
            isBst = false;
            prev = inOrderList.get(i);
        }
        return isBst;
   }
   void helper(TreeNode treeNode, List<Integer> inOrderList){
    if(treeNode == null)
    return;
    helper(treeNode.left, inOrderList);
    inOrderList.add(treeNode.val);
    helper(treeNode.right, inOrderList);
   }
}
// Time:  O(n) — visit every node once + one pass through the list
// Space: O(n) — storing all values in the list