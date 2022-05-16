class Solution {
public:
    struct mycompare{
        bool operator()(pair<int, double> p1, pair<int, double> p2) {
            return p1.second < p2.second;
        }        
    };

    double maxProbability(int n, vector<vector<int>>& edges, vector<double>& succProb, int start, int end) {
        unordered_map<int, vector<pair<int, double>>> map;
        for (int i = 0; i < edges.size(); i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            double prob = succProb[i];
            if (map.find(u) == map.end()) {
                map[u] = vector<pair<int,double>>();
            }
            if (map.find(v) == map.end()) {
                map[v] = vector<pair<int,double>>();
            }
            map[u].push_back(pair<int, double>(v, prob));
            map[v].push_back(pair<int, double>(u, prob));
        }
        
        if (map.find(start) == map.end()) {
            return 0.0;
        }
        priority_queue<pair<int, double>, vector<pair<int, double>>, mycompare> q;
        bool visit[n];
        memset(visit, false, sizeof(visit));
        for(auto & p : map[start]) {
            q.push(p);
        }
        while (!q.empty()) {
            pair<int, double> cur = q.top();
            q.pop();
            int id = cur.first;
            double prob = cur.second;
            if (id == end) {
                return prob;
            }
            if (visit[id]) {
                continue;
            } else {
                visit[id] = true;
            }
            if (map.find(id) == map.end()) {
                continue;
            }
            for (auto &p : map[id]) {
                q.push(pair<int, double>(p.first, prob * p.second));
            }
        }
        return 0.0;
    }
};
