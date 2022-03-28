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
    boolean[][] visit;
    List<Set<int[]>> islands;
    int[][] dirs = {{-1,0}, {1,0}, {0,-1}, {0,1}};
    public int largestIsland(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        visit = new boolean[m][n];
        islands = new ArrayList<>();
        int res = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0 || visit[i][j]) {
                    continue;
                }
                Set<int[]> set = new HashSet<>();
                dfs(grid, i, j, set);
                islands.add(set);
                res = Math.max(res, set.size());
            }
        }
        if (islands.size() == 1 && res < m*n) {
            return res + 1;
        }
        List<Set<Pair<Integer, Integer>>> move = new ArrayList<>();
        for (int i = 0; i < islands.size(); i++) {
            Set<int[]> si = islands.get(i);
            Set<Pair<Integer, Integer>> pi = new HashSet<>();
            getMove(si, pi, grid);
            move.add(pi);
        }
        Set<Pair<Integer, Integer>> visit = new HashSet<>();
        for (int i = 0; i < move.size(); i++) {
            for (Pair<Integer, Integer> p : move.get(i)) {
                if (visit.contains(p)) continue;
                visit.add(p);
                int area = islands.get(i).size();
                for (int j = i+1; j < move.size(); j++) {
                    if (move.get(j).contains(p)) {
                        area += islands.get(j).size();
                    }
                }
                res = Math.max(res, area + 1);
            }
            
        }
        return res;
    }
    
    private void dfs(int[][] grid, int x, int y, Set<int[]> set) {
        visit[x][y] = true;
        set.add(new int[]{x,y});
        for (int k = 0; k < 4; k++) {
            int[] dir = dirs[k];
            int nx = x + dir[0];
            int ny = y + dir[1];
            if (nx < 0 || nx >= m || ny < 0 || ny >= n) continue;
            if (visit[nx][ny]) continue;
            if (grid[nx][ny] == 0) continue;
            dfs(grid, nx, ny, set);
        }
    }
    
    private void getMove(Set<int[]> si, Set<Pair<Integer, Integer>> pi, int[][] grid) {
        for (int[] p: si) {
            for (int k = 0; k < 4; k++) {
                int nx = p[0] + dirs[k][0];
                int ny = p[1] + dirs[k][1];
                if (nx < 0 || nx >= m || ny < 0 || ny >= n || grid[nx][ny] == 1) continue;
                pi.add(new Pair<Integer, Integer>(nx, ny));
            }
        }
    }
}
