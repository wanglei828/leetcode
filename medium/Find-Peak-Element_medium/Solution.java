/*
A peak element is an element that is greater than its neighbors.

Given an input array where num[i] ≠ num[i+1], find a peak element and return its index.

The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.

You may imagine that num[-1] = num[n] = -∞.

For example, in array [1, 2, 3, 1], 3 is a peak element and your function should return the index number 2.
*/

public class Solution {
    public int findPeakElement(int[] nums) {
        int n = nums.length;
        if(n == 1) return 0;
        int h = 0;
        int t = n-1;
        while(h<=t) {
            int m = h+(t-h)/2;
            if( m==0 && nums[m]>nums[m+1] || m==n-1 && nums[m]>nums[m-1] || m>0 && m<n-1 && nums[m]>nums[m-1] && nums[m]>nums[m+1]) {
                return m;
            } else if(nums[m]<nums[m+1]) {
                h = m+1;
            } else if(nums[m]<nums[m-1]) {
                t = m-1;
            }
        }
        return -1;
    }
}
