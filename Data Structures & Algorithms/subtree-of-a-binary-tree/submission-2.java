class Solution {  
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {

        String fullTree = preOrderTraversal(root);
        String subTree = preOrderTraversal(subRoot);

        return(fullTree.contains(subTree));
    }
}

String preOrderTraversal( TreeNode root){
    if(root == null){
        return null;
    }

    StringBuilder sb = new StringBuilder("^");

    sb.append(root.val);
    sb.append(preOrderTraversal(root.left));
    sb.append(preOrderTraversal(root.right));
    return sb.toString();
}