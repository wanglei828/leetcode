/*
You are given a 2D integer grid of size m x n and an integer x. In one operation, you can add x to or subtract x from any element in the grid.

A uni-value grid is a grid where all the elements of it are equal.

Return the minimum number of operations to make the grid uni-value. If it is not possible, return -1.

Input: grid = [[2,4],[6,8]], x = 2
Output: 4
Explanation: We can make every element equal to 4 by doing the following: 
- Add x to 2 once.
- Subtract x from 6 once.
- Subtract x from 8 twice.
A total of 4 operations were used.

Input: grid = [[1,5],[2,3]], x = 1
Output: 5
Explanation: We can make every element equal to 3.

Input: grid = [[1,2],[3,4]], x = 2
Output: -1
Explanation: It is impossible to make every element equal.

*/

class Solution {
    public int minOperations(int[][] grid, int x) {
        int m = grid.length;
        int n = grid[0].length;
        int[] nums = new int[m*n];
        int index = 0;
        int rem = -1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                nums[index++] = grid[i][j];
                if (rem == -1) {
                    rem = grid[i][j] % x;
                } else {
                    if (rem != grid[i][j] % x) {
                        return -1;
                    }
                }
            }
        }
        Arrays.sort(nums);
        int middle = nums[m*n/2];
        int ans = 0;
        for (int i = 0; i < m*n; i++) {
            int cur = nums[i];
            ans += Math.abs(middle - cur) / x;
        }
        return ans;
    }
}
