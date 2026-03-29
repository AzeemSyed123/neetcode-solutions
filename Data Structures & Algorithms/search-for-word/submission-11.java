class Solution {
    public boolean exist(char[][] board, String word) {

        int rows = board.length;
        int cols = board[0].length;

        for (int r = 0 ; r< rows ; r++){
            for(int c = 0 ; c< cols ; c++){
                if (word.charAt(0) == board[r][c]){
                    boolean found = dfs(board, word, r, c, 0);
                    if(found){
                        return true;
                    }
                }
            }
            
        }
        return false;
    }

        public boolean dfs(char[][]board, String word, int r, int c, int wordIndex){
            int rows = board.length;
            int cols = board[0].length;

            //base case
            if (wordIndex == word.length()) {
    return true;  // matched every character!
}

        // out of bounds
            if(r< 0 ||r>=rows || c < 0|| c >= cols){
                return false;
            }
            
            //invalid case
            if(board[r][c] == '/' || board[r][c] != word.charAt(wordIndex)){
                return false;
            }

            char ch = board[r][c];

            board[r][c] = '/';

            //valid case
            if(dfs(board, word, r - 1, c, wordIndex +1) || dfs(board, word, r, c - 1, wordIndex +1) || dfs(board, word, r + 1, c, wordIndex +1) || dfs(board, word, r , c + 1, wordIndex +1)){

            return true ;

            } 
            board[r][c] = ch;
            return false ;

        }

    }

        

    



