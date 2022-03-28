/*
Find the contiguous subarray within an array (containing at least one number) which has the largest sum.

For example, given the array [−2,1,−3,4,−1,2,1,−5,4],
the contiguous subarray [4,−1,2,1] has the largest sum = 6.
*/

public class Solution {
    public int maxSubArray(int[] nums) {
        if(nums == null || nums.length == 0) return Integer.MIN_VALUE;
        int max = Integer.MIN_VALUE;
        int n = nums.length;
        int cur = 0;
        for(int i=0; i<n; i++) {
            cur += nums[i];
            max = Math.max(max, cur);
            if(cur < 0) {
                cur = 0;
            }
        }
        return max;
    }
}
