class Solution {
    public TreeNode invertTree(TreeNode root) {
        if(root==null){
            return null;
        }

        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);

        while(!queue.isEmpty()){

            TreeNode element = queue.poll();

            TreeNode temp = element.left;
            element.left = element.right;
            element.right = temp;

            if(element.left != null)
                queue.add(element.left);

            
            if(element.right != null)
                queue.add(element.right);

        
        }
        return root;
        
    }
}
