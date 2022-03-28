/*
After robbing those houses on that street, 
the thief has found himself a new place for his thievery so that he will not get too much attention. 
This time, all houses at this place are arranged in a circle. 
That means the first house is the neighbor of the last one. 
Meanwhile, the security system for these houses remain the same as for those in the previous street.

Given a list of non-negative integers representing the amount of money of each house, 
determine the maximum amount of money you can rob tonight without alerting the police.
*/

public class Solution {
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int n = nums.length;
        if(n == 1) return nums[0];
        if(n == 2) return Math.max(nums[0],nums[1]);
        int[] dp0 = new int[n];
        int[] dp1 = new int[n];
        dp0[0] = nums[0];
        dp1[0] = 0;
        dp0[1] = Math.max(nums[0], nums[1]);
        dp1[1] = nums[1];
        for(int i=2; i<n-1; i++) {
            dp0[i] = Math.max(dp0[i-1], dp0[i-2] + nums[i]);
            dp1[i] = Math.max(dp1[i-1], dp1[i-2] + nums[i]);
        }
        dp0[n-1] = dp0[n-2];
        dp1[n-1] = Math.max(dp1[n-2], dp1[n-3] + nums[n-1]);
        return Math.max(dp0[n-1], dp1[n-1]);
    }
}
