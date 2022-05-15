/*
You are starving and you want to eat food as quickly as possible. You want to find the shortest path to arrive at any food cell.

You are given an m x n character matrix, grid, of these different types of cells:

'*' is your location. There is exactly one '*' cell.
'#' is a food cell. There may be multiple food cells.
'O' is free space, and you can travel through these cells.
'X' is an obstacle, and you cannot travel through these cells.
You can travel to any adjacent cell north, east, south, or west of your current location if there is not an obstacle.

Return the length of the shortest path for you to reach any food cell. If there is no path for you to reach food, return -1.
*/

class Solution {
public:
    int getFood(vector<vector<char>>& grid) {
        int dirs[4][2] = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int m = grid.size();
        int n = grid[0].size();
        queue<int> q;
        int dp[m][n];
        for (int i = 0; i < m; i++) {
            fill_n(dp[i], n, -1);
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '#') {
                    q.push(i*n + j);
                }
            }
        }
        int step = 0;
        while (!q.empty()) {
            step++;
            int size = q.size();
            while (size > 0) {
                int cur = q.front();
                q.pop();
                int x = cur / n;
                int y = cur % n;
                for (int k = 0; k < 4; k++) {
                    int nx = x + dirs[k][0];
                    int ny = y + dirs[k][1];
                    if (nx < 0 || nx >=m || ny < 0 || ny >= n ||
                        dp[nx][ny] != -1 || grid[nx][ny] == 'X') continue;
                    dp[nx][ny] = step;
                    if (grid[nx][ny] == '*') {
                        return step;
                    }
                    q.push(nx*n + ny);
                }
                size--;
            }
        }
        return -1;
    }
};
