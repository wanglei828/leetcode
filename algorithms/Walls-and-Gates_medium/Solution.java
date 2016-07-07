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
        helper(rooms, 0, dir);
    }
    
    private void helper(int[][] rooms, int tag, int[][] dir) {
        int m = rooms.length;
        int n = rooms[0].length;
        int flag = 0;
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(rooms[i][j] == tag) {
                    for(int k=0; k<4; k++) {
                        int x = i + dir[k][0];
                        int y = j + dir[k][1];
                        if(x>=0 && x <m && y>=0 && y<n && rooms[x][y] > tag+1) {
                            rooms[x][y] = tag + 1;
                            flag = 1;
                        }
                    }

                }
            }
        }
        if(flag == 0) return;
        helper(rooms, tag+1, dir);
    }
}
