/*
Given a m x n matrix grid which is sorted in non-increasing order both row-wise and column-wise, return the number of negative numbers in grid.

 

Example 1:

Input: grid = [[4,3,2,-1],[3,2,1,-1],[1,1,-1,-2],[-1,-1,-2,-3]]
Output: 8
Explanation: There are 8 negatives number in the matrix.
Example 2:

Input: grid = [[3,2],[1,0]]
Output: 0
 

Constraints:

m == grid.length
n == grid[i].length
1 <= m, n <= 100
-100 <= grid[i][j] <= 100
*/

class Solution {
    public int countNegatives(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int res = 0;
        
        int left = 0, right = m-1;
        int row = m;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (grid[mid][0] < 0) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        if (grid[right][0] < 0) {
            row = right;
        }
        res += (m - row) * n;
        for (int i = 0; i < row; i++) {
            int index = findN(grid[i], 0, n-1);
            res += n - index;
        }
        return res;
    }
    
    private int findN(int[] nums, int s, int e) {
        while (s < e) {
            int mid = s + (e-s) / 2;
            if(nums[mid] < 0) {
                e = mid;
            } else {
                s = mid + 1;
            }
        }
        if (nums[e] < 0) {
            return e;
        } else {
            return nums.length;
        }
    }
}
