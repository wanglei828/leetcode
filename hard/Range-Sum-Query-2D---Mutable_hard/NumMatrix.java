/*
Given a 2D matrix matrix, find the sum of the elements inside the rectangle defined by its upper left corner (row1, col1) 
and lower right corner (row2, col2).

Range Sum Query 2D
The above rectangle (with the red border) is defined by (row1, col1) = (2, 1) 
and (row2, col2) = (4, 3), which contains sum = 8.

Example:
Given matrix = [
  [3, 0, 1, 4, 2],
  [5, 6, 3, 2, 1],
  [1, 2, 0, 1, 5],
  [4, 1, 0, 1, 7],
  [1, 0, 3, 0, 5]
]

sumRegion(2, 1, 4, 3) -> 8
update(3, 2, 2)
sumRegion(2, 1, 4, 3) -> 10
Note:
The matrix is only modifiable by the update function.
You may assume the number of calls to update and sumRegion function is distributed evenly.
You may assume that row1 ≤ row2 and col1 ≤ col2.
*/

public class NumMatrix {

    int m, n;
    int[][] nums;
    int[][] bit;
    public NumMatrix(int[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return;
        m = matrix.length;
        n = matrix[0].length;
        nums = new int[m][n];
        bit = new int[m+1][n+1];
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                update(i, j, matrix[i][j]);
            }
        }
    }

    public void update(int row, int col, int val) {
        int diff = val - nums[row][col];
        nums[row][col] = val;
        for(int i=row+1; i<=m; i+=(-i&i)) {
            for(int j=col+1; j<=n; j+=(-j&j)) {
                bit[i][j] += diff;
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return getSum(row2, col2) - getSum(row1-1, col2) - getSum(row2, col1-1) + getSum(row1-1, col1-1); 
    }
    
    private int getSum(int row, int col) {
        int sum = 0;
        for(int i=row+1; i>0; i-=(-i&i)) {
            for(int j=col+1; j>0; j -=(-j&j)) {
                sum += bit[i][j];
            }
        }
        return sum;
    }
}


// Your NumMatrix object will be instantiated and called as such:
// NumMatrix numMatrix = new NumMatrix(matrix);
// numMatrix.sumRegion(0, 1, 2, 3);
// numMatrix.update(1, 1, 10);
// numMatrix.sumRegion(1, 2, 3, 4);
