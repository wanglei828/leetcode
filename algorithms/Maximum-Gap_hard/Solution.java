/*
Given an unsorted array, find the maximum difference between the successive elements in its sorted form.

Try to solve it in linear time/space.

Return 0 if the array contains less than 2 elements.

You may assume all elements in the array are non-negative integers and fit in the 32-bit signed integer range.
*/

public class Solution {
    public int maximumGap(int[] nums) {
        if(nums == null || nums.length <2) return 0;
        int n = nums.length;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(int i : nums) {
            max = Math.max(max, i);
            min = Math.min(min, i);
        }
        if(n == 2) return max-min;
        int gap = (int)Math.ceil((double)(max - min)/(n - 1));
        if(gap == 0) return 0;
        int[] maxArr = new int[n-1];
        int[] minArr = new int[n-1];
        Arrays.fill(maxArr, Integer.MIN_VALUE);
        Arrays.fill(minArr, Integer.MAX_VALUE);
        minArr[0] = min;
        maxArr[0] = min;
        maxArr[n-2] = max;
        minArr[n-2] = max;
        for(int i : nums) {
            if(i == min || i == max) continue;
            int j = (i-min)/gap;
            maxArr[j] = Math.max(i, maxArr[j]);
            minArr[j] = Math.min(i, minArr[j]);
        }
        int res = 0;
        int prev = maxArr[0];
        for(int i=1; i<n-1; i++) {
            if(prev != Integer.MIN_VALUE && minArr[i] != Integer.MAX_VALUE) {
                res = Math.max(res, minArr[i] - prev);
            }
            prev = (maxArr[i] != Integer.MIN_VALUE)? maxArr[i] : prev;
        }
        return res;
    }
}
