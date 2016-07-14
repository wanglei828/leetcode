/*
Suppose a sorted array is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

You are given a target value to search. If found in the array return its index, otherwise return -1.

You may assume no duplicate exists in the array.
*/

public class Solution {
    public int search(int[] nums, int target) {
        if(nums == null || nums.length == 0) return -1;
        int n = nums.length;
        int h = 0;
        int t = n-1;
        while(h<=t) {
            int m = h + (t-h)/2;
            if(target == nums[m]) {
                return m;
            }
            if(nums[m] >= nums[h]) {
                if(target<nums[m] && target >= nums[h]) {
                    t = m-1;
                } else {
                    h = m+1;
                }
            }
            if(nums[m] <= nums[t]) {
                if(target > nums[m] && target <= nums[t]) {
                    h = m+1;
                } else {
                    t = m-1;
                }
            }
        }

        return -1;
    }
}
