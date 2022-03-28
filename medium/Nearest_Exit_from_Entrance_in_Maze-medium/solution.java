/*
You are given an m x n matrix maze (0-indexed) with empty cells (represented as '.') and walls (represented as '+'). 
You are also given the entrance of the maze, where entrance = [entrancerow, entrancecol] denotes the row and column of the cell you are initially standing at.

In one step, you can move one cell up, down, left, or right. You cannot step into a cell with a wall, and you cannot step outside the maze. 
Your goal is to find the nearest exit from the entrance. An exit is defined as an empty cell that is at the border of the maze. 
The entrance does not count as an exit.

Return the number of steps in the shortest path from the entrance to the nearest exit, or -1 if no such path exists.

*/

class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {
        int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
        int m = maze.length;
        int n = maze[0].length;
        Queue<int[]> q = new LinkedList<int[]>();
        int step = 0;
        maze[entrance[0]][entrance[1]] = '#';
        q.add(entrance);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] cur = q.poll();
                int x = cur[0], y = cur[1];
                if(cur != entrance && (x == 0 || x == m-1 ||
                  y == 0 || y == n-1)) {
                    return step;
                }
                for (int j = 0; j < 4; j++) {
                    int nx = x + dirs[j][0];
                    int ny = y + dirs[j][1];
                    if (nx < 0 || nx >= m || ny < 0 || ny >= n) continue;
                    if (maze[nx][ny] == '.') {
                        q.add(new int[]{nx, ny});
                        maze[nx][ny] = '#';
                    }
                }
            }
            step++;
        }
        return -1;
    }
}
