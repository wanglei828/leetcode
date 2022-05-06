/*
There are m boys and n girls in a class attending an upcoming party.

You are given an m x n integer matrix grid, where grid[i][j] equals 0 or 1. If grid[i][j] == 1, 
then that means the ith boy can invite the jth girl to the party. 
A boy can invite at most one girl, and a girl can accept at most one invitation from a boy.

Return the maximum possible number of accepted invitations.

 

Example 1:

Input: grid = [[1,1,1],
               [1,0,1],
               [0,0,1]]
Output: 3
Explanation: The invitations are sent as follows:
- The 1st boy invites the 2nd girl.
- The 2nd boy invites the 1st girl.
- The 3rd boy invites the 3rd girl.
Example 2:

Input: grid = [[1,0,1,0],
               [1,0,0,0],
               [0,0,1,0],
               [1,1,1,0]]
Output: 3
Explanation: The invitations are sent as follows:
-The 1st boy invites the 3rd girl.
-The 2nd boy invites the 1st girl.
-The 3rd boy invites no one.
-The 4th boy invites the 2nd girl.
 

Constraints:

grid.length == m
grid[i].length == n
1 <= m, n <= 200
grid[i][j] is either 0 or 1.
*/

class Solution {
public:
    int maximumInvitations(vector<vector<int>>& grid) {
        int res = 0;
        int m = grid.size();
        int n = grid[0].size();
        vector<int> pair(n, -1);
        for (int i = 0; i < m; i++) {
            vector<int> visit(n, 0);
            if (match(grid, pair, visit, i)) {
                res++;
            }
        }
        return res;
    }
    
    bool match(vector<vector<int>>& grid, vector<int>& pair, vector<int>& visit, int cur) {
        int n = grid[0].size();
        for (int i = 0; i < n; i++) {
            if (grid[cur][i] == 1 && visit[i] == 0) {
                visit[i] = 1;
                if (pair[i] == -1 || match(grid, pair, visit, pair[i])) {
                    pair[i] = cur;
                    return true;
                }
            }
        }
        return false;
    }
};
