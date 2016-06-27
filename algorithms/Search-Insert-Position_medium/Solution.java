/*
Given a sorted array and a target value, return the index if the target is found. 
If not, return the index where it would be if it were inserted in order.

You may assume no duplicates in the array.

Here are few examples.
[1,3,5,6], 5 → 2
[1,3,5,6], 2 → 1
[1,3,5,6], 7 → 4
[1,3,5,6], 0 → 0
*/

public class Solution {
    public int searchInsert(int[] nums, int target) {
        if(nums.length == 0) return 0;
        int h = 0;
        int t = nums.length-1;
        int mid = h + (t-h)/2;
        while(h < t) {
            int tmp = nums[mid];
            if(tmp < target) {
                h = mid + 1;
            } else if (tmp > target) {
                t= mid -1;
            } else {
                return mid;
            }
            mid = h+(t-h)/2;
        }
        if(nums[h] < target) {
            return h+1;
        } else {
            return h;
        }
    }
}
