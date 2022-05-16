class Solution {
public:
    int minimumEffortPath(vector<vector<int>>& heights) {
        int m = heights.size();
        int n = heights[0].size();
        struct com {
            bool operator()(vector<int>& o1, vector<int>& o2) {
                return o1[2] > o2[2];
            }
        };
        priority_queue<vector<int>, vector<vector<int>>, com> q;
        bool visit[m][n];
        memset(visit, false, sizeof(visit));
        visit[0][0] = true;
        int dirs[4][2] = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        q.push(vector<int>({0, 0, 0}));
        int res = 0;
        while (!q.empty()) {
            vector<int> cur = q.top();
            q.pop();
            visit[cur[0]][cur[1]] = true;
            res = max(res, cur[2]);
            if (cur[0] == m-1 && cur[1] == n -1) {
                return res;
            }
            for (int k = 0; k < 4; k++) {
                int x = cur[0] + dirs[k][0];
                int y = cur[1] + dirs[k][1];
                if (x < 0 || x >= m || y < 0 || y >= n || visit[x][y]) continue;
                q.push(vector<int>({x, y, abs(heights[cur[0]][cur[1]] - heights[x][y])}));
            }           
        }
        return res;        
    }
};
