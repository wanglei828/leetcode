/*
Given a 2D array of characters grid of size m x n, you need to find if there exists any cycle consisting of the same value in grid.

A cycle is a path of length 4 or more in the grid that starts and ends at the same cell. 
From a given cell, you can move to one of the cells adjacent to it - in one of the four directions (up, down, left, or right), 
if it has the same value of the current cell.

Also, you cannot move to the cell that you visited in your last move. 
For example, the cycle (1, 1) -> (1, 2) -> (1, 1) is invalid because from (1, 2) we visited (1, 1) which was the last visited cell.

Return true if any cycle of the same value exists in grid, otherwise, return false.
*/

class Solution {
    Set<Integer> visited;
    HashMap<Integer, Integer> map;
    int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
    public boolean containsCycle(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        visited = new HashSet<>();
        map = new HashMap<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (visited.contains(i*n + j)) continue;
                if (helper(grid[i][j], i, j, 0, grid)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    private boolean helper(char a, int x, int y, int step, char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;               
        if (visited.contains(x*n + y)) {
            if (step - map.get(x*n + y) >=4) {
                return true;
            } else {
                return false;
            }
        }
        visited.add(x*n + y);
        map.put(x*n + y, step);
        for (int k = 0; k < 4; k++) {
            int[] dir = dirs[k];
            int nx = x + dir[0];
            int ny = y + dir[1];
            if (nx < 0 || nx >=m || ny < 0 || ny>=n) continue;
            if (grid[nx][ny] != a) continue;
            if (helper(a, nx, ny, step+1, grid)) {
                return true;
            }
        }
        return false;
    }
}
