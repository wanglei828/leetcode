class Solution {
public:
    int maximumScore(vector<int>& nums, vector<int>& multipliers) {
        int n = nums.size();
        int m = multipliers.size();
        vector<vector<int>> dp(m, vector<int>(m));
        return help(dp, 0, n-1, nums, multipliers, 0);
    }
    
    int help(vector<vector<int>>& dp, int left, int right, vector<int>& nums, vector<int>& mul, int index) {
        if (index >= mul.size()) return 0;
        if (dp[left][index] != 0) return dp[left][index];
        int o1 = nums[left] * mul[index] + help(dp, left+1, right, nums, mul, index+1);
        int o2 = nums[right] * mul[index] + help(dp, left, right-1, nums, mul, index+1);
        dp[left][index] = (o1 > o2)? o1 : o2;
        return dp[left][index];
    }
};
