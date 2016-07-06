/*
Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

Integers in each row are sorted in ascending from left to right.
Integers in each column are sorted in ascending from top to bottom.
For example,

Consider the following matrix:

[
  [1,   4,  7, 11, 15],
  [2,   5,  8, 12, 19],
  [3,   6,  9, 16, 22],
  [10, 13, 14, 17, 24],
  [18, 21, 23, 26, 30]
]
Given target = 5, return true.

Given target = 20, return false.
*/

public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;
        int m = matrix.length;
        int n = matrix[0].length;
        return helper(matrix, 0, m-1, 0, n-1, target);
    }
    
    private boolean helper(int[][] matrix, int rows, int rowe, int cols, int cole, int target) {
        if(rowe < rows || cols > cole) return false;
        int rowm = rows + (rowe - rows)/2;
        int colm = cols + (cole - cols)/2;
        if(matrix[rowm][colm] == target) {
            return true;
        } else if(matrix[rowm][colm] > target) {
            return helper(matrix, rows, rowm, cols, colm-1, target) || helper(matrix, rows, rowm-1, colm, cole, target) || helper(matrix, rowm+1, rowe, cols, colm-1, target);
        } else {
            return helper(matrix, rows, rowm, colm+1, cole, target) || helper(matrix, rowm+1, rowe, cols, cole, target) || helper(matrix, rowm+1, rowe, colm+1, cols, target);
        }
    }
}
