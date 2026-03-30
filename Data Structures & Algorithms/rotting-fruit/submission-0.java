class Solution {
    public int orangesRotting(int[][] grid) {
        // Edge case: if the grid is null or empty, return -1 (invalid input)
    if (grid == null || grid.length == 0) return -1;

    // Store grid dimensions for easy access
    int rows = grid.length, cols = grid[0].length;

    // time[i][j] = the earliest minute at which cell (i, j) becomes rotten.
    // Initialized to MAX_VALUE meaning "not yet reached by any rotten orange."
    int[][] time = new int[rows][cols];
    for (int i = 0; i < rows; i++)
      Arrays.fill(time[i], Integer.MAX_VALUE);

    // First pass: find every initially rotten orange (value == 2)
    // and launch a DFS from it, starting at time 0.
    // Each DFS will flood outward, recording the shortest time
    // it takes for that rotten orange to reach every reachable cell.
    for (int i = 0; i < rows; i++)
      for (int j = 0; j < cols; j++)
        if (grid[i][j] == 2)
          dfs(grid, time, i, j, 0);

    // Second pass: check every fresh orange (value == 1).
    // - If time[i][j] is still MAX_VALUE, no rotten orange can reach it → return -1.
    // - Otherwise, track the maximum time across all fresh oranges.
    //   The max is our answer because we need ALL oranges to be rotten.
    int timeRequired = 0;
    for (int i = 0; i < rows; i++)
      for (int j = 0; j < cols; j++)
        if (grid[i][j] == 1) {
          if (time[i][j] == Integer.MAX_VALUE) return -1; // unreachable fresh orange
          timeRequired = Math.max(timeRequired, time[i][j]); // update global max
        }

    // The latest time any fresh orange becomes rotten = total minutes needed
    return timeRequired;
  }

  private void dfs(int[][] grid, int[][] time, int i, int j, int currentTime) {

    // --- Base case / pruning: stop the recursion if ---

    // 1. Out of bounds: cell is outside the grid
    // 2. Empty cell: grid[i][j] == 0, rot can't pass through empty cells
    // 3. No improvement: currentTime >= time[i][j] means we've already
    //    found an equal or faster way to reach this cell.
    //    This also prevents infinite loops — if we revisit a cell,
    //    currentTime will be >= the stored time, so we stop.
    if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length
        || grid[i][j] == 0 || currentTime >= time[i][j]) return;

    // Record this time as the best (shortest) known time for this cell.
    // We only get here if currentTime < time[i][j], so this is always
    // an improvement over the previously recorded time.
    time[i][j] = currentTime;

    // Recurse into all 4 neighbors with time incremented by 1 minute.
    // Up
    dfs(grid, time, i - 1, j, currentTime + 1);
    // Down
    dfs(grid, time, i + 1, j, currentTime + 1);
    // Left
    dfs(grid, time, i, j - 1, currentTime + 1);
    // Right
    dfs(grid, time, i, j + 1, currentTime + 1);
  }
}