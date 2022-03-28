/*
Given an integer matrix, find the length of the longest increasing path.

From each cell, you can either move to four directions: left, right, up or down. 
You may NOT move diagonally or move outside of the boundary (i.e. wrap-around is not allowed).

Example 1:

nums = [
  [9,9,4],
  [6,6,8],
  [2,1,1]
]
Return 4
The longest increasing path is [1, 2, 6, 9].

Example 2:

nums = [
  [3,4,5],
  [3,2,6],
  [2,2,1]
]
Return 4
The longest increasing path is [3, 4, 5, 6]. Moving diagonally is not allowed.

Credits:
*/

public class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        int[][] dp = new int[matrix.length][matrix[0].length];
        int max = 1;
        for(int i=0; i<matrix.length; i++) {
            for(int j=0; j<matrix[0].length; j++) {
                if(dp[i][j] == 0) {
                    dp[i][j] = helper(matrix, i, j, dp);
                }
                max = Math.max(max, dp[i][j]);
            }
        }
        return max;
    }
    
    private int helper(int[][] matrix, int i, int j, int[][] dp) {
        if(dp[i][j] != 0) return dp[i][j];
        int max = 1;
        int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        for(int k=0; k<4; k++) {
            int x = i + dir[k][0];
            int y = j + dir[k][1];
            if(x>=0 && x<matrix.length && y>=0 && y<matrix[0].length && matrix[x][y] > matrix[i][j]) {
                dp[x][y] = helper(matrix, x, y, dp);
                max = Math.max(max, dp[x][y] + 1);
            }
        }
        return max;
    }
}
