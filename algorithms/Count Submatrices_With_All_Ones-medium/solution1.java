class Solution {
    public int numSubmat(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 1) {
                    mat[i][j] =  mat[i-1][j] + 1;
                } 
            }
        }
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) continue;
                int min = Integer.MAX_VALUE;
                for (int k = j; k < n; k++) {
                    if (mat[i][k] == 0) break;
                    min = Math.min(min, mat[i][k]);
                    res += min;
                }
            }
        }
        return res;
    }
}
