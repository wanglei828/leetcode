/*
You are given an n x n binary matrix grid. You are allowed to change at most one 0 to be 1.

Return the size of the largest island in grid after applying this operation.

An island is a 4-directionally connected group of 1s.

 

Example 1:

Input: grid = [[1,0],[0,1]]
Output: 3
Explanation: Change one 0 to 1 and connect two 1s, then we get an island with area = 3.
Example 2:

Input: grid = [[1,1],[1,0]]
Output: 4
Explanation: Change the 0 to 1 and make the island bigger, only one island with area = 4.
Example 3:

Input: grid = [[1,1],[1,1]]
Output: 4
Explanation: Can't change any 0 to 1, only one island with area = 4.
 

Constraints:

n == grid.length
n == grid[i].length
1 <= n <= 500
grid[i][j] is either 0 or 1.
*/

class Solution {
    int m, n;
    int[][] dirs = {{-1,0}, {1,0}, {0,-1}, {0,1}};
    Map<Integer, Integer> area;
    public int largestIsland(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        area = new HashMap<>();
        int id = 2;
        int res = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] != 1) {
                    continue;
                }
                int[] cnt = new int[1];
                dfs(grid, i, j, id, cnt);
                res = Math.max(res, cnt[0]);
                area.put(id, cnt[0]);
                id++;
            }
        }
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    int cur = count(grid, i, j);
                    res = Math.max(res, cur);
                }
            }
        }
        return res;
    }
    
    private void dfs(int[][] grid, int x, int y, int id, int[] cnt) {
        cnt[0]++;
        grid[x][y] = id;
        for (int k = 0; k < 4; k++) {
            int[] dir = dirs[k];
            int nx = x + dir[0];
            int ny = y + dir[1];
            if (nx < 0 || nx >= m || ny < 0 || ny >= n) continue;
            if (grid[nx][ny] != 1) continue;
            dfs(grid, nx, ny, id, cnt);
        }
    }
    
    private int count(int[][] grid, int x, int y) {
        Set<Integer> set = new HashSet<>();
        for (int k = 0; k < 4; k++) {
            int[] dir = dirs[k];
            int nx = x + dir[0];
            int ny = y + dir[1];
            if (nx < 0 || nx >= m || ny < 0 || ny >= n) continue;
            if (grid[nx][ny] > 1) {
                set.add(grid[nx][ny]);
            }
        }
        int res = 1;
        for (int id : set) {
            res += area.get(id);
        }
        return res;
    }
}
