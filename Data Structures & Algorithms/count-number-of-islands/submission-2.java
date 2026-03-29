class Solution {
    public int numIslands(char[][] grid) {

        // Edge case: if grid is null or empty, there are no islands
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int count = 0; // Tracks the number of islands found

        // Loop through every cell in the grid
        for (int i = 0; i < grid.length; i++)
            for (int j = 0; j < grid[0].length; j++)

                // When we find a '1', we've discovered a new island
                if (grid[i][j] == '1') {
                    // Use DFS to "sink" the entire island by turning
                    // all connected '1's into '0's, so we don't
                    // count the same island again
                    dfs(grid, i, j);
                    count++; // One full island has been processed
                }

        return count;
    }

    private void dfs(char[][] grid, int i, int j) {

        // Base case: stop if we go out of bounds or hit water ('0')
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == '0') {
            return;
        }

        // Mark the current cell as visited by sinking it (turning '1' into '0')
        grid[i][j] = '0';

        // Recursively explore all 4 directions (down, up, right, left)
        dfs(grid, i + 1, j); // down
        dfs(grid, i - 1, j); // up
        dfs(grid, i, j + 1); // right
        dfs(grid, i, j - 1); // left
    }
}