class Solution {
    public int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int numberOfLevels= 0;
        while(true){
            int countAtlevel = queue.size();
            if(countAtlevel == 0){
                return numberOfLevels;
            }
            while(countAtlevel > 0 ){
                TreeNode element = queue.poll();
                if(element.left != null)
                queue.add(element.left);
                if(element.right != null)
                queue.add(element.right);
                countAtlevel --;
            }
            numberOfLevels++;
        }



               
        
    }
}