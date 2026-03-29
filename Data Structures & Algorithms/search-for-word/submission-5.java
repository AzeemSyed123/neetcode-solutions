class Solution {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;

        for (int r= 0 ; r<m ; r++){
            for(int c=0; c<n ; c++){
                if(word.charAt(0) == board[r][c]){
                    boolean found = dfs(board , word, r, c, 0);
                        if(found){
                            return true;
                        }
                }
            }
        }
        return false;
    }

    public boolean dfs(char[][]board, String word,int r , int c, int wordIndex){

      int rows = board.length;
      int columns = board[0].length;

      //base case
      if (wordIndex == word.length()){
        return true;
      }

      //out of bounds 
      if(r<0 || c<0 || r >= rows || c >= columns){
        return false;
      }  


      //invalid cell
      if (board[r][c] == '/' || board[r][c] != word.charAt(wordIndex)){
        return false;
      }
      // store value for back tracking 
      char ch = board[r][c];

      //mark as visited 
      board[r][c] = '/';

      if (dfs(board, word, r - 1, c ,wordIndex+1) || dfs(board,word, r, c-1 , wordIndex+1) || dfs(board, word, r + 1, c , wordIndex+1) || dfs(board, word, r, c+1 , wordIndex+1)){
        return true;
      }
      board[r][c] = ch;
      return false;
    }

       

}

