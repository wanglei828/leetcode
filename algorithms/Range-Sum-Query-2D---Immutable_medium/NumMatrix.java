/*
Given a 2D matrix matrix, find the sum of the elements inside the rectangle defined by its upper left corner (row1, col1) and lower right corner (row2, col2).

Range Sum Query 2D

Example:
Given matrix = [
  [3, 0, 1, 4, 2],
  [5, 6, 3, 2, 1],
  [1, 2, 0, 1, 5],
  [4, 1, 0, 1, 7],
  [1, 0, 3, 0, 5]
]

sumRegion(2, 1, 4, 3) -> 8
sumRegion(1, 1, 2, 2) -> 11
sumRegion(1, 2, 2, 4) -> 12
Note:
You may assume that the matrix does not change.
There are many calls to sumRegion function.
You may assume that row1 ≤ row2 and col1 ≤ col2.
*/

public class NumMatrix {
    private int[][] data;
    private int[][] sum;
    public NumMatrix(int[][] matrix) {
        if(matrix.length==0) return;
        if(matrix[0].length == 0)return;
        int rows = matrix.length;
        int cols = matrix[0].length;
        data = new int[rows][cols];
        sum = new int[rows][cols];
        for(int i = 0; i< rows; i++) {
            for(int j = 0; j < cols; j++) {
                data[i][j] = matrix[i][j];
                if(i == 0 ) {
                    if(j==0) {
                        sum[i][j] = matrix[i][j];
                    } else {
                        sum[i][j] = sum[i][j-1] + matrix[i][j];
                    }
                } else {
                    if(j==0) {
                        sum[i][j] = sum[i-1][j] + matrix[i][j];
                    } else {
                        sum[i][j] = sum[i-1][j] + sum[i][j-1] - sum[i-1][j-1] + matrix[i][j];
                    }
                }
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int c1=0, c2=0, c3=0;
        if(row1==0 || col1==0) {
            c1 = 0;
        } else {
            c1 = sum[row1-1][col1-1];
        }
        if(row1 == 0) {
            c2 = 0;
        } else {
            c2 = sum[row1-1][col2];
        }
        if(col1==0) {
            c3 = 0;
        } else {
            c3 = sum[row2][col1-1];
        }
        return sum[row2][col2]-c1 - (c2-c1) - (c3-c1);
        
    }
}


// Your NumMatrix object will be instantiated and called as such:
// NumMatrix numMatrix = new NumMatrix(matrix);
// numMatrix.sumRegion(0, 1, 2, 3);
// numMatrix.sumRegion(1, 2, 3, 4);
