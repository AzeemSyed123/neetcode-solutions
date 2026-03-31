class Solution {
    public int numIslands(char[][] grid) {
        // Edge case: empty grid
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int count = 0;

        // Scan every cell in the grid
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                // Found a piece of land — this is a new island
                if (grid[i][j] == '1') {
                    dfs(grid, i, j); // sink the entire island so we don't count it again
                    count++;
                }
            }
        }

        return count;
    }

    private void dfs(char[][] grid, int i, int j) {
        // Stop if: out of bounds OR already water
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == '0') {
            return;
        }

        grid[i][j] = '0'; // mark as visited by "sinking" this land (turn to water)

        // Explore all 4 directions: down, right, up, left
        dfs(grid, i + 1, j);
        dfs(grid, i, j + 1);
        dfs(grid, i - 1, j);
        dfs(grid, i, j - 1);
    }
}
// Time:  O(m × n) — visit every cell at most once
// Space: O(m × n) — worst case recursion depth if entire grid is land