class Solution {
public:
    int longestMountain(vector<int>& arr) {
        int n = arr.size();
        int res = 0, left = 0;
        while (left < n) {
            int right = left;
            if (right + 1 < n && arr[right] < arr[right+1]) {
                while (right + 1 < n && arr[right] < arr[right+1]) right++;
                if (right + 1 < n && arr[right] > arr[right+1]) {
                    while (right + 1 < n && arr[right] > arr[right+1]) right++;
                    res = max(res, right - left + 1);
                }
            }
            left = max(right, left + 1);
        }
        return res;
    }
};
