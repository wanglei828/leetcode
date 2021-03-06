/*
Given an array of n integers where n > 1, nums, return an array output such that 
output[i] is equal to the product of all the elements of nums except nums[i].

Solve it without division and in O(n).

For example, given [1,2,3,4], return [24,12,8,6].

Follow up:
Could you solve it with constant space complexity? 
(Note: The output array does not count as extra space for the purpose of space complexity analysis.)
*/

public class Solution {
    public int[] productExceptSelf(int[] nums) {
        if(nums == null || nums.length == 0) return new int[0];
        int n = nums.length;
        int[] res = new int[n];
        res[0] = 1;
        int prod = nums[0];
        for(int i=1; i<n; i++) {
            res[i] = prod;
            prod *= nums[i];
        }
        prod = nums[n-1];
        for(int i=n-2; i>=0; i--) {
            res[i] = res[i]*prod;
            prod *= nums[i];
        }
        return res;
    }
}
