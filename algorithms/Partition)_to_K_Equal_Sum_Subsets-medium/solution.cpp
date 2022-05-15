/*
Given an integer array nums and an integer k, 
return true if it is possible to divide this array into k non-empty subsets whose sums are all equal.

 

Example 1:

Input: nums = [4,3,2,3,5,2,1], k = 4
Output: true
Explanation: It is possible to divide it into 4 subsets (5), (1, 4), (2,3), (2,3) with equal sums.
Example 2:

Input: nums = [1,2,3,4], k = 3
Output: false
 

Constraints:

1 <= k <= nums.length <= 16
1 <= nums[i] <= 104
The frequency of each element is in the range [1, 4].
*/

class Solution {
public:
    bool canPartitionKSubsets(vector<int>& nums, int k) {
        int n = nums.size();
        string visit(n, '0');
        int sum = 0;
        for (int a : nums) {
            sum += a;
        }
        if (sum % k != 0) return false;
        int tar = sum / k;
        sort(nums.begin(), nums.end(), greater<int>());
        unordered_map<string, bool> memo;
        return dfs(nums, tar, visit, k, 0, 0, 0, memo);
    }
    
    bool dfs(vector<int>& nums, int tar, string& visit, int k, int start, int curSum, int cnt, unordered_map<string,bool>& memo) {
        if (cnt == k - 1) {
            return true;
        }
        if (memo.find(visit) != memo.end()) {
            return memo[visit];
        }
        if (curSum == tar) {
            memo[visit] = dfs(nums, tar, visit, k, 0, 0, cnt+1, memo);
            return memo[visit];
        }
        if (curSum > tar) {
            return false;
        }
        for (int i = start; i < nums.size(); i++) {
            if (visit[i] == '1') continue;
            visit[i] = '1';
            if (dfs(nums, tar, visit, k, i+1, curSum + nums[i], cnt, memo)) {
                return true;
            }
            visit[i] = '0';
        }
        return false;
    }
};
