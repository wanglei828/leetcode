/*
Given a sorted array of integers, find the starting and ending position of a given target value.

Your algorithm's runtime complexity must be in the order of O(log n).

If the target is not found in the array, return [-1, -1].

For example,
Given [5, 7, 7, 8, 8, 10] and target value 8,
return [3, 4].
*/

public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[2];
        if(nums == null || nums.length == 0) return res;
        int n = nums.length;
        int r = bSearch(nums, 0, n-1, target);
        res[0] = r;
        res[1] = r;
        if(r == -1) {
            return res;
        } else {
            r = bSearch(nums, 0, res[0]-1, target);
            while(r != -1) {
                res[0] = r;
                r = bSearch(nums, 0, res[0]-1, target);
            }
            r = bSearch(nums, res[1]+1, n-1, target);
            while(r != -1) {
                res[1] = r;
                r = bSearch(nums, res[1]+1, n-1, target);
            }
        }
        return res;
    }
    
    private int bSearch(int[] nums, int h, int t, int target) {
        if(h > t) return -1;
        int mid = h + (t-h)/2;
        while(h<=t) {
            if(nums[mid] > target) {
                t = mid -1;
            } else if(nums[mid] < target) {
                h = mid +1;
            } else {
                return mid;
            }
            mid = h + (t-h)/2;
        }
        return -1;
    }
}
