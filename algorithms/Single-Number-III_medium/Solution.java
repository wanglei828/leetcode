/*
Given an array of numbers nums, in which exactly two elements appear only once and 
all the other elements appear exactly twice. Find the two elements that appear only once.

For example:

Given nums = [1, 2, 1, 3, 2, 5], return [3, 5].

Note:
The order of the result is not important. So in the above example, [5, 3] is also correct.
Your algorithm should run in linear runtime complexity. Could you implement it using only constant space complexity?
*/

public class Solution {
    public int[] singleNumber(int[] nums) {
        if(nums == null || nums.length == 0) return new int[0];
        int xor = 0;
        for(int i:nums) {
            xor ^= i;
        }
        int last = xor - (xor&(xor-1));
        int[] res = new int[2];
        for(int i: nums){
            if((last & i) == 0) {
                res[0] ^= i;
            } else {
                res[1] ^= i;
            }
        }
        return res;
    }
}
