/*
Given an m x n integer matrix grid, return the maximum score of a path starting at (0, 0) and 
ending at (m - 1, n - 1) moving in the 4 cardinal directions.

The score of a path is the minimum value in that path.

For example, the score of the path 8 → 4 → 5 → 9 is 4.

Input: grid = [[5,4,5],[1,2,6],[7,4,6]]
Output: 4

Input: grid = [[2,2,1,2,2,2],[1,2,2,2,1,2]]
Output: 2

Input: grid = [[3,4,6,3,4],[0,2,1,1,7],[8,8,3,2,7],[3,2,4,9,8],[4,1,2,0,0],[4,6,5,4,3]]
Output: 3
 

Constraints:

m == grid.length
n == grid[i].length
1 <= m, n <= 100
0 <= grid[i][j] <= 109
*/

class Solution {
    boolean[][] visit;
    int[][] dirs = {{-1,0}, {1,0}, {0,-1}, {0,1}};
    int m, n;
    public int maximumMinimumPath(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        visit = new boolean[m][n];
        int res = grid[0][0];
        PriorityQueue<int[]> q = new PriorityQueue<int[]>(new Comparator<int[]>(){
            public int compare(int[] o1, int[] o2) {
                return o2[2] - o1[2];
            }
        });
        q.add(new int[]{0, 0, grid[0][0]});
        visit[0][0] = true;
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            res = Math.min(res, cur[2]);
            if (cur[0] == m-1 && cur[1] == n-1) {
                break;
            }
            for (int k = 0; k < 4; k++) {
                int[] dir = dirs[k];
                int nx = cur[0] + dir[0];
                int ny = cur[1] + dir[1];
                if (nx < 0 || nx >= m || ny < 0 || ny >= n) continue;
                if (visit[nx][ny]) continue;
                visit[nx][ny] = true;
                q.add(new int[]{nx, ny, grid[nx][ny]});
            }            
        }
        return res;
    }
}
