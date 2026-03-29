class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(p);
        queue.add(q);

        while(!queue.isEmpty()){
            TreeNode leftRoot = queue.poll();
            TreeNode rightRoot = queue.poll();

            // equality check
            if(leftRoot == null && rightRoot == null){
                continue;
            }else if ( leftRoot == null || rightRoot == null || leftRoot.val != rightRoot.val){
                return false;
            }

            queue.add(leftRoot.left);
            queue.add(rightRoot.left);
            queue.add(leftRoot.right);
            queue.add(rightRoot.right);
        
        }
        return true;
    }
}
