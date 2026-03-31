class Solution {
    public int countComponents(int n, int[][] edges) {
        // Build adjacency list
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++)
            graph.add(new ArrayList<>());

        // Undirected graph: add edge both ways
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        boolean[] visited = new boolean[n];
        int count = 0;

        // Try starting a BFS/DFS from every node
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                bfs(graph, i, visited); // explore entire component
                count++;                // that was one connected component
            }
        }

        return count;
    }

    private void bfs(List<List<Integer>> graph, int start, boolean[] visited) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int curr = queue.poll();
            // Visit all neighbors of current node
            for (int neighbor : graph.get(curr)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.offer(neighbor);
                }
            }
        }
    }
}
// Time:  O(V + E) — visit every node and edge once
// Space: O(V + E) — adjacency list + visited array + queue