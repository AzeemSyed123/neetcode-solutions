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
    public TreeNode invertTree(TreeNode root) {
        if ( root == null){
            return null;
        }
        Queue <TreeNode> queue = new LinkedList();
        queue.add(root);

        while(!queue.isEmpty()){
            final TreeNode element = queue.poll();

            final TreeNode temp = element.left;
            element.left= element.right;
            element.right= temp;

            if(element.left!= null){
                queue.add(element.left);
                }

            if (element.right!=null){
                queue.add(element.right);
            }    
        }
        return root;
    }
}
