/*
You are given an m x n integer array grid where grid[i][j] could be:

1 representing the starting square. There is exactly one starting square.
2 representing the ending square. There is exactly one ending square.
0 representing empty squares we can walk over.
-1 representing obstacles that we cannot walk over.
Return the number of 4-directional walks from the starting square to the ending square, 
that walk over every non-obstacle square exactly once.

Constraints:

m == grid.length
n == grid[i].length
1 <= m, n <= 20
1 <= m * n <= 20
-1 <= grid[i][j] <= 2
There is exactly one starting cell and one ending cell.
*/

class Solution {
    int m, n;
    int cnt;
    int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public int uniquePathsIII(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        int total = 0;
        int r = 0, c = 0;
        cnt = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] >= 0) {
                    total++;
                }
                if (grid[i][j] == 1) {
                    r = i;
                    c = j;
                }
            }
        }
        dfs(r, c, total, grid);
        return cnt;
    }
    
    private void dfs(int x, int y, int total, int[][] grid) {
        if (grid[x][y] == 2 && total == 1) {
            cnt++;
            return;
        }
        int tmp = grid[x][y];
        grid[x][y] = -2;
        total--;
        for (int k = 0; k < 4; k++) {
            int[] dir = dirs[k];
            int nx = x + dir[0];
            int ny = y + dir[1];
            if (nx < 0 || nx >= m || ny < 0 || ny >= n || grid[nx][ny] < 0) continue;
            dfs(nx, ny, total, grid);
        }
        grid[x][y] = tmp;
    }
}
