/*
Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai). 
n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). 
Find two lines, which together with x-axis forms a container, such that the container contains the most water.

Note: You may not slant the container.
*/

public class Solution {
    public int maxArea(int[] height) {
        if(height.length <= 1) return 0;
        int h = 0;
        int t = height.length-1;
        int max = 0;
        while(h<t) {
            int min = Math.min(height[h], height[t]);
            max = Math.max(max, (t-h)*min);
            if(height[h] <= height[t]) {
                h++;
            } else {
                t--;
            }
        }
        return max;
    }
}
