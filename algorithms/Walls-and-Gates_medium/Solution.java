/*
You are given a m x n 2D grid initialized with these three possible values.

-1 - A wall or an obstacle.
0 - A gate.
INF - Infinity means an empty room. 
We use the value 231 - 1 = 2147483647 to represent INF as you may assume that the distance to a gate is less than 2147483647.
Fill each empty room with the distance to its nearest gate. If it is impossible to reach a gate, it should be filled with INF.

For example, given the 2D grid:
INF  -1  0  INF
INF INF INF  -1
INF  -1 INF  -1
  0  -1 INF INF
After running your function, the 2D grid should be:
  3  -1   0   1
  2   2   1  -1
  1  -1   2  -1
  0  -1   3   4
*/

public class Solution {
    public void wallsAndGates(int[][] rooms) {
        if(rooms == null || rooms.length == 0 || rooms[0].length == 0) return;
        int[][] dir = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
        Queue<int[]> q = new LinkedList<int[]>();
        int m = rooms.length, n=rooms[0].length;
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(rooms[i][j] == 0) {
                    q.add(new int[]{i, j});
                }
            }
        }
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            for(int i=0; i<4; i++) {
                int x = cur[0] + dir[i][0];
                int y = cur[1] + dir[i][1];
                if(x>=0 && x<m && y>=0 && y<n && rooms[x][y] == Integer.MAX_VALUE) {
                    rooms[x][y] = rooms[cur[0]][cur[1]] + 1;
                    q.add(new int[]{x, y});
                }
            }
        }
    }
}
