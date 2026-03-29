class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] matrix) {

        List<List<Integer>> ans = new ArrayList<>();
        if(matrix.length<1){
            return ans;
        }

        int[][] pacific = new int[matrix.length][matrix[0].length];
        int[][] atlantic = new int [matrix.length][matrix[0].length];

        //loop over first row and last row , involves all columns
        for(int col = 0 ; col<matrix[0].length ; col++){
            fnc(matrix, 0, col, Integer.MIN_VALUE, pacific);
            fnc(matrix, matrix.length-1, col, Integer.MIN_VALUE,atlantic);
        }

        //loop over the first and last column , invloves all rows
        for (int rows = 0 ; rows<matrix.length ; rows++){
            fnc(matrix, rows, 0, Integer.MIN_VALUE, pacific);
            fnc(matrix, rows, matrix[0].length-1, Integer.MIN_VALUE, atlantic);
        }

        // find all the common cells between the two matrices
        for(int i = 0 ; i < matrix.length ; i++){
            for(int j= 0; j<matrix[0].length ; j++ ){
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

    public void fnc (int [][]matrix, int row, int col, int prev, int [][]ocean){
        //out of bound
        if (row<0 || col < 0 || row>=matrix.length || col>=matrix[0].length){
            return;
        }
        //if previously visited
        if(ocean[row][col] == 1){
            return;
        }
        if(matrix[row][col] < prev){
            return;
        }
        ocean[row][col] = 1;
        fnc(matrix, row + 1, col, matrix[row][col],ocean);
        fnc(matrix, row, col + 1, matrix[row][col], ocean);
        fnc(matrix, row - 1, col , matrix[row][col], ocean);
        fnc(matrix, row , col-1 , matrix[row][col], ocean);
    }
}