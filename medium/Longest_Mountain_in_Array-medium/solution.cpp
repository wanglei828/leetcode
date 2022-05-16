/*
You may recall that an array arr is a mountain array if and only if:

arr.length >= 3
There exists some index i (0-indexed) with 0 < i < arr.length - 1 such that:
arr[0] < arr[1] < ... < arr[i - 1] < arr[i]
arr[i] > arr[i + 1] > ... > arr[arr.length - 1]
Given an integer array arr, return the length of the longest subarray, 
which is a mountain. Return 0 if there is no mountain subarray.

 

Example 1:

Input: arr = [2,1,4,7,3,2,5]
Output: 5
Explanation: The largest mountain is [1,4,7,3,2] which has length 5.
Example 2:

Input: arr = [2,2,2]
Output: 0
Explanation: There is no mountain.
 

Constraints:

1 <= arr.length <= 104
0 <= arr[i] <= 104
 

Follow up:

Can you solve it using only one pass?
Can you solve it in O(1) space?
*/

class Solution {
public:
    int longestMountain(vector<int>& arr) {
        int n = arr.size();
        int left[n];
        int right[n];
        memset(left, 0, sizeof(left));
        memset(right, 0, sizeof(right));
        for (int i = 1; i < n; i++) {
            if (arr[i] > arr[i-1]) {
                left[i] = left[i-1] + 1;
            } else {
                left[i] = 0;
            }
        }
        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] > arr[i+1]) {
                right[i] = right[i+1] + 1;
            } else {
                right[i] = 0;
            }
        }
        int res = 0;
        for (int i = 1; i < n - 1; i++) {
            if (left[i] != 0 && right[i] != 0) {
                res = max(res, left[i] + right[i] + 1);
            }
        }
        return res;
    }
};
