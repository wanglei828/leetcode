/*
Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, 
find the one that is missing from the array.

For example,
Given nums = [0, 1, 3] return 2.

Note:
Your algorithm should run in linear runtime complexity. 
Could you implement it using only constant extra space complexity?
*/

public class Solution {
    public int missingNumber(int[] nums) {
        if(nums.length == 0) return 0;
        for(int i = 0; i<nums.length; i++) {
            while(nums[i] != i && nums[i] != nums.length) {
                int tmp = nums[i];
                nums[i] = nums[tmp];
                nums[tmp] = tmp;
            }
        }
        for(int i=0; i < nums.length;i++) {
            if(nums[i] == nums.length) {
                return i;
            }
        }
        return nums.length;
    }
}
