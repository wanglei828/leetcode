/*
Suppose a sorted array is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

Find the minimum element.

You may assume no duplicate exists in the array.
*/

public class Solution {
    public int findMin(int[] nums) {
        if(nums == null || nums.length == 0) return Integer.MIN_VALUE;
        int n = nums.length;
        if(nums[0] < nums[n-1]) return nums[0];
        int h = 0;
        int t = n-1;
        while(h<t) {
            int mid = h+(t-h)/2;
            if(nums[mid]< nums[t]) {
                t = mid;
            } else {
                h = mid+1;
            }
        }
        return nums[h];
    }
}
