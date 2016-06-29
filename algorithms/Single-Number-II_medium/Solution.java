/*
Given an array of integers, every element appears three times except for one. Find that single one.

Note:
Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
*/

public class Solution {
    public int singleNumber(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int n = nums.length;
        int[] bits = new int[32];
        for(int i=0; i<n; i++) {
            int num = nums[i];
            int j = 0;
            while(num != 0 && j<32) {
                bits[j] += num&1;
                num = num>>1;
                j++;
            }
        }
        int res = 0;
        for(int i=31; i>=0; i--) {
            res = res*2 + bits[i]%3;
        }
        return res;
    }
}
