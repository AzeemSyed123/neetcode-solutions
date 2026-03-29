/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {

        // Edge case: if the input graph is empty, return null
        if (node == null) return null;

        // HashMap to map each original node to its clone
        // Key: original node, Value: cloned copy of that node
        Map<Node, Node> mp = new HashMap<>();

        // Start the recursive cloning from the given node
        return cloneUtil(node, mp);
    }

    private Node cloneUtil(Node node, Map<Node, Node> mp) {

        // Step 1: Create a new clone node with the same value
        Node newNode = new Node(node.val);

        // Step 2: Record the mapping from original -> clone
        // This prevents infinite loops when we encounter this node again
        mp.put(node, newNode);

        // Step 3: Loop through all neighbors of the original node
        for (Node neighbor : node.neighbors) {

            if (!mp.containsKey(neighbor)) {
                // Neighbor hasn't been cloned yet, so recursively clone it
                // and add the cloned neighbor to our new node's neighbor list
                newNode.neighbors.add(cloneUtil(neighbor, mp));
            } else {
                // Neighbor was already cloned (we've visited it before),
                // so just grab the existing clone from the map
                // This is what prevents infinite loops in cyclic graphs
                newNode.neighbors.add(mp.get(neighbor));
            }
        }

        // Return the fully built clone with all its neighbors connected
        return newNode;
    }
}
