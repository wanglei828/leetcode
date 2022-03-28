/*
Find the kth largest element in an unsorted array. 
Note that it is the kth largest element in the sorted order, not the kth distinct element.

For example,
Given [3,2,1,5,6,4] and k = 2, return 5.

Note: 
You may assume k is always valid, 1 ≤ k ≤ array's length.
*/

public class Solution {
    public int findKthLargest(int[] nums, int k) {
        if(nums.length == 0) return 0;
        return helper(nums, 0, nums.length-1, k);
    }
    
    private int helper(int[] nums, int h, int t, int k) {
        if(t-h+1 == k) {
            int min = nums[h];
            for(int i=h+1; i<=t; i++) {
                min = Math.min(min, nums[i]);
            }
            return min;
        }
        int mid = h + (t-h)/2;
        int target = nums[mid];
        int h1 = h;
        int t1 = t;
        while(h1 <= t1) {
            while(nums[t1] > target) {
                t1--;
            }
            while(nums[h1] < target) {
                h1++;
            }
            if(h1 <= t1) {
                int tmp = nums[t1];
                nums[t1] = nums[h1];
                nums[h1] = tmp; 
                t1--;
                h1++;
            }
        }
        if(t-h1+1>=k) {
            return helper(nums, h1, t, k);
        } else {
            return helper(nums, h, h1-1, k-(t-h1+1));
        }
    }
}
