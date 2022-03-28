/*

On a 2D plane, we place stones at some integer coordinate points.  
Each coordinate point may have at most one stone.

Now, a move consists of removing a stone that shares a column or row with another stone on the grid.

What is the largest possible number of moves we can make?

 

Example 1:

Input: stones = [[0,0],[0,1],[1,0],[1,2],[2,1],[2,2]]
Output: 5
Example 2:

Input: stones = [[0,0],[0,2],[1,1],[2,0],[2,2]]
Output: 3
Example 3:

Input: stones = [[0,0]]
Output: 0

*/

class Solution {
    public int removeStones(int[][] stones) {
        int n = stones.length;
        int[] roots = new int[n];
        for(int i=0; i<n; i++) {
            roots[i] = i;
        }
        int cnt = 0;
        for(int i=0; i<n; i++) { 
            for(int j=i+1; j<n; j++) {
                if(stones[i][0] == stones[j][0] || stones[i][1] == stones[j][1]) {
                    int u = find(roots, i);
                    int v = find(roots, j);
                    if(u != v) {
                        roots[v] = u;
                        cnt++;
                    }
                }
            }
        }
        return cnt;
    }
    
    private int find(int[] roots, int i) {
        while(roots[i] != i) {
            roots[i] = roots[roots[i]];
            i = roots[i];
        }
        return i;
    }
}
