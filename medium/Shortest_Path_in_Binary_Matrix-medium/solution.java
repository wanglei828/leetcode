/*

In an N by N square grid, each cell is either empty (0) or blocked (1).

A clear path from top-left to bottom-right has length k if 
and only if it is composed of cells C_1, C_2, ..., C_k such that:

Adjacent cells C_i and C_{i+1} are connected 8-directionally (ie., they are different and share an edge or corner)
C_1 is at location (0, 0) (ie. has value grid[0][0])
C_k is at location (N-1, N-1) (ie. has value grid[N-1][N-1])
If C_i is located at (r, c), then grid[r][c] is empty (ie. grid[r][c] == 0).
Return the length of the shortest such clear path from top-left to bottom-right.  If such a path does not exist, return -1.

Example 1:

Input: [[0,1],[1,0]]
Output: 2

Example 2:

Input: [[0,0,0],[1,1,0],[1,1,0]]
Output: 4

Note:

1 <= grid.length == grid[0].length <= 100
grid[r][c] is 0 or 1

*/

class Solution {
    int[][] dirs = new int[][]{{-1, -1}, {-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1},{0, -1}};
    public int shortestPathBinaryMatrix(int[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0) return -1;
        int n = grid.length;
        if(grid[0][0] != 0) return -1;
        if(n == 1) return 1;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0});
        int cnt = 1;
        grid[0][0] = 1;
        while(!q.isEmpty()) {
            int size = q.size();
            for(int j=0; j<size; j++) {
                int[] cur = q.poll();
                for(int i=0; i<8; i++) {
                    int x = cur[0] + dirs[i][0];
                    int y = cur[1] + dirs[i][1];
                    if(x<0 || x>=n || y<0 || y>=n || grid[x][y] != 0) continue;
                    if(x == n-1 && y == n-1) return cnt+1;
                    q.add(new int[]{x, y});
                    grid[x][y] = 1; // mark as visited.
                }
            }
            cnt++;
        }
        return -1;
    }
}
