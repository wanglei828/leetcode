class Solution {
public:
    vector<int> minAvailableDuration(vector<vector<int>>& slots1, vector<vector<int>>& slots2, int duration) {
        struct com {
            bool operator()(vector<int>& v1, vector<int>& v2) {
                return v1[0] < v2[0];
            }
        };
        sort(slots1.begin(), slots1.end(), com());
        sort(slots2.begin(), slots2.end(), com());
        vector<int> res;
        int i = 0, j = 0;
        while (i < slots1.size() && j < slots2.size()) {
            if (slots1[i][0] >= slots2[j][1]) {
                j++;
            } else if (slots1[i][1] <= slots2[j][0]) {
                i++;
            } else {
                int start = max(slots1[i][0], slots2[j][0]);
                int end = min(slots1[i][1], slots2[j][1]);
                if (end - start >= duration) {
                    res.push_back(start);
                    res.push_back(start + duration);
                    return res;
                } else {
                    if (slots1[i][1] < slots2[j][1]) {
                        i++;
                    } else if (slots1[i][1] > slots2[j][1]) {
                        j++;
                    } else {
                        i++;
                        j++;
                    }
                }
            }
        }
        return res;        
    }
};
