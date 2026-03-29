class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        if (root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();          // how many nodes are in THIS level
            List<Integer> currentLevel = new ArrayList<>();

            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();       // grab the next node
                currentLevel.add(node.val);         // record its value

                if (node.left != null) queue.add(node.left);   // queue up next level
                if (node.right != null) queue.add(node.right);
            }

            result.add(currentLevel);              // done with this level, save it
        }

        return result;
        
    }
}




