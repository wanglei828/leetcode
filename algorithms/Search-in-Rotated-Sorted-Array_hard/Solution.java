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
        int i = findsmall(nums, 0, n-1);
        if(target >= nums[i] && target <= nums[n-1]) {
            return bsearch(nums, i, n-1, target);
        }
        if(i>0 && target<= nums[i-1] && target >= nums[0]) {
            return bsearch(nums, 0, i-1, target);
        }
        return -1;
    }
    
    private int findsmall(int[]nums, int h, int t) {
        if(nums[h] < nums[t]) return h;
        while(h<t) {
            int m = h+(t-h)/2;
            if(nums[m] < nums[t]) {
                t = m;
            } else if(nums[m] > nums[h]) {
                h = m+1;
            }
            if(h+1 == t) {
                return (nums[h] < nums[t])? h : t;
            }
        }
        return h;
    }
    
    private int bsearch(int[] nums, int h, int t, int target) {
        while(h<=t) {
            int m = h+(t-h)/2;
            if(nums[m] == target) {
                return m;
            } else if(nums[m] > target) {
                t = m-1;
            } else {
                h = m+1;
            }
        }
        return -1;
    }

}
