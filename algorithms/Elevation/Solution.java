/*

You’re given an elevation map for a rectangular area of land. 
The map is represented by 2-D array of numbers 
where each cell contains the elevation above sea level of the corresponding area of the map.  

You need a path that connects the west edge of the map with the east edge of the map. 
Starting at the west edge of the map you can only move in single cell steps east, southeast, or northeast.
You need to find how much can the sea level rise before submerging all such paths.
Find the path that has the highest low point in terms of elevation.
Write a function that takes in a 2-D array and returns a single number.
*/

public class Solution {
  public int path(int[][] matrix) {
    if(matrix == null || marix.length == 0 || matrix[0].length == 0) return 0;
    int m = matrix.length;
    int n = matrix[0].length;
    int[][] dp = new int[m][n];
    for(int i=0; i<m; i++) {
      dp[i][0] = matrix[i][0];
    }
    for(int i=1; i<n; i++) {
      for(int j=0;, j<m; j++) {
          int max = 0;
          if(j>0) {
            max = Math.max(max, dp[j-1][i-1]);
          }
          max = Math.max(max, dp[j][i-1]);
          if(j<m-1) {
            max = Math.max(max, dp[j+1][i-1]);
          }
          dp[j][i] = Math.min(matrix[j][i], max);
      }
    }
    int max = 0;
    for(int i=0; i<m; i++) {
      max = Math.max(max, dp[i][n-1]);
    }
    return max;
  }
}
