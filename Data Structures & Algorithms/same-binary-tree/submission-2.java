class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(p);
        queue.add(q);

        while(!queue.isEmpty()){
            TreeNode leftNode = queue.poll();
            TreeNode rightNode = queue.poll();

            if(leftNode==null && rightNode == null){
                continue;
            }else if (leftNode == null || rightNode == null || leftNode.val != rightNode.val){
                return false;
            }
            queue.add(leftNode.left);
            queue.add(rightNode.left);
            queue.add(leftNode.right);
            queue.add(rightNode.right);
        }
        return true;

    }
}
    
