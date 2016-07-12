/*
Suppose a sorted array is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

Find the minimum element.
The array may contain duplicates.
*/

public class Solution {
    public int findMin(int[] nums) {
        int n = nums.length;
        if(n== 1 || nums[0] < nums[n-1]) return nums[0];
        int h = 0;
        int t = n-1;
        while(h<t) {
            int m = h + (t-h)/2;
            if(nums[m] > nums[t]) {
                h = m+1;
            } else if(nums[m] < nums[t]) {
                t = m;
            } else {
                t--;
            }
        }
        return nums[h];
    }
}
