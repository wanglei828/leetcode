/*
Given a list of 24-hour clock time points in "HH:MM" format, 
return the minimum minutes difference between any two time-points in the list.
 

Example 1:

Input: timePoints = ["23:59","00:00"]
Output: 1
Example 2:

Input: timePoints = ["00:00","23:59","00:00"]
Output: 0
 

Constraints:

2 <= timePoints.length <= 2 * 104
timePoints[i] is in the format "HH:MM".
*/

class Solution {
public:
    int findMinDifference(vector<string>& timePoints) {
        int n = timePoints.size();
        int cnt[1440];
        memset(cnt, 0, sizeof(cnt));
        for (int i = 0; i < n; i++) {
            int h = stoi(timePoints[i].substr(0, 2));
            int m = stoi(timePoints[i].substr(3, 2));
            cnt[h*60 + m]++;
            if (cnt[h*60 + m] > 1) {
                return 0;
            }
 
        }
        vector<int> time;
        for (int i = 0; i < 24 * 60; i++) {
            if (cnt[i] > 0) {
                time.push_back(i);
            }
        }
        int res = INT_MAX;
        for (int i = 1; i < time.size(); i++) {
            res = min(res, time[i] - time[i-1]);
            res = min(res, 1440 - (time[i] - time[i-1]));
        }
        res = min(res, 24 * 60 - time.back() + time[0]);
        return res;
    }
};
