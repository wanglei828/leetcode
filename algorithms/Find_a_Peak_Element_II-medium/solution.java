/*
A peak element in a 2D grid is an element that is strictly greater than all of its adjacent neighbors to the left, right, top, and bottom.

Given a 0-indexed m x n matrix mat where no two adjacent cells are equal, find any peak element mat[i][j] and return the length 2 array [i,j].

You may assume that the entire matrix is surrounded by an outer perimeter with the value -1 in each cell.

You must write an algorithm that runs in O(m log(n)) or O(n log(m)) time.

Input: mat = [[1,4],[3,2]]
Output: [0,1]
Explanation: Both 3 and 4 are peak elements so [1,0] and [0,1] are both acceptable answers.

Input: mat = [[10,20,15],[21,30,14],[7,16,32]]
Output: [1,1]
Explanation: Both 30 and 32 are peak elements so [1,1] and [2,2] are both acceptable answers.
 

Constraints:

m == mat.length
n == mat[i].length
1 <= m, n <= 500
1 <= mat[i][j] <= 105
No two adjacent cells are equal.
*/

class Solution {
    int m, n;
    public int[] findPeakGrid(int[][] mat) {
        m = mat.length;
        n = mat[0].length;
        if (m == 1) {
            int maxIndex = getMax(mat[0]);
            return new int[]{0, maxIndex};
        }
        int h = 0, t = m-1;
        while(h <= t) {
            int mid = h + (t-h)/2;
            int maxCol = getMax(mat[mid]);
            
            if (mid == 0 && mat[mid][maxCol] > mat[mid+1][maxCol]) {
                return new int[]{mid, maxCol};
            }
            
            if (mid == m-1 && mat[mid][maxCol] > mat[mid-1][maxCol]) {
                return new int[]{mid, maxCol};
            }
            if (mat[mid][maxCol] > mat[mid+1][maxCol] && mat[mid][maxCol] > mat[mid-1][maxCol]) {
                return new int[]{mid, maxCol};
            }
            
            if (mid > 0 && mat[mid][maxCol] < mat[mid-1][maxCol]) {
                t = mid - 1;
            }
            if (mid < m && mat[mid][maxCol] < mat[mid+1][maxCol]) {
                h = mid + 1;
            }
        }
        return new int[]{-1, -1};
    }
    
    private int getMax(int[] nums) {
        int max = 0;
        int index = 0;
        for (int i = 0; i< n; i++) {
            if (max < nums[i]) {
                max = nums[i];
                index = i;
            }
        }
        return index;
    }
}
