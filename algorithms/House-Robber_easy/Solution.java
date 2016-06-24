/*
You are a professional robber planning to rob houses along a street. 
Each house has a certain amount of money stashed, t
he only constraint stopping you from robbing each of them is that 
adjacent houses have security system connected and 
it will automatically contact the police if two adjacent houses were broken into on the same night.

Given a list of non-negative integers representing the amount of money of each house, 
determine the maximum amount of money you can rob tonight without alerting the police.
*/

public class Solution {
    public int rob(int[] nums) {
        if(nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        if(nums.length == 2) return Math.max(nums[0], nums[1]);
        int[] mon = new int[nums.length];
        Arrays.fill(mon, 0);
        mon[0] = nums[0];
        mon[1] = Math.max(nums[0], nums[1]);
        for(int i = 2; i<nums.length; i++){
            mon[i] = Math.max(mon[i-1], mon[i-2]+nums[i]);
        }
        return mon[nums.length-1];
    }
}
