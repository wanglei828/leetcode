/*
Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

Integers in each row are sorted from left to right.
The first integer of each row is greater than the last integer of the previous row.
For example,

Consider the following matrix:

[
  [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
]
Given target = 3, return true.
*/

public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length == 0) return false;
        if(matrix[0].length == 0) return false;
        int r = matrix.length;
        int c = matrix[0].length;
        int h = 0;
        int t = r-1;
        while(h<=t) {
            int mid = h + (t-h)/2;
            if(target < matrix[mid][0]) {
                t = mid-1;
            } else if (target > matrix[mid][0]) {
                h = mid+1;
            } else {
                return true;
            }
        }
        r = (t<0)? 0 : t;
        h = 0;
        t = c-1;
        while(h<=t) {
            int mid = h + (t-h)/2;
            if(target < matrix[r][mid]) {
                t = mid-1;
            } else if (target > matrix[r][mid]) {
                h = mid+1;
            } else {
                return true;
            }
        }        
        return false;
    }
}
