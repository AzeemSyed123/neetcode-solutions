class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        List<List<Integer>> ans = new ArrayList<>();
        if (matrix.length < 1){
            return ans;
        }
        
        int [][] pacific  = new int [matrix.length][matrix[0].length];
        int [][] atlantic = new int [matrix.length][matrix[0].length];
      // looping over row 0 and last row , which includes all columns
        for(int col = 0 ; col < matrix[0].length ; col++){
            fnc(matrix, 0 , col, Integer.MIN_VALUE, pacific);
            fnc(matrix, matrix.length - 1, col, Integer.MIN_VALUE,atlantic);
        }
        // now looping overfirst column and last column that will include all rows
        for(int r = 0 ; r<matrix.length ; r ++){
            fnc(matrix,r,0,Integer.MIN_VALUE, pacific);
            fnc(matrix, r, matrix[0].length-1 , Integer.MIN_VALUE, atlantic);
        }

        for (int i = 0 ; i < matrix.length ; i++){
            for(int j = 0 ; j < matrix[0].length ; j++){
                if(pacific[i][j] == 1 && atlantic[i][j] == 1){
                    List<Integer> v = new ArrayList<>();
                    v.add(i);
                    v.add(j);
                    ans.add(v);
                }
            }
        }
        return ans;
    }
    public void fnc(int[][]matrix, int i, int j, int prev, int[][] ocean){
        if(i<0 || j < 0 || i >= matrix.length || j >= matrix[0].length){
            return;
        }

        if(ocean[i][j] == 1){
            return ;
        }

        if(matrix[i][j] < prev){
            return;
        }
        ocean[i][j] = 1;
        fnc(matrix, i +1 , j , matrix[i][j], ocean);
        fnc(matrix, i , j+1 , matrix[i][j], ocean);
        fnc(matrix, i - 1 , j , matrix[i][j], ocean);
        fnc(matrix, i , j-1 , matrix[i][j], ocean);
    }
}