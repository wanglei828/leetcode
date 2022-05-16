/*
We want to split a group of n people (labeled from 1 to n) into two groups of any size. 
Each person may dislike some other people, and they should not go into the same group.

Given the integer n and the array dislikes where dislikes[i] = [ai, bi] 
indicates that the person labeled ai does not like the person labeled bi, 
return true if it is possible to split everyone into two groups in this way.

 

Example 1:

Input: n = 4, dislikes = [[1,2],[1,3],[2,4]]
Output: true
Explanation: group1 [1,4] and group2 [2,3].
Example 2:

Input: n = 3, dislikes = [[1,2],[1,3],[2,3]]
Output: false
Example 3:

Input: n = 5, dislikes = [[1,2],[2,3],[3,4],[4,5],[1,5]]
Output: false
 

Constraints:

1 <= n <= 2000
0 <= dislikes.length <= 104
dislikes[i].length == 2
1 <= dislikes[i][j] <= n
ai < bi
All the pairs of dislikes are unique.
*/

class Solution {
public:
    bool possibleBipartition(int n, vector<vector<int>>& dislikes) {
        int color[n+1];
        memset(color, -1, sizeof(color));
        unordered_map<int, vector<int>> map;
        for (auto & v : dislikes) {
            int p1 = v[0];
            int p2 = v[1];
            if (map.find(p1) == map.end()) {
                map[p1] = vector<int>();
            }
            if (map.find(p2) == map.end()) {
                map[p2] = vector<int>();
            }
            map[p1].push_back(p2);
            map[p2].push_back(p1);
        }
        
        for (int i = 1; i <= n; i++) {
            if (color[i] != -1) {
                continue;
            }
            color[i] = 0;
            queue<int> q;
            q.push(i);
            while (!q.empty()) {
                int cur = q.front();
                q.pop();
                if (map.find(cur) == map.end()) {
                    continue;
                }
                for (int j : map[cur]) {
                    if (color[j] == -1) {
                        color[j] = 1 ^ color[cur];
                        q.push(j);
                    } else if (color[j] == color[cur]) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
};
