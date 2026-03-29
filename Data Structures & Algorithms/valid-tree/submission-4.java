class Solution {
    // class level variable so both methods can access it
    // tracks how many nodes we visited
    int cnt;

    public boolean validTree(int n, int[][] edges) {
        int m = edges.length;
        // a valid tree with n nodes must have exactly n-1 edges
        // fewer = disconnected, more = has a cycle
        if (m != n - 1)
            return false;
        // tracks which nodes we've already visited
        boolean vis[] = new boolean[n];
        // create an empty adjacency list with space for n nodes
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>(n);
        // initialize an empty neighbor list for each node
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        // build the graph by adding each edge in both directions
        // because the graph is undirected
        for (int i = 0; i < edges.length; i++) {
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }
        // start count at 1 (counting node 0 itself)
        cnt = 1;
        // run DFS starting from node 0
        dfs(adj, vis, 0);
        // if we visited all n nodes, the graph is connected
        // combined with n-1 edges check, it's a valid tree
        return cnt == n;
    }

    void dfs(ArrayList<ArrayList<Integer>> adj, boolean vis[], int st) {
        // mark current node as visited
        vis[st] = true;
        // loop through all neighbors of current node
        for (int nei : adj.get(st)) {
            // only visit unvisited neighbors
            if (!vis[nei]) {
                // found a new node, increment count
                cnt++;
                // go deeper into this neighbor  
                dfs(adj, vis, nei);
            }
        }
    }
}