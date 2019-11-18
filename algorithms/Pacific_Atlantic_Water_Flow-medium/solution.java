/*

Given an m x n matrix of non-negative integers representing the height of each unit cell in a continent, 
the "Pacific ocean" touches the left and top edges of the matrix and the "Atlantic ocean" touches the right and bottom edges.

Water can only flow in four directions (up, down, left, or right) from a cell to another one with height equal or lower.

Find the list of grid coordinates where water can flow to both the Pacific and Atlantic ocean.

Note:

The order of returned grid coordinates does not matter.
Both m and n are less than 150.
 

Example:

Given the following 5x5 matrix:

  Pacific ~   ~   ~   ~   ~ 
       ~  1   2   2   3  (5) *
       ~  3   2   3  (4) (4) *
       ~  2   4  (5)  3   1  *
       ~ (6) (7)  1   4   5  *
       ~ (5)  1   1   2   4  *
          *   *   *   *   * Atlantic

Return:

[[0, 4], [1, 3], [1, 4], [2, 2], [3, 0], [3, 1], [4, 0]] (positions with parentheses in above matrix).

*/

class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        List<List<Integer>> res = new ArrayList<>();
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return res;
        int m = matrix.length, n = matrix[0].length;
        int[][] p = new int[m][n];
        int[][] a = new int[m][n];
        for(int i=0; i<n; i++) {
            dfs(matrix, p, 0, i, 0);
            dfs(matrix, a, m-1, i, 0);
        }
        for(int i=0; i<m; i++) {
            dfs(matrix, p, i, 0, 0);
            dfs(matrix, a, i, n-1, 0);
        }        
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(p[i][j] == 1 && a[i][j] == 1) {
                    List<Integer> list = new ArrayList<>();
                    list.add(i);
                    list.add(j);
                    res.add(list);
                }
            }
        }
        return res;
    }
    
    private void dfs(int[][] matrix, int[][] pa, int i, int j, int preH) {
        if(i<0 || i>=matrix.length || j<0 || j>=matrix[0].length || pa[i][j] == 1 || matrix[i][j] < preH) return;
        pa[i][j] = 1;
        dfs(matrix, pa, i+1, j, matrix[i][j]);
        dfs(matrix, pa, i-1, j, matrix[i][j]);
        dfs(matrix, pa, i, j-1, matrix[i][j]);
        dfs(matrix, pa, i, j+1, matrix[i][j]);
    }
}
