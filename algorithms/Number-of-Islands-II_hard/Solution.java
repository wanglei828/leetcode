/*
A 2d grid map of m rows and n columns is initially filled with water. 
We may perform an addLand operation which turns the water at position (row, col) into a land. 
Given a list of positions to operate, count the number of islands after each addLand operation. 
An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. 
You may assume all four edges of the grid are all surrounded by water.

Example:

Given m = 3, n = 3, positions = [[0,0], [0,1], [1,2], [2,1]].
Initially, the 2d grid grid is filled with water. (Assume 0 represents water and 1 represents land).

0 0 0
0 0 0
0 0 0
Operation #1: addLand(0, 0) turns the water at grid[0][0] into a land.

1 0 0
0 0 0   Number of islands = 1
0 0 0
Operation #2: addLand(0, 1) turns the water at grid[0][1] into a land.

1 1 0
0 0 0   Number of islands = 1
0 0 0
Operation #3: addLand(1, 2) turns the water at grid[1][2] into a land.

1 1 0
0 0 1   Number of islands = 2
0 0 0
Operation #4: addLand(2, 1) turns the water at grid[2][1] into a land.

1 1 0
0 0 1   Number of islands = 3
0 1 0
We return the result as an array: [1, 1, 2, 3]
*/

public class Solution {
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> res = new ArrayList<Integer>();
        if(m == 0 || n == 0) return res;
        if(positions == null || positions.length == 0) return res;
        int[][] dir = {{-1, 0}, {1,0}, {0,-1}, {0, 1}};
        int[] roots = new int[m*n];
        Arrays.fill(roots, -1);
        int cnt = 0;
        for(int[] p: positions) {
            int cur = n*p[0] + p[1];
            roots[cur] = cur ;
            cnt++;
            for(int i=0; i<4; i++) {
                int x = p[0] + dir[i][0];
                int y = p[1] + dir[i][1];
                if(x<0 || x>=m || y<0 || y>=n || roots[x*n+y] == -1) continue;
                int root = find(roots, x*n+y);
                int curR = find(roots, cur);
                if(curR != root) {
                    roots[curR] = root;
                    cnt--;
                }
            }
            res.add(cnt);
        }
        return res;
    }
    
    private int find(int[] roots, int root) {
        while(roots[root] != root) {
            int id = roots[root];
            roots[root] = roots[id];
            root = id;
        }
        return root;
    }
 }
