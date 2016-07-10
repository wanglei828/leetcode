/*
Given n non-negative integers representing an elevation map where the width of each bar is 1, 
compute how much water it is able to trap after raining.

For example, 
Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.
*/

public class Solution {
    public int trap(int[] height) {
        if(height == null || height.length == 0) return 0;
        int n = height.length;
        int[] left = new int[n];
        int[] right = new int[n];
        left[0] = 0;
        right[n-1] = 0;
        for(int i=1; i<n; i++) {
            left[i] = Math.max(left[i-1], height[i-1]);
        }
        for(int i=n-2; i>=0; i--) {
            right[i] = Math.max(right[i+1], height[i+1]);
        }
        int sum = 0;
        for(int i=0; i<n; i++) {
            int cur = Math.min(left[i], right[i]) - height[i];
            sum = (cur>0)? sum+cur: sum;
        }
        return sum;
    }
}
