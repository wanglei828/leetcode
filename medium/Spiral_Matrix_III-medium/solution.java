/*

On a 2 dimensional grid with R rows and C columns, we start at (r0, c0) facing east.

Here, the north-west corner of the grid is at the first row and column, 
and the south-east corner of the grid is at the last row and column.

Now, we walk in a clockwise spiral shape to visit every position in this grid. 

Whenever we would move outside the boundary of the grid, 
we continue our walk outside the grid (but may return to the grid boundary later.) 

Eventually, we reach all R * C spaces of the grid.

Return a list of coordinates representing the positions of the grid in the order they were visited.

 

Example 1:

Input: R = 1, C = 4, r0 = 0, c0 = 0
Output: [[0,0],[0,1],[0,2],[0,3]]

Example 2:

Input: R = 5, C = 6, r0 = 1, c0 = 4
Output: [[1,4],[1,5],[2,5],[2,4],[2,3],[1,3],[0,3],[0,4],[0,5],[3,5],[3,4],[3,3],[3,2],[2,2],[1,2],
[0,2],[4,5],[4,4],[4,3],[4,2],[4,1],[3,1],[2,1],[1,1],[0,1],[4,0],[3,0],[2,0],[1,0],[0,0]]

Note:

1 <= R <= 100
1 <= C <= 100
0 <= r0 < R
0 <= c0 < C

*/

class Solution {
    public int[][] spiralMatrixIII(int R, int C, int r0, int c0) {
        int n = R*C;
        int[][] ans = new int[n][2];
        int cnt = 0;
        ans[cnt][0] = r0;
        ans[cnt][1] = c0;
        cnt++;
        int round = 1;
        while(cnt < n) {
            int rMin = r0 - round;
            int rMax = r0 + round;
            int cMin = c0 - round;
            int cMax = c0 + round;
            
            if (cMax < C) {
                for(int i= rMin+1; i<= rMax; i++) {
                    if(i>=0 && i < R && cnt<n) {
                        ans[cnt][0] = i;
                        ans[cnt][1] = cMax;
                        cnt++;
                    }
                }
            }
            
            if(rMax < R) {
                for(int i= cMax-1; i>= cMin; i--) {
                    if(i < C && i>=0 && cnt<n) {
                        ans[cnt][0] = rMax;
                        ans[cnt][1] = i;
                        cnt++;
                    }
                }
            }
            
            if(cMin >= 0) {
                for(int i=rMax-1; i>=rMin; i--) {
                    if(i < R && i>=0 && cnt<n) {
                        ans[cnt][0] = i;
                        ans[cnt][1] = cMin;
                        cnt++;
                    }
                }
            }
            
            if(rMin >=0) {
                for(int i=cMin+1; i<=cMax; i++) {
                    if(i>=0 && i<C && cnt<n) {
                        ans[cnt][0] = rMin;
                        ans[cnt][1] = i;
                        cnt++;
                    }
                }
            }
            round++;
        }
        return ans;
    }
}
