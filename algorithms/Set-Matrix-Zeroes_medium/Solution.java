/*
Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in place.
*/

public class Solution {
    public void setZeroes(int[][] matrix) {
        if(matrix.length == 0) return;
        if(matrix[0].length == 0) return;
        int r = matrix.length;
        int c = matrix[0].length;
        int[] rows = new int[r];
        int[] cols = new int[c];
        Arrays.fill(rows, 0);
        Arrays.fill(cols, 0);
        for(int i = 0; i <r; i++) {
            for(int j=0; j<c; j++) {
                if(matrix[i][j] == 0) {
                    rows[i] = 1;
                    cols[j] = 1;
                }
            }
        }
        for(int i = 0; i<r; i++){
            if(rows[i] == 1) {
                Arrays.fill(matrix[i], 0);
            }
        }
        for(int i=0; i<c; i++) {
            if(cols[i] == 1) {
                for(int j=0; j<r; j++) {
                    matrix[j][i] = 0;
                }
            }
        }
    }
}
