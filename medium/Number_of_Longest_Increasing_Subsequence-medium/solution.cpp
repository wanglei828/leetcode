/*
Given an integer array nums, return the number of longest increasing subsequences.

Notice that the sequence has to be strictly increasing.

 

Example 1:

Input: nums = [1,3,5,4,7]
Output: 2
Explanation: The two longest increasing subsequences are [1, 3, 4, 7] and [1, 3, 5, 7].
Example 2:

Input: nums = [2,2,2,2,2]
Output: 5
Explanation: The length of longest continuous increasing subsequence is 1, 
and there are 5 subsequences' length is 1, so output 5.

 

Constraints:

1 <= nums.length <= 2000
-106 <= nums[i] <= 106
*/

class Solution {
public:
    int findNumberOfLIS(vector<int>& nums) {
        int n = nums.size();
        int cnt[n];
        memset(cnt, 1, sizeof(cnt));
        unordered_map<int, int> map;
        unordered_map<int, int> index;
        int cmax = 1;
        map[1] = n;
        for (int i = 0; i < n; i++) {
            int m = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    if (cnt[j] + 1 > cnt[i]) {
                        cnt[i] = cnt[j] + 1;
                        m = index[j];
                    } else if (cnt[j] + 1 == cnt[i]) {
                        m += index[j];
                    }
                }
            }
            cmax = max(cmax, cnt[i]);
            if (map.find(cnt[i]) != map.end()) {
                map[cnt[i]] += m;
            } else {
                map[cnt[i]] = m;
            }
            index[i] = m;
        }
        return map[cmax];
    }
};
