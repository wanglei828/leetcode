/*

There is a ball in a maze with empty spaces and walls. 
The ball can go through empty spaces by rolling up, down, left or right, 
but it won't stop rolling until hitting a wall. When the ball stops, it could choose the next direction.

Given the ball's start position, the destination and the maze, 
find the shortest distance for the ball to stop at the destination. 
The distance is defined by the number of empty spaces traveled by the ball from the start position (excluded) to the destination (included). 
If the ball cannot stop at the destination, return -1.

The maze is represented by a binary 2D array. 
1 means the wall and 0 means the empty space. 
You may assume that the borders of the maze are all walls. 
The start and destination coordinates are represented by row and column indexes.

 

Example 1:

Input 1: a maze represented by a 2D array

0 0 1 0 0
0 0 0 0 0
0 0 0 1 0
1 1 0 1 1
0 0 0 0 0

Input 2: start coordinate (rowStart, colStart) = (0, 4)
Input 3: destination coordinate (rowDest, colDest) = (4, 4)

Output: 12

Explanation: One shortest way is : left -> down -> left -> down -> right -> down -> right.
             The total distance is 1 + 1 + 3 + 1 + 2 + 2 + 2 = 12.
             
Example 2:

Input 1: a maze represented by a 2D array

0 0 1 0 0
0 0 0 0 0
0 0 0 1 0
1 1 0 1 1
0 0 0 0 0

Input 2: start coordinate (rowStart, colStart) = (0, 4)
Input 3: destination coordinate (rowDest, colDest) = (3, 2)

Output: -1

Explanation: There is no way for the ball to stop at the destination.

Note:

There is only one ball and one destination in the maze.
Both the ball and the destination exist on an empty space, 
and they will not be at the same position initially.
The given maze does not contain border (like the red rectangle in the example pictures), 
but you could assume the border of the maze are all walls.
The maze contains at least 2 empty spaces, and both the width and height of the maze won't exceed 100.

*/

class Solution {
    int cnt = Integer.MAX_VALUE;
    int[][] dp;
    int[][] dirs = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        dp = new int[maze.length][maze[0].length];
        for(int i=0; i<maze.length; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        dp[start[0]][start[1]] = 0;
        dfs(maze, start);
        if(dp[destination[0]][destination[1]] == Integer.MAX_VALUE) {
            return -1;
        } else {
            return dp[destination[0]][destination[1]];
        }
    }
    
    private void dfs(int[][] maze, int[] start) {
        for(int i=0; i<4; i++) {
            int[] dir = dirs[i];
            int cnt = 0;
            int r = start[0];
            int c = start[1];
            while(r>=0 && r<maze.length && c>=0 && c<maze[0].length && maze[r][c] == 0) {
                r += dir[0];
                c += dir[1];
                cnt++;
            }
            if(dp[start[0]][start[1]] + cnt-1 < dp[r-dir[0]][c-dir[1]]) {
                dp[r-dir[0]][c-dir[1]] = dp[start[0]][start[1]] + cnt - 1;
                dfs(maze, new int[]{r-dir[0], c-dir[1]});
            }
        }
    }
}
