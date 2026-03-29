class Solution {
    int cnt;
    public boolean validTree(int n, int[][] edges) {
        int m = edges.length;

        if (m != n-1)
        return false;
        
        boolean vis[] = new boolean[n];

        //create adjacency list
      
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        
        // create empty lists in the adj list for each node
        for(int i = 0 ; i < n ; i++){
            adj.add(new ArrayList<>());
        }
        // add edges for each node in both directions 
        for(int i = 0 ; i < m ; i++){
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }
        cnt = 1;
        //run dfs starting from node 0
        dfs(adj, vis, 0);
        return cnt == n;

    }
    void dfs(ArrayList<ArrayList<Integer>> adj, boolean vis[], int st){
        vis[st] = true;
        for(int nei : adj.get(st)){
            if (!vis[nei]){
                cnt++;
                dfs(adj, vis, nei);
            }
        }

    }
}