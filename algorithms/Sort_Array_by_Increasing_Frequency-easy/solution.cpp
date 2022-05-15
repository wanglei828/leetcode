/*
Given an array of integers nums, sort the array in increasing order based on the frequency of the values. 
If multiple values have the same frequency, sort them in decreasing order.

Return the sorted array.

 

Example 1:

Input: nums = [1,1,2,2,2,3]
Output: [3,1,1,2,2,2]
Explanation: '3' has a frequency of 1, '1' has a frequency of 2, and '2' has a frequency of 3.
Example 2:

Input: nums = [2,3,1,3,2]
Output: [1,3,3,2,2]
Explanation: '2' and '3' both have a frequency of 2, so they are sorted in decreasing order.
Example 3:

Input: nums = [-1,1,-6,4,5,-6,1,4,1]
Output: [5,-1,4,4,-6,-6,1,1,1]
 

Constraints:

1 <= nums.length <= 100
-100 <= nums[i] <= 100
*/

class Solution {
public:
    struct com {
        bool operator()(pair<int, int> p1, pair<int, int> p2) {
            if (p1.second == p2.second) {
                return p1.first < p2.first;
            } else {
                return p1.second > p2.second;
            }
        }
    };
    vector<int> frequencySort(vector<int>& nums) {
        priority_queue<pair<int, int>, vector<pair<int, int>>, com> q;
        unordered_map<int, int> map;
        for (int i : nums) {
            map[i]++;
        }
        for (auto& p : map) {
            q.push(p);
        }
        vector<int> res;
        while (!q.empty()) {
            pair<int, int> p = q.top();
            q.pop();
            for (int i = 0; i < p.second; i++) {
                res.push_back(p.first);
            }
        }
        return res;
    }
};
