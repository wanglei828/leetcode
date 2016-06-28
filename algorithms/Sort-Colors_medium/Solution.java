/*
Given an array with n objects colored red, white or blue, 
sort them so that objects of the same color are adjacent, with the colors in the order red, white and blue.

Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

Note:
You are not suppose to use the library's sort function for this problem.
*/

public class Solution {
    public void sortColors(int[] nums) {
        if(nums == null || nums.length == 0) return;
        int r = 0;
        int b = nums.length-1;
        int i = 0;
        while(i<=b) {
            if(nums[i] == 0) {
                swap(nums, r, i);
                r++;
                i++;
                continue;
            }
            if(nums[i] == 2) {
                swap(nums, b, i);
                b--;
                continue;
            }
            i++;
        }
    }
    private void swap(int[] nums, int h, int t) {
        int tmp = nums[h];
        nums[h] = nums[t];
        nums[t] = tmp;
    }
}
