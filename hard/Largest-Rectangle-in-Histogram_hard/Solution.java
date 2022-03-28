/*
Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, 
find the area of largest rectangle in the histogram.
Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3].
The largest rectangle is shown in the shaded area, which has area = 10 unit.

For example,
Given heights = [2,1,5,6,2,3],
return 10.
*/

public class Solution {
    public int largestRectangleArea(int[] heights) {
        if(heights == null || heights.length == 0) return 0;
        Stack<Integer> s = new Stack<Integer>();
        int n = heights.length;
        int max = 0;
        s.push(-1);
        for(int i=0; i<n; i++) {
            while(s.peek() !=-1 && heights[s.peek()] > heights[i]) {
                int cur = s.pop();
                max = Math.max(max, heights[cur]*(i-s.peek()-1));
            }
            s.push(i);
        }
        int last = s.peek();
        while(s.peek() != -1) {
            int cur = s.pop();
            max = Math.max(max, heights[cur]*(last-s.peek()));
        }
        return max;
    }
}
