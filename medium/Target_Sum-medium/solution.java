/*

You are given a list of non-negative integers, a1, a2, ..., an, and a target, S. 
Now you have 2 symbols + and -. For each integer, you should choose one from + and - as its new symbol.

Find out how many ways to assign symbols to make sum of integers equal to target S.

Example 1:
Input: nums is [1, 1, 1, 1, 1], S is 3. 
Output: 5
Explanation: 

-1+1+1+1+1 = 3
+1-1+1+1+1 = 3
+1+1-1+1+1 = 3
+1+1+1-1+1 = 3
+1+1+1+1-1 = 3

There are 5 ways to assign symbols to make the sum of nums be target 3.
Note:
The length of the given array is positive and will not exceed 20.
The sum of elements in the given array will not exceed 1000.
Your output answer is guaranteed to be fitted in a 32-bit integer.

*/

class Solution {
    int count = 0;
    public int findTargetSumWays(int[] nums, int S) {
        helper(nums, S, 0);
        return count;
    }
    
    private void helper(int[] nums, int S, int start) {
        if(S == 0 && start == nums.length) {
            count++;
            return;
        }
        if(start >= nums.length) return;
        helper(nums, S+nums[start], start+1);
        helper(nums, S-nums[start], start+1);
    }
}
