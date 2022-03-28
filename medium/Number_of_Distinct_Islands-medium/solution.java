/*

Given a non-empty 2D array grid of 0's and 1's, an island is a group of 1's (representing land) 
connected 4-directionally (horizontal or vertical.) 
You may assume all four edges of the grid are surrounded by water.

Count the number of distinct islands. 
An island is considered to be the same as another 
if and only if one island can be translated (and not rotated or reflected) to equal the other.

Example 1:
11000
11000
00011
00011
Given the above grid map, return 1.
Example 2:
11011
10000
00001
11011
Given the above grid map, return 3.

Notice that:
11
1
and
 1
11
are considered different island shapes, because we do not consider reflection / rotation.
Note: The length of each dimension in the given grid does not exceed 50.

*/

class Solution {
    boolean[][] visit;
    StringBuilder shape;
    public int numDistinctIslands(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        visit = new boolean[m][n];
        Set<String> shapes = new HashSet<String>();
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                shape = new StringBuilder();
                explore(grid, i, j, 0);
                if(shape.length() !=0) {
                    shapes.add(shape.toString());
                }
            }
        }
        return shapes.size();
    }
    
    private void explore(int[][] grid, int i, int j, int v) {
        if(i<0 || i>= grid.length || j<0 || j>= grid[0].length || visit[i][j] || grid[i][j] == 0) return;
        shape.append(v);
        visit[i][j] = true;
        explore(grid, i+1, j, 1);
        explore(grid, i-1, j, 2);
        explore(grid, i, j+1, 3);
        explore(grid, i, j-1, 4);
        shape.append(0);
    }
}
