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
                    dp[i][j] = helper(matrix, i, j, 1, dp);
                }
                max = Math.max(max, dp[i][j]);
            }
        }
        return max;
    }
    
    private int helper(int[][] matrix, int i, int j, int count, int[][] dp) {
        //if(i<0 || i>=matrix.length || j<0 || j>=matrix[0].length) return ;
        int max = count;
        if(i> 0 && matrix[i][j] < matrix[i-1][j]) {
            if(dp[i-1][j] == 0) {
                dp[i-1][j] = helper(matrix, i-1, j, 1 ,dp);
            }
            max = Math.max(count + dp[i-1][j], max);
        }
        if(i < matrix.length-1 && matrix[i][j] < matrix[i+1][j]) {
            if(dp[i+1][j] == 0) {
                dp[i+1][j] = helper(matrix, i+1, j, 1, dp);
            }
            max = Math.max(count + dp[i+1][j], max);
        }
        if(j < matrix[0].length-1 && matrix[i][j] < matrix[i][j+1]) {
            if(dp[i][j+1] == 0) {
                dp[i][j+1] = helper(matrix, i, j+1, 1, dp);
            }
            max = Math.max(count + dp[i][j+1], max);
        }
         if(j >0 && matrix[i][j] < matrix[i][j-1]) {
            if(dp[i][j-1] == 0) {
                dp[i][j-1] = helper(matrix, i, j-1, 1, dp);
            }
            max = Math.max(count + dp[i][j-1], max);
        }
        return max;
    }
}
