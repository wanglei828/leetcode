class Solution {
    public int countSquares(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 1) {
                    int min = Math.min(matrix[i-1][j-1], matrix[i-1][j]);
                    min = Math.min(matrix[i][j-1], min);
                    matrix[i][j] = min + 1;
                }
            }
        }
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {        
                res += matrix[i][j];
            }
        }
        return res;
    }
}
