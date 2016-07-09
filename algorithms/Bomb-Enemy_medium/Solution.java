/*
Given a 2D grid, each cell is either a wall 'W', an enemy 'E' or empty '0' (the number zero), 
return the maximum enemies you can kill using one bomb.
The bomb kills all the enemies in the same row and column from the planted point 
until it hits the wall since the wall is too strong to be destroyed.
Note that you can only put the bomb at an empty cell.

Example:
For the given grid

0 E 0 0
E 0 W E
0 E 0 0

return 3. (Placing a bomb at (1,1) kills 3 enemies)
*/

public class Solution {
    public int maxKilledEnemies(char[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        int max = 0;
        int m = grid.length;
        int n = grid[0].length;
        int[] col = new int[n];
        int row = 0;
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(grid[i][j] == 'W') continue;
                if(j == 0 || grid[i][j-1] == 'W') {
                    row = calRow(grid, i, j);
                }
                if(i == 0 || grid[i-1][j] == 'W') {
                    col[j] = calCol(grid, i, j);
                }
                if(grid[i][j] == '0') {
                    max = Math.max(max, col[j] + row);
                }
            }
        }
        return max;
    }
    
    private int calRow(char[][] grid, int i, int j) {
        int num = 0;
        while(j<grid[0].length && grid[i][j] != 'W') {
            if(grid[i][j] == 'E') num++;
            j++;
        }
        return num;
    }
    
    private int calCol(char[][] grid, int i, int j) {
        int num = 0;
        while(i<grid.length && grid[i][j] != 'W') {
            if(grid[i][j] == 'E') num++;
            i++;
        }
        return num;
    }
}
