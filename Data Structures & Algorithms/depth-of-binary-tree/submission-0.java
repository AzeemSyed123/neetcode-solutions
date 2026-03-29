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
    public int maxDepth(TreeNode root) {
        
        if(root == null){
            return 0;
        }
        Queue <TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int numberOfLevels = 0;

        while (true){
            int nodeCountAtLevel = queue.size();
            if(nodeCountAtLevel == 0){
                return numberOfLevels;
            }
            while (nodeCountAtLevel > 0 ){
                TreeNode element = queue.poll();
                if(element.left != null)
                queue.add(element.left);
                if(element.right != null)
                queue.add(element.right);
                nodeCountAtLevel--;
            }
            numberOfLevels++;
        }
    }
}