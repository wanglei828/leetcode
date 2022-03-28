/*
You are given an n x n integer matrix grid where each value grid[i][j] represents the elevation at that point (i, j).

The rain starts to fall. At time t, the depth of the water everywhere is t. 
You can swim from a square to another 4-directionally adjacent square if and only if the elevation of both squares individually are at most t. 
You can swim infinite distances in zero time. Of course, you must stay within the boundaries of the grid during your swim.

Return the least time until you can reach the bottom right square (n - 1, n - 1) if you start at the top left square (0, 0).

Input: grid = [[0,2],[1,3]]
Output: 3
Explanation:
At time 0, you are in grid location (0, 0).
You cannot go anywhere else because 4-directionally adjacent neighbors have a higher elevation than t = 0.
You cannot reach point (1, 1) until time 3.
When the depth of water is 3, we can swim anywhere inside the grid.

Input: grid = [[0,1,2,3,4],[24,23,22,21,5],[12,13,14,15,16],[11,17,18,19,20],[10,9,8,7,6]]
Output: 16
Explanation: The final route is shown.
We need to wait until time 16 so that (0, 0) and (4, 4) are connected.
*/

class Solution {
    int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    int res = 0;
    PriorityQueue<int[]> q;
    int m, n;
    boolean[][] visit;
    public int swimInWater(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        q = new PriorityQueue<int[]>((a, b)->{return a[2] - b[2];});
        visit = new boolean[m][n];
        res = Math.max(res, grid[0][0]);
        dfs(grid, 0, 0);
        return res;
    }
    
    private boolean dfs(int[][] grid, int x, int y) {
        if (x == m-1 && y == n-1) {
            return true;
        }
        visit[x][y] = true;
        for (int k = 0; k < 4; k++) {
            int[] dir = dirs[k];
            int nx = x + dir[0];
            int ny = y + dir[1];
            if (nx < 0 || nx >= m || ny < 0 || ny >=n) continue;
            if (visit[nx][ny]) continue;
            q.add(new int[]{nx, ny, grid[nx][ny]});
        }
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            if (dfs(grid, cur[0], cur[1])) {
                res = Math.max(res, grid[cur[0]][cur[1]]);
                return true;
            }
        }
        return false;
    }
}
