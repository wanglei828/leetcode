/*
You are given an n x n binary matrix grid where 1 represents land and 0 represents water.

An island is a 4-directionally connected group of 1's not connected to any other 1's. There are exactly two islands in grid.

You may change 0's to 1's to connect the two islands to form one island.

Return the smallest number of 0's you must flip to connect the two islands.

 

Example 1:

Input: grid = [[0,1],[1,0]]
Output: 1
Example 2:

Input: grid = [[0,1,0],[0,0,0],[0,0,1]]
Output: 2
Example 3:

Input: grid = [[1,1,1,1,1],[1,0,0,0,1],[1,0,1,0,1],[1,0,0,0,1],[1,1,1,1,1]]
Output: 1
 

Constraints:

n == grid.length == grid[i].length
2 <= n <= 100
grid[i][j] is either 0 or 1.
There are exactly two islands in grid.
*/

class Solution {
    Queue<int[]> q;
    int[][] dirs = {{-1,0}, {1,0}, {0,-1}, {0,1}};
    boolean[][] visit;
    public int shortestBridge(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        visit = new boolean[m][n];
        q = new LinkedList<int[]>();
        for (int i = 0; i < m; i++) {
            boolean found = false;
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    dfs(grid, i, j);
                    found = true;
                    break;
                }
            }
            if (found) {
                break;
            }
        }
        int cnt = 0;
        while(!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] cur = q.poll();
                for (int k = 0; k < 4; k++) {
                    int[] dir = dirs[k];
                    int nx = cur[0] + dir[0];
                    int ny = cur[1] + dir[1];
                    if (nx < 0 || nx >= m || ny < 0 || ny >=n) continue;
                    if (grid[nx][ny] == 1) {
                        return cnt;
                    }
                    if (!visit[nx][ny]) {
                        visit[nx][ny] = true;
                        q.add(new int[]{nx, ny});
                    }
                }
            }
            cnt++;
        }
        return cnt;
    }
    
    private void dfs(int[][] grid, int x, int y) {
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length) return;
        if (visit[x][y] || grid[x][y] == 0) return;
        visit[x][y] = true;
        grid[x][y] = 2;
        q.add(new int[]{x, y});
        for (int k = 0; k < 4; k++) {
            int[] dir = dirs[k];
            int nx = x + dir[0];
            int ny = y + dir[1];
            dfs(grid, nx, ny);
        }
    }
}
