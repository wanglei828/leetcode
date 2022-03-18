/*
Given an m x n binary matrix mat, return the distance of the nearest 0 for each cell.

The distance between two adjacent cells is 1.

Input: mat = [[0,0,0],[0,1,0],[0,0,0]]
Output: [[0,0,0],[0,1,0],[0,0,0]]

Input: mat = [[0,0,0],[0,1,0],[1,1,1]]
Output: [[0,0,0],[0,1,0],[1,2,1]]

Constraints:

m == mat.length
n == mat[i].length
1 <= m, n <= 104
1 <= m * n <= 104
mat[i][j] is either 0 or 1.
There is at least one 0 in mat.
*/

class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        int m = mat.length;
        int n = mat[0].length;
        int[][] res = new int[m][n];
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    res[i][j] = 0;
                    q.add(new int[]{i, j});
                } else {
                    res[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            for (int k = 0; k < 4; k++) {
                int nx = x + dirs[k][0];
                int ny = y + dirs[k][1];
                if (nx >= 0 && nx < m && ny >=0 && ny < n) {
                    if (res[nx][ny] > res[x][y] + 1) {
                        res[nx][ny] = res[x][y] + 1;
                        q.add(new int[]{nx, ny});
                    }
                }
            }    
        }
        return res;
    }
}
