class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null){
            return result;
        }

        // BFS uses a queue - process nodes level by level (fifo)
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()){
            int levelSize = queue.size();
            //snapshot the number of nodes at the current level
            List<Integer>currentLevel = new ArrayList<>();

            //process all nodes at the current level
            for(int i = 0 ; i< levelSize; i++){
                TreeNode node = queue.poll();
                //dequeue front node
                currentLevel.add(node.val);
                //enqueue children for the next level
                if(node.left != null)
                queue.add(node.left);
                if(node.right != null)
                queue.add(node.right);
                
            }
            result.add(currentLevel);
        }
        return result;
    }
}
// Time:  O(n) — visit every node once
// Space: O(n) — queue holds at most one full level of nodes