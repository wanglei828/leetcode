/*
Follow up for "Remove Duplicates":
What if duplicates are allowed at most twice?

For example,
Given sorted array nums = [1,1,1,2,2,3],

Your function should return length = 5, with the first five elements of nums being 1, 1, 2, 2 and 3. 
It doesn't matter what you leave beyond the new length.
*/

public class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int n = nums.length;
        int cur = nums[0];
        int count = 1;
        int pos = 1;
        for(int i=1; i<n; i++) {
            nums[pos] = nums[i];
            if(nums[i] == cur) {
                if(count < 2) {
                    count++;
                    pos++;
                } 
            } else {
                cur = nums[i];
                count = 1;
                pos++;
            }
        }
        return pos;
    }
}
