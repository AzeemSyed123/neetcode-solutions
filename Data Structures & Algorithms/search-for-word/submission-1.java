class Solution {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
    int n = board[0].length;

    for (int r = 0; r < m; r++) {
        for (int c = 0; c < n; c++) {
            if (word.charAt(0) == board[r][c]) {
                boolean found = dfs(board, word, r, c, 0);
                if (found) {
                    return true;
                }
            }
        }
    }
    return false;
}
    

    public boolean dfs(char[][] board, String word, int r, int c, int wordIndex) {

    // base case — all characters matched
    if (wordIndex == word.length()) {
        return true;
    }

    int rows = board.length;
    int cols = board[0].length;

    // out of bounds
    if (r < 0 || c < 0 || r >= rows || c >= cols) {
        return false;
    }

    // invalid cell or mismatch
    if (board[r][c] == '#' || board[r][c] != word.charAt(wordIndex)) {
        return false;
    }

    // store value for backtracking
    char ch = board[r][c];

    // mark visited
    board[r][c] = '#';

    // DFS in 4 directions
    if ( dfs(board, word, r-1, c, wordIndex+1) ||
         dfs(board, word, r, c+1, wordIndex+1) ||
         dfs(board, word, r+1, c, wordIndex+1) ||
         dfs(board, word, r, c-1, wordIndex+1) ) {

        return true;
    }

    // restore
    board[r][c] = ch;

    return false;



    }
}
