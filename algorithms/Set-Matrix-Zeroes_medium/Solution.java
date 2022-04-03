/*
Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in place.
*/

public class Solution {
    public void setZeroes(int[][] matrix) {
        if(matrix.length == 0) return;
        if(matrix[0].length == 0) return;
        int m = matrix.length;
        int n = matrix[0].length;
        Set<Integer> rows = new HashSet<>();
        Set<Integer> cols = new HashSet<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    rows.add(i);
                    cols.add(j);
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (rows.contains(i) || cols.contains(j)) {
                    matrix[i][j] = 0;
                }
            }
        }
}
