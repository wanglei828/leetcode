/*
Given an unsorted integer array, find the first missing positive integer.

For example,
Given [1,2,0] return 3,
and [3,4,-1,1] return 2.

Your algorithm should run in O(n) time and uses constant space.
*/

public class Solution {
    public int firstMissingPositive(int[] nums) {
        if(nums == null || nums.length == 0) return 1;
        int n = nums.length;
        for(int i=0; i<n; i++) {
            if(i != nums[i]) {
                while(i != nums[i]) {
                    if(nums[i] < 0 || nums[i] >= n || nums[nums[i]] == nums[i]) {
                        break;
                    }
                    int tmp = nums[nums[i]];
                    nums[nums[i]] = nums[i];
                    nums[i] = tmp;
                }
            }
        }
        for(int i=1; i<n; i++){
            if(i != nums[i]) {
                return i;
            }
        }
        return (nums[0] == n)? n+1:n;
    }
}
