/*
Given an array of n positive integers and a positive integer s, 
find the minimal length of a subarray of which the sum ≥ s. If there isn't one, return 0 instead.

For example, given the array [2,3,1,2,4,3] and s = 7,
the subarray [4,3] has the minimal length under the problem constraint.
*/

public class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int n = nums.length;
        int min=n+1, l=-1;
        long cursum = 0;
        long left = 0;
        for(int i=0; i<n; i++) {
            cursum += nums[i];
            if(cursum >=s ) {
                while(l<i  && cursum - left>= s) {
                    min = Math.min(min, i-l);
                    l++;
                    left += nums[l];
                }
            }
        }
        return (min == n+1)? 0:min;
    }
}
