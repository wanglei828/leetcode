/*

Given a non-empty array containing only positive integers, 
find if the array can be partitioned into two subsets such that the sum of elements in both subsets is equal.

Note:

Each of the array element will not exceed 100.
The array size will not exceed 200.
 

Example 1:

Input: [1, 5, 11, 5]

Output: true

Explanation: The array can be partitioned as [1, 5, 5] and [11].
 

Example 2:

Input: [1, 2, 3, 5]

Output: false

Explanation: The array cannot be partitioned into equal sum subsets.

*/

class Solution {
    public boolean canPartition(int[] nums) {
        if(nums.length == 1) return false;
        if(nums.length == 2) return nums[1] == nums[0];
        int sum = 0;
        for(int i=0; i<nums.length; i++) {
            sum += nums[i];
        }
        if(sum%2 != 0) return false;
        int target = sum/2;
        Arrays.sort(nums);
        return works(nums, target, target, nums.length-1);
    }
    
    private boolean works(int[] nums, int s1, int s2, int index) {
        if(index == -1) return s1 == 0 && s2 == 0;
        if(nums[index] > s1) {
            return works(nums, s1, s2-nums[index], index-1);
        } else if (nums[index] > s2) {
            return works(nums, s1-nums[index], s2, index-1);
        } else {
            return works(nums, s1, s2-nums[index], index-1) || works(nums, s1-nums[index], s2, index-1);   
        }
    }
}
