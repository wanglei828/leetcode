class Solution {
public:
    int minDifference(vector<int>& nums) {
        if (nums.size() <= 4) return 0;
        int maxq[4];
        int minq[4];
        fill_n(maxq, 4, INT_MIN);
        fill_n(minq, 4, INT_MAX);
        for (int n : nums) {
            getMax(maxq, n);
            getMin(minq, n);
        }
        int res = INT_MAX;
        for (int i = 0; i < 4; i++) {
            res = min(res, maxq[i] - minq[3-i]);
        }
        return res;
    }
    
    void getMax(int maxq[4], int n) {
        for (int i = 0; i < 4; i++) {
            if (maxq[i] < n) {
                int tmp = n;
                n = maxq[i];
                maxq[i] = tmp;
            }
        }
    }
    
    void getMin(int minq[4], int n) {
        for (int i = 0; i < 4; i++) {
            if (minq[i] > n) {
                int tmp = n;
                n = minq[i];
                minq[i] = tmp;
            }
        }
    }
};
