/*

You are given a map in form of a two-dimensional integer grid where 1 represents land and 0 represents water.

Grid cells are connected horizontally/vertically (not diagonally). The grid is completely surrounded by water, and there is exactly one island (i.e., one or more connected land cells).

The island doesn't have "lakes" (water inside that isn't connected to the water around the island). One cell is a square with side length 1. The grid is rectangular, width and height don't exceed 100. Determine the perimeter of the island.

 

Example:

Input:
[[0,1,0,0],
 [1,1,1,0],
 [0,1,0,0],
 [1,1,0,0]]

Output: 16

*/

class Solution {
    public int islandPerimeter(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int res = 0;
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(grid[i][j] == 1) {
                    int neighbor = 0;
                    if(hasNeighbor(i, j+1, m, n, grid)) {
                        neighbor++;
                    }
                    if(hasNeighbor(i, j-1, m, n, grid)) {
                        neighbor++;
                    }
                    if(hasNeighbor(i-1, j, m, n, grid)) {
                        neighbor++;
                    }
                    if(hasNeighbor(i+1, j, m, n, grid)) {
                        neighbor++;
                    }
                    res += 4-neighbor;
                }
            }
        }
        return res;
    }
    
    private boolean hasNeighbor(int i, int j, int m, int n, int[][] grid) {
        if(i<0 || i>=m || j<0 || j>=n) return false;
        return grid[i][j] == 1;
    }
    
}
