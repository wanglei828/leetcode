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
        if (nums.length == 1) return false;
        int sum = 0;
        for (int i : nums) {
            sum += i;
        }
        if (sum % 2 != 0) return false;
        int target = sum / 2;
        int n = nums.length;
        // memo[i][j] = 1, find
        // memo[i][j] = -1, not find
        int[][] memo = new int[n][target+1];
        if (dfs(nums, n-1, target, memo) == 1) {
            return true;
        } else {
            return false;
        }
    }
    
    private int dfs(int[] nums, int index, int target, int[][] memo) {
        if (target < 0) {
            return -1;
        }
        if (target == 0) {
            return 1;
        }
        if (index == 0) {
            if (target == nums[0]) {
                return 1;
            } else {
                return -1;
            }
        }
        if (memo[index][target] != 0) {
            return memo[index][target];
        }
        if (dfs(nums, index-1, target-nums[index], memo) == 1) {
            memo[index][target] = 1;
        } else if (dfs(nums, index-1, target, memo) == 1) {
            memo[index][target] = 1;
        } else {
            memo[index][target] = -1;
        }
        return memo[index][target];
    }
}
