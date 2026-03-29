class Solution {
    int cnt;
    public boolean validTree(int n, int[][] edges) {
        int m = edges.length;

        if(m != n-1)
        return false;
    

    boolean vis [] = new boolean[n] ;
    // create anf empty adjacency list with space for n nodes
    ArrayList<ArrayList<Integer>> adj = new ArrayList<>(n); //[]
    //initialize an emoty neighbor list for each node 
    for(int i = 0 ; i < n ; i++){
        adj.add(new ArrayList<>()); //[[][][][][]]
    }
    //build the graph by adding each edge in both directions
    //because the graph is undirected
    for ( int i = 0 ; i < m ; i++){
        adj.get(edges[i][0]).add(edges[i][1]);
        adj.get(edges[i][1]).add(edges[i][0]);
    }
    // start count at 1 (counting node 0 itself)
    cnt = 1;
    //run dfs starting from node 0
    dfs(adj, vis, 0);
    //if we visited all n nodes, the graph is connected
    //combined with n-1 edges check, its a valid tree
    return cnt == n;
    
}
void dfs(ArrayList<ArrayList<Integer>> adj , boolean vis[], int st){
    //mark current node as visited
    vis[st] = true;
    // loop through all neighbors of current node
    for(int neig : adj.get(st)){
        //only visit unvisited nodes
        if(!vis[neig]){
            //foudn a new node, increment the count
            cnt++;
            //go deeper into this neighbor
            dfs(adj, vis, neig);

        }
    }
}
}