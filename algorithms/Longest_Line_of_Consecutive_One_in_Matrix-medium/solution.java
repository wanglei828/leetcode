/*
Given an m x n binary matrix mat, return the length of the longest line of consecutive one in the matrix.

The line could be horizontal, vertical, diagonal, or anti-diagonal.

 

Example 1:


Input: mat = [[0,1,1,0],[0,1,1,0],[0,0,0,1]]
Output: 3
Example 2:


Input: mat = [[1,1,1,1],[0,1,1,0],[0,0,0,1]]
Output: 4
 

Constraints:

m == mat.length
n == mat[i].length
1 <= m, n <= 104
1 <= m * n <= 104
mat[i][j] is either 0 or 1.
*/

class Solution {
    public int longestLine(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    continue;
                }
                // horizontal
                int x = i, y = j-1;
                int cnt = 1;
                while (y >= 0) {
                    if (mat[x][y] == 1) {
                        cnt++;
                        y--;
                    } else {
                        break;
                    }
                }
                y = j + 1;
                  while (y < n) {
                    if (mat[x][y] == 1) {
                        cnt++;
                        y++;
                    } else {
                        break;
                    }
                }
                res = Math.max(res, cnt);
                // vertical
                cnt = 1;
                x = i - 1; 
                y = j;
                while (x >= 0) {
                    if (mat[x][y] == 1) {
                        cnt++;
                        x--;
                    } else {
                        break;
                    }
                }
                x = i + 1;
                while (x < m) {
                    if (mat[x][y] == 1) {
                        cnt++;
                        x++;
                    } else {
                        break;
                    }
                }
                res = Math.max(res, cnt);
                // diagnal
                cnt = 1;
                x = i-1; 
                y = j-1;
                while(x >= 0 && y >= 0) {
                    if (mat[x][y] == 1) {
                        cnt++;
                        x--;
                        y--;
                    } else {
                        break;
                    }
                }
                x = i+1;
                y = j+1;
                while (x < m && y < n) {
                    if (mat[x][y] == 1) {
                        cnt++;
                        x++;
                        y++;
                    } else {
                        break;
                    }
                }
                res = Math.max(res, cnt);
                // anti
                cnt = 1;
                x = i+1; 
                y = j-1;
                while(x < m && y >= 0) {
                    if (mat[x][y] == 1) {
                        cnt++;
                        x++;
                        y--;
                    } else {
                        break;
                    }
                }
                x = i-1;
                y = j+1;
                while (x >= 0 && y < n) {
                    if (mat[x][y] == 1) {
                        cnt++;
                        x--;
                        y++;
                    } else {
                        break;
                    }
                }
                res = Math.max(res, cnt);
            }
        }
        return res;
    }
}
