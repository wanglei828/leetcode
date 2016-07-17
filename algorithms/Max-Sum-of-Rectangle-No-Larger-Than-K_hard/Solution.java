/*
Given a non-empty 2D matrix matrix and an integer k, 
find the max sum of a rectangle in the matrix such that its sum is no larger than k.

Example:
Given matrix = [
  [1,  0, 1],
  [0, -2, 3]
]
k = 2
The answer is 2. Because the sum of rectangle [[0, 1], [-2, 3]] is 2 and 2 is the max number no larger than k (k = 2).

Note:
The rectangle inside the matrix must have an area > 0.
What if the number of rows is much larger than the number of columns?
*/

public class Solution {
    public int maxSumSubmatrix(int[][] matrix, int k) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int left = 0;
        int max=Integer.MIN_VALUE;
        for(;left<n; left++) {
            int[] sums = new int[m];
            for(int i=left; i<n; i++) {
                for(int j=0; j<m; j++) {
                    sums[j] += matrix[j][i];
                }
                TreeSet<Integer> set = new TreeSet<Integer>();
                set.add(0);
                int cursum = 0;
                for(int sum: sums) {
                    cursum += sum;
                    Integer cur = set.ceiling(cursum-k);
                    if(cur != null) {
                        max = Math.max(max, cursum-cur);
                    }
                    set.add(cursum);
                }
            }
        }
        return max;
    }
}
