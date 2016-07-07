/*
Given an unsorted array nums, reorder it in-place such that nums[0] <= nums[1] >= nums[2] <= nums[3]....

For example, given nums = [3, 5, 2, 1, 6, 4], one possible answer is [1, 6, 2, 5, 3, 4].
*/

public class Solution {
    public void wiggleSort(int[] nums) {
        if(nums == null || nums.length <2) return;
        for(int i=0; i<nums.length-1; i++) {
            if(i%2 == 0) {
                if(nums[i] > nums[i+1]) {
                    int tmp = nums[i+1];
                    nums[i+1] = nums[i];
                    nums[i] = tmp;
                }
            } else {
                if(nums[i] < nums[i+1]) {
                    int tmp = nums[i+1];
                    nums[i+1] = nums[i];
                    nums[i] = tmp;                   
                }
            }
        }
    }
}
