/*
Given an array nums containing n + 1 integers where each integer is between 1 and n (inclusive), 
prove that at least one duplicate number must exist. Assume that there is only one duplicate number, find the duplicate one.

Note:
You must not modify the array (assume the array is read only).
You must use only constant, O(1) extra space.
Your runtime complexity should be less than O(n2).
There is only one duplicate number in the array, but it could be repeated more than once.
*/

public class Solution {
    public int findDuplicate(int[] nums) {
        if(nums == null || nums.length <=1) return 0;
        int n = nums.length-1;
        int h = 1;
        int t = n;
        while(h<=t) {
            int m = h+(t-h)/2;
            int cSmall=0, cBig=0, cEqual=0;
            for(int i=0; i<nums.length; i++) {
                if(nums[i] > m) {
                    cBig++;
                } else if(nums[i] < m) {
                    cSmall++;
                } else {
                    cEqual++;
                }
                if(cEqual > 1) {
                    return m;
                }
            }
            if(cBig > (n-m)) {
                h = m+1;
            }
            if(cSmall > m -1) {
                t = m-1;
            }
        }
        return h;
    }
}
