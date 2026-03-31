class Solution {
    int cnt; // counts how many nodes are reachable from node 0

    public boolean validTree(int n, int[][] edges) {
        int m = edges.length;
        boolean vis[] = new boolean[n];

        // A tree with n nodes MUST have exactly n-1 edges
        // Fewer = disconnected, more = has a cycle
        if (m != n - 1) {
            return false;
        }

        // Build adjacency list (undirected graph)
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++)
            adj.add(new ArrayList<>());

        for (int i = 0; i < m; i++) {
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }

        // DFS from node 0 and count how many nodes we can reach
        cnt = 1; // start with node 0 itself
        dfs(adj, vis, 0);

        // If all n nodes are reachable → it's connected + n-1 edges → valid tree
        return cnt == n;
    }

    void dfs(ArrayList<ArrayList<Integer>> adj, boolean vis[], int st) {
        vis[st] = true;

        for (int nei : adj.get(st)) {
            if (!vis[nei]) {
                cnt++;                  // found another reachable node
                dfs(adj, vis, nei);     // keep exploring from this neighbor
            }
        }
    }
}
// Time:  O(V + E) — visit every node and edge once
// Space: O(V + E) — adjacency list + visited array + recursion stack