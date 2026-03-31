class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        // BFS uses a queue — process nodes level by level (FIFO)
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();               // snapshot: number of nodes at this level
            List<Integer> currentLevel = new ArrayList<>();

            // Process all nodes at the current level
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();            // dequeue front node
                currentLevel.add(node.val);              // record its value

                // Enqueue children for the next level
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }

            result.add(currentLevel);                   // save this level's values
        }

        return result;
    }
}
// Time:  O(n) — visit every node once
// Space: O(n) — queue holds at most one full level of nodes