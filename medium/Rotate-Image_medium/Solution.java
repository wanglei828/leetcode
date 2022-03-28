/*
You are given an n x n 2D matrix representing an image.

Rotate the image by 90 degrees (clockwise).

Follow up:
Could you do this in-place?
*/

public class Solution {
    public void rotate(int[][] matrix) {
        if(matrix.length == 0) return;
        int n = matrix.length;
        int[][] res = new int[n][n];
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                res[i][j] = matrix[i][j];
            }
        }
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                matrix[i][j] = res[n-1-j][i];
            }
        }
    }
}
