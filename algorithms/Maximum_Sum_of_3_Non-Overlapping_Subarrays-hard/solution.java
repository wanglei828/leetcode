/*

In a given array nums of positive integers, find three non-overlapping subarrays with maximum sum.

Each subarray will be of size k, and we want to maximize the sum of all 3*k entries.

Return the result as a list of indices representing the starting position of each interval (0-indexed). 
If there are multiple answers, return the lexicographically smallest one.

Example:

Input: [1,2,1,2,6,7,5,1], 2
Output: [0, 3, 5]
Explanation: Subarrays [1, 2], [2, 6], [7, 5] correspond to the starting indices [0, 3, 5].
We could have also taken [2, 1], but an answer of [1, 3, 5] would be lexicographically larger.
 

Note:

nums.length will be between 1 and 20000.
nums[i] will be between 1 and 65535.
k will be between 1 and floor(nums.length / 3).

*/

class Solution {
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int n = nums.length;
        int[] sum = new int[n-k+1];
        for(int i=0; i<k; i++) {
            sum[0] += nums[i];
        }
        for(int i=1; i<n-k+1; i++) {
            sum[i] = sum[i-1] + nums[i+k-1] - nums[i-1];
        }
        int[] left = new int[n-k+1];
        int best = 0;
        for(int i=0; i<n-k+1; i++) {
            if(sum[i] > sum[best]) {
                best = i;
            }
            left[i] = best;
        }
        int[] right = new int[n-k+1];
        best = n-k;
        for(int i=n-k; i>=0; i--) {
            if(sum[i] >= sum[best]) {
                best = i;
            }
            right[i] = best;
        }
        int[] res = new int[3];
        int max = 0;
        for(int i=k; i<=n-2*k; i++) {
            if(max < sum[left[i-k]] + sum[i] + sum[right[i+k]]) {
                res[0] = left[i-k];
                res[1] = i;
                res[2] = right[i+k];
                max = sum[left[i-k]] + sum[i] + sum[right[i+k]];
            }
        }
        return res;
    }
}
