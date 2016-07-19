/*
You want to build a house on an empty land which reaches all buildings in the shortest amount of distance. 
You can only move up, down, left and right. You are given a 2D grid of values 0, 1 or 2, where:

Each 0 marks an empty land which you can pass by freely.
Each 1 marks a building which you cannot pass through.
Each 2 marks an obstacle which you cannot pass through.
For example, given three buildings at (0,0), (0,4), (2,2), and an obstacle at (0,2):

1 - 0 - 2 - 0 - 1
|   |   |   |   |
0 - 0 - 0 - 0 - 0
|   |   |   |   |
0 - 0 - 1 - 0 - 0
The point (1,2) is an ideal empty land to build a house, as the total travel distance of 3+3+1=7 is minimal. So return 7.
*/

public class Solution {
    public int shortestDistance(int[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0) return -1;
        int m = grid.length;
        int n = grid[0].length;
        int[][] dist = new int[m][n];
        int[][] reach = new int[m][n];
        int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int houseCount = 0;
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(grid[i][j] == 1) {
                    houseCount++;
                    Queue<Integer> q = new LinkedList<Integer>();
                    int curdist = 0;
                    int[][] visit = new int[m][n];
                    q.add(i*n+j);
                    while(!q.isEmpty()) {
                        int size = q.size();
                        curdist++;
                        while(size > 0) {
                            int tmp = q.poll();
                            size--;
                            int x = tmp/n;
                            int y = tmp%n;
                            for(int k=0; k<4; k++) {
                                int nx = x + dir[k][0];
                                int ny = y + dir[k][1];
                                if(nx>=0 && nx<m && ny>=0 && ny<n && grid[nx][ny] == 0 && visit[nx][ny] == 0) {
                                    reach[nx][ny]++;
                                    dist[nx][ny] += curdist;
                                    visit[nx][ny] = 1;
                                    q.add(nx*n + ny);
                                }
                            }
                        }
                    }
                }
            }
        }
        int min = Integer.MAX_VALUE;
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(reach[i][j] == houseCount) {
                    min = Math.min(min, dist[i][j]);
                }
            }
        }
        return (min == Integer.MAX_VALUE)? -1 : min;
    }
}
