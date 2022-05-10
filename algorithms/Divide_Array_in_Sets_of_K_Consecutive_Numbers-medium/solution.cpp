/*
Given an array of integers nums and a positive integer k, check whether it is possible to divide this array into sets of k consecutive numbers.

Return true if it is possible. Otherwise, return false.

 

Example 1:

Input: nums = [1,2,3,3,4,4,5,6], k = 4
Output: true
Explanation: Array can be divided into [1,2,3,4] and [3,4,5,6].
Example 2:

Input: nums = [3,2,1,2,3,4,3,4,5,9,10,11], k = 3
Output: true
Explanation: Array can be divided into [1,2,3] , [2,3,4] , [3,4,5] and [9,10,11].
Example 3:

Input: nums = [1,2,3,4], k = 3
Output: false
Explanation: Each array should be divided in subarrays of size 3.
 

Constraints:

1 <= k <= nums.length <= 105
1 <= nums[i] <= 10^9
*/

class Solution {
public:
    bool isPossibleDivide(vector<int>& nums, int k) {
        map<int, int> map;
        for (int n : nums) {
            map[n]++;
        }
        while (!map.empty()) {
            if (!check(map, k)) {
                return false;
            }
        }
        return true;
    }
    
    bool check(map<int,int>& map, int k) {
        int cur = map.begin()->first;
        while (k > 0) {
            if (map.find(cur) == map.end()) {
                return false;
            } else {
                map[cur]--;
                if (map[cur] == 0) {
                    map.erase(cur);
                }
            }            
            cur++;
            k--;  
        }
        return true;
    }
};
